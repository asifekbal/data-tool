package org.oracle.data_tool.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oracle.data_tool.service.AnalyticsService;

/**
 * @author asifekbal
 *
 */
public class AnalyticsServiceImpl implements AnalyticsService {

	public static final Logger logger = LogManager.getLogger(AnalyticsServiceImpl.class);

	private AnalyticsCacheServiceImpl cacheServiceImpl;

	public AnalyticsServiceImpl(AnalyticsCacheServiceImpl cacheServiceImpl) {
		this.cacheServiceImpl = cacheServiceImpl;
	}

	Map<String, Set<String>> contractMap = new HashMap<>();
	Map<String, Set<String>> geoMap = new HashMap<>();
	Map<String, List<Integer>> buildMap = new HashMap<>();

	/**
	 * @param list - A list of string , where each string is a line process all
	 *             lines and prepares cache in form of HashMap tostore relevant
	 *             informations.
	 */
	@Override
	public void processReport(List<String> list) {
		logger.info("Started writing input to Cache Service");
		for (String str : list) {
			String[] parts = str.split(",");
			contractMap = cacheServiceImpl.populateContractMap(parts[1], parts[0]);
			geoMap = cacheServiceImpl.populateGeoMap(parts[2], parts[0]);
			buildMap = cacheServiceImpl.populateBuildMap(parts[2], parts[5]);
		}
		logger.info("Cache Service initialised successfully");
	}

	/**
	 * @returns List of String where each string represents a single line of final
	 *          output of report
	 */
	@Override
	public List<String> genrateReportForUniqueCustomerIDPerContractID() {
		List<String> list = new ArrayList<>();
		list.add("\n*********** REPORT 001 **************");
		list.add("Contract ID " + "\t\t" + "No of Unique Customers");
		logger.info("Started generating report 1");
		for (Map.Entry<String, Set<String>> entry : contractMap.entrySet()) {
			list.add(entry.getKey() + "\t\t\t\t" + entry.getValue().size());
		}
		logger.info("Completed generating report 1");
		return list;
	}

	/**
	 * @return List of String where each string represents a single line of final
	 *         output of report
	 */
	@Override
	public List<String> genrateReportForUniqueCustomerIDPerGeoZone() {
		List<String> list = new ArrayList<>();
		list.add("\n\n\n*********** REPORT 002 **************");
		list.add("Geo Zone " + "\t\t\t" + "No of Unique Customers");
		logger.info("Started generating report 2");
		for (Map.Entry<String, Set<String>> entry : geoMap.entrySet()) {
			list.add(entry.getKey() + "\t\t\t\t" + entry.getValue().size());
		}
		logger.info("Completed generating report 2");
		return list;
	}

	/**
	 * @return List of String where each string represents a single line of final
	 *         output of report
	 */
	@Override
	public List<String> genrateReportForAvgBuildTimePerGeoZone() {
		List<String> list = new ArrayList<>();
		list.add("\n\n\n*********** REPORT 003 **************");
		list.add("Geo Zone " + "\t\t\t" + "AVG Build Time");
		logger.info("Started generating report 3");
		for (Map.Entry<String, List<Integer>> entry : buildMap.entrySet()) {
			List<Integer> val = entry.getValue();
			list.add(entry.getKey() + "\t\t\t\t" + (val.get(1) / val.get(0)) + " sec");
		}
		logger.info("Completed generating report 3");
		return list;
	}

	/**
	 * @return List of String where each string represents a single line of final
	 *         output of report
	 */
	@Override
	public List<String> genrateReportForCustomerListPerGeoZone() {
		List<String> list = new ArrayList<>();
		list.add("\n\n\n*********** REPORT 004 **************");
		list.add("Geo Zone " + "\t\t\t" + "Customer IDs");
		logger.info("Started generating report 4");
		for (Map.Entry<String, Set<String>> entry : geoMap.entrySet()) {
			list.add(entry.getKey() + "\t\t\t\t" + entry.getValue().toString());
		}
		logger.info("Completed generating report 4");
		return list;
	}

}