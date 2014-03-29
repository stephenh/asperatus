package com.bizo.asperatus.tracker.impl;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.model.*;

/**
 * Throws UnsupportedOperationException for everything.
 */
public class AbstractCloudwatch implements AmazonCloudWatch {
  @Override
  public void setEndpoint(final String endpoint) throws IllegalArgumentException {
    throw new UnsupportedOperationException();
  }

  @Override
  public void putMetricAlarm(final PutMetricAlarmRequest putMetricAlarmRequest)
      throws AmazonServiceException,
      AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public void putMetricData(final PutMetricDataRequest putMetricDataRequest)
      throws AmazonServiceException,
      AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public ListMetricsResult listMetrics(final ListMetricsRequest listMetricsRequest)
      throws AmazonServiceException,
      AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public GetMetricStatisticsResult getMetricStatistics(final GetMetricStatisticsRequest getMetricStatisticsRequest)
      throws AmazonServiceException,
      AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public void disableAlarmActions(final DisableAlarmActionsRequest disableAlarmActionsRequest)
      throws AmazonServiceException,
      AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public DescribeAlarmsResult describeAlarms(final DescribeAlarmsRequest describeAlarmsRequest)
      throws AmazonServiceException,
      AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public DescribeAlarmsForMetricResult describeAlarmsForMetric(
      final DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest)
      throws AmazonServiceException,
      AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public DescribeAlarmHistoryResult describeAlarmHistory(final DescribeAlarmHistoryRequest describeAlarmHistoryRequest)
      throws AmazonServiceException,
      AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public void enableAlarmActions(final EnableAlarmActionsRequest enableAlarmActionsRequest)
      throws AmazonServiceException,
      AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public void deleteAlarms(final DeleteAlarmsRequest deleteAlarmsRequest)
      throws AmazonServiceException,
      AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setAlarmState(final SetAlarmStateRequest setAlarmStateRequest)
      throws AmazonServiceException,
      AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public ListMetricsResult listMetrics() throws AmazonServiceException, AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public DescribeAlarmsResult describeAlarms() throws AmazonServiceException, AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public DescribeAlarmHistoryResult describeAlarmHistory() throws AmazonServiceException, AmazonClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public void shutdown() {
    throw new UnsupportedOperationException();
  }

  @Override
  public ResponseMetadata getCachedResponseMetadata(final AmazonWebServiceRequest request) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setRegion(final Region arg0) throws IllegalArgumentException {
  }
}
