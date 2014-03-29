package com.bizo.asperatus.tracker.impl.buffer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bizo.asperatus.model.CompoundDimension;
import com.bizo.asperatus.model.Unit;
import com.bizo.asperatus.tracker.AbstractMetricTracker;
import com.bizo.asperatus.tracker.impl.MetricKey;
import com.bizo.asperatus.tracker.impl.MetricStatistics;

/**
 * Track and aggregate metrics in-memory.
 */
public final class InMemoryTracker extends AbstractMetricTracker implements MetricBuffer {
  private final AtomicReference<Map<MetricKey, MetricStatistics>> stats =
    new AtomicReference<Map<MetricKey, MetricStatistics>>(new HashMap<MetricKey, MetricStatistics>());

  private static final Logger log = LoggerFactory.getLogger(InMemoryTracker.class);

  @Override
  public synchronized void track(
      final String metricName,
      final Number value,
      final Unit unit,
      final Collection<CompoundDimension> dimensions) {
    log.debug("Logging " + metricName + " = " + value + " " + unit);
    for (final CompoundDimension d : dimensions) {
      getOrCreateStats(new MetricKey(metricName, d), unit).add(value);
    }
  }

  private MetricStatistics getOrCreateStats(final MetricKey key, final Unit unit) {
    MetricStatistics s = stats.get().get(key);
    if (s == null) {
      s = new MetricStatistics(unit);
      stats.get().put(key, s);
    }
    return s;
  }

  public synchronized Map<MetricKey, MetricStatistics> reset() {
    return stats.getAndSet(new HashMap<MetricKey, MetricStatistics>());
  }
}
