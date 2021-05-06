package org.oracle.data_tool.service;

import java.util.List;

/**
 * @author asifekbal
 *
 */
public interface AnalyticsService {

	public void processReport(List<String> list);

	public List<String> genrateReportForUniqueCustomerIDPerContractID();

	public List<String> genrateReportForUniqueCustomerIDPerGeoZone();

	public List<String> genrateReportForAvgBuildTimePerGeoZone();

	public List<String> genrateReportForCustomerListPerGeoZone();

}
