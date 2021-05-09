package org.asif.report.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.asif.report.ReportTypeEnum;
import org.asif.report.input.InputRow;
import org.asif.report.output.ReportRowFactory;
import org.asif.report.output.ReportRowFactoryImpl;
import org.asif.report.output.ResultRow;
import org.asif.report.pojo.Customer;
import org.asif.report.pojo.Geozone;

public class ReportDGeratorImpl implements ReportGerator {

	public static final Logger logger = LogManager.getLogger(ReportDGeratorImpl.class);
	private Map<Geozone, Set<Customer>> map = null;

	public ReportDGeratorImpl() {
		super();
	}

	@Override
	public List<ResultRow> processReport(List<InputRow> rows) {
		List<ResultRow> results = new ArrayList<>();
		ReportRowFactory reportRowFactory = new ReportRowFactoryImpl(ReportTypeEnum.REPORT_TYPE_D);
		map = processInputData(rows);
		logger.info("Started generating report D");
		for (Map.Entry<Geozone, Set<Customer>> entry : map.entrySet()) {
			Geozone geozone = entry.getKey();
			Set<Customer> set = entry.getValue();
			StringBuilder sb = new StringBuilder();
			for (Customer c : set) {
				sb.append(c.getCustomerId() + "  ");
			}
			ResultRow result = reportRowFactory.create(geozone.getGeozone(), sb.toString());
			results.add(result);
		}
		logger.info("Completed generating report D");
		return results;
	}

	private Map<Geozone, Set<Customer>> processInputData(List<InputRow> rows) {
		Map<Geozone, Set<Customer>> map = new HashMap<>();
		logger.info("Started writing into Map");
		for (InputRow row : rows) {
			Geozone geozone = new Geozone(row.getGeoZone());
			Customer customer = new Customer(row.getCustomerID());
			Set<Customer> set = map.get(geozone);
			if (set == null) {
				Set<Customer> newset = new HashSet<>();
				newset.add(customer);
				map.put(geozone, newset);
			} else {
				set.add(customer);
				map.put(geozone, set);
			}
		}
		logger.info("Map initialised successfully");
		return map;
	}

}
