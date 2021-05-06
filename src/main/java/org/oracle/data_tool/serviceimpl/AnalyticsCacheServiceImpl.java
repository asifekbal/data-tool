package org.oracle.data_tool.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author asifekbal
 *
 */
public class AnalyticsCacheServiceImpl {

	public static final Logger logger = LogManager.getLogger(AnalyticsCacheServiceImpl.class);
	private Map<String, Set<String>> map1 = null; // Map to store customer ID per contract ID
	private Map<String, Set<String>> map2 = null; // Map to store customer ID per Geo Code
	private Map<String, List<Integer>> map3 = null; // Map to store build time per Geo Code

	public AnalyticsCacheServiceImpl() {
		map1 = new HashMap<>();
		map2 = new HashMap<>();
		map3 = new HashMap<>();
	}

	/**
	 * @param contractId
	 * @param customerId
	 * @return Map with contractId as key and Set of customerId as value
	 */
	public Map<String, Set<String>> populateContractMap(String contractId, String customerId) {
		Set<String> valueSet = this.map1.get(contractId);
		if (valueSet == null) {
			Set<String> set = new HashSet<>();
			set.add(customerId);
			this.map1.put(contractId, set);
		} else {
			valueSet.add(customerId);
			this.map1.put(contractId, valueSet);
		}
		return this.map1;
	}

	/**
	 * @param geoId
	 * @param customerId
	 * @return Map with geoId as key and Set of customerId as value
	 */
	public Map<String, Set<String>> populateGeoMap(String geoId, String customerId) {
		Set<String> valueSet = this.map2.get(geoId);
		if (valueSet == null) {
			Set<String> set = new HashSet<>();
			set.add(customerId);
			this.map2.put(geoId, set);
		} else {
			valueSet.add(customerId);
			this.map2.put(geoId, valueSet);
		}
		return this.map2;
	}

	/**
	 * @param geoId
	 * @param buildTime
	 * @return Map with geoId as key and List of Size 2 as value. First value of
	 *         list is count and second value is sum of all build time for a
	 *         specific geo code.
	 */
	public Map<String, List<Integer>> populateBuildMap(String geoId, String buildTime) {
		List<Integer> list = this.map3.get(geoId);
		List<Integer> newlist = new ArrayList<>();
		String time = buildTime.substring(0, buildTime.length() - 1);
		if (list == null) {
			newlist.add(1);
			newlist.add(Integer.parseInt(time));
		} else {
			int count = list.get(0);
			int sum = list.get(1);
			newlist.add(count + 1);
			newlist.add(sum + Integer.parseInt(time));
		}
		this.map3.put(geoId, newlist);
		return this.map3;
	}

}
