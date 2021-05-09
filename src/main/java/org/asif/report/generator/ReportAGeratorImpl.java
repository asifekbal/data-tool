package org.asif.report.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.asif.report.input.InputRow;
import org.asif.report.output.ReportRowFactory;
import org.asif.report.output.ReportRowFactoryImpl;
import org.asif.report.output.ResultRow;
import org.asif.report.pojo.Contract;
import org.asif.report.pojo.Customer;
import org.asif.reporting.ReportTypeEnum;

public class ReportAGeratorImpl implements ReportGerator {

	public static final Logger logger = LogManager.getLogger(ReportAGeratorImpl.class);
	private Map<Contract, Set<Customer>> map = null;

	public ReportAGeratorImpl() {
		super();
	}

	@Override
	public List<ResultRow> processReport(List<InputRow> rows) {
		List<ResultRow> results = new ArrayList<>();
		ReportRowFactory reportRowFactory = new ReportRowFactoryImpl(ReportTypeEnum.REPORT_TYPE_A);
		map = processInputData(rows);
		logger.info("Started generating report A");
		for (Map.Entry<Contract, Set<Customer>> entry : map.entrySet()) {
			Contract contract = entry.getKey();
			Set<Customer> set = entry.getValue();
			ResultRow result = reportRowFactory.create(contract.getContractId(), String.valueOf(set.size()));
			results.add(result);
		}
		logger.info("Completed generating report A");
		return results;
	}

	private Map<Contract, Set<Customer>> processInputData(List<InputRow> rows) {
		Map<Contract, Set<Customer>> map = new HashMap<>();
		logger.info("Started writing into Map");
		for (InputRow row : rows) {
			Contract contract = new Contract(row.getContractID());
			Customer customer = new Customer(row.getCustomerID());
			Set<Customer> set = map.get(contract);
			if (set == null) {
				Set<Customer> newset = new HashSet<>();
				newset.add(customer);
				map.put(contract, newset);
			} else {
				set.add(customer);
				map.put(contract, set);
			}
		}
		logger.info("Map initialised successfully");
		return map;
	}

}
