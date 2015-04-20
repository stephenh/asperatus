package com.bizo.asperatus.tracker;

import java.util.List;

import com.bizo.asperatus.model.CompoundDimension;
import com.bizo.asperatus.model.Dimension;
import com.bizo.asperatus.model.Unit;
import com.google.common.collect.Lists;

/**
 * Simple abstract parent to forward track calls without a unit, or with simple dimensions.
 * 
 * Subclasses must only implement:
 * 
 *   void track(String metricName, Number value, Unit unit, Collection<CompoundDimension> dimensions);
 */
public abstract class AbstractMetricTracker implements MetricTracker {
  @Override
  public void track(final String metricName, final Number value, final List<Dimension> dimensions) {
    track(metricName, value, Unit.Count, dimensions);
  }
  
  @Override
  public void track(final String metricName, final Number value, final Unit unit, final List<Dimension> dimensions) {
    // Tracking with no dimensions doesn't really make sense, but tests might do it
    // (if the default machine info is empty because the environment variables are
    // missing), so go ahead and trust the caller knows what they're doing and pass
    // this through as a similarly-empty CompoundDimension.
    if (dimensions.isEmpty()) {
      track(metricName, value, unit, Lists.newArrayList(new CompoundDimension()));
    }
    for (final Dimension d : dimensions) {
      track(metricName, value, unit, Lists.newArrayList(new CompoundDimension(d)));
    }
  }
  
  @Override
  public void close() {
    
  }
}
