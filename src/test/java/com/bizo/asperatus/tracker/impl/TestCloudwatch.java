package com.bizo.asperatus.tracker.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;

public final class TestCloudwatch extends AbstractCloudwatch {

  final ConcurrentHashMap<String, List<Aggregation>> aggregations = new ConcurrentHashMap<String, List<Aggregation>>();

  @Override
  public void putMetricData(final PutMetricDataRequest putMetricDataRequest) {
    List<Aggregation> existing = aggregations.get(putMetricDataRequest.getNamespace());
    if (existing == null) {
      List<Aggregation> potential = new CopyOnWriteArrayList<Aggregation>();
      existing = aggregations.putIfAbsent(putMetricDataRequest.getNamespace(), potential);
      if (existing == null) {
        existing = potential;
      }
    }
    existing.addAll(AggregationUtils.toAggregation(putMetricDataRequest.getMetricData()));
  }
}