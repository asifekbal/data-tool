package org.oracle.data_tool;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oracle.data_tool.serviceimpl.AnalyticsCacheServiceImpl;
import org.oracle.data_tool.serviceimpl.AnalyticsServiceImpl;
import org.oracle.data_tool.utils.FileUtil;

public class AnalyticsTool {
	public static final Logger logger = LogManager.getLogger(AnalyticsTool.class);

	public static void main(String[] args) {

		AnalyticsServiceImpl analyticsServiceImpl = new AnalyticsServiceImpl(new AnalyticsCacheServiceImpl());
		String fileName = "input";
		List<String> list = FileUtil.readFile(fileName);
		logger.info("****REPORT GENERATION IS STARTED****");
		logger.info("Building cache service");
		analyticsServiceImpl.processReport(list);
		logger.info("Cache is built successfully");

		logger.info("Report Generation Step 1 of 4 started.");
		list = analyticsServiceImpl.genrateReportForUniqueCustomerIDPerContractID();
		FileUtil.writeFile(list);
		logger.info("Report Generation Step 1 of 4 completed.");

		logger.info("Report Generation Step 2 of 4 started.");
		list = analyticsServiceImpl.genrateReportForUniqueCustomerIDPerGeoZone();
		FileUtil.writeFile(list);
		logger.info("Report Generation Step 2 of 4 completed.");

		logger.info("Report Generation Step 3 of 4 started.");
		list = analyticsServiceImpl.genrateReportForAvgBuildTimePerGeoZone();
		FileUtil.writeFile(list);
		logger.info("Report Generation Step 3 of 4 completed.");

		logger.info("Report Generation Step 4 of 4 started.");
		list = analyticsServiceImpl.genrateReportForCustomerListPerGeoZone();
		FileUtil.writeFile(list);
		logger.info("Report Generation Step 4 of 4 completed.");

		logger.info("****REPORT GENERATION SUCCESSFULL NOW****");
	}
}