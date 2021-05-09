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
import org.asif.report.pojo.Build;
import org.asif.report.pojo.Geozone;
import org.asif.reporting.ReportTypeEnum;

public class ReportCGeratorImpl implements ReportGerator {

	public static final Logger logger = LogManager.getLogger(ReportCGeratorImpl.class);
	private Map<Geozone, Set<Build>> map = null;

	public ReportCGeratorImpl() {
		super();
	}

	@Override
	public List<ResultRow> processReport(List<InputRow> rows) {
		List<ResultRow> results = new ArrayList<>();
		ReportRowFactory reportRowFactory = new ReportRowFactoryImpl(ReportTypeEnum.REPORT_TYPE_C);
		map = processInputData(rows);
		logger.info("Started generating report C");
		for (Map.Entry<Geozone, Set<Build>> entry : map.entrySet()) {
			Geozone geozone = entry.getKey();
			int total = 0;
			int count = 0;
			Set<Build> set = entry.getValue();
			for (Build b : set) {
				total += Integer.parseInt(b.getBuildtime());
				count++;
			}
			ResultRow result = reportRowFactory.create(geozone.getGeozone(), String.valueOf(total / count));
			results.add(result);
		}
		logger.info("Completed generating report C");
		return results;
	}

	private Map<Geozone, Set<Build>> processInputData(List<InputRow> rows) {
		Map<Geozone, Set<Build>> map = new HashMap<>();
		logger.info("Started writing into Map");
		for (InputRow row : rows) {
			Geozone geozone = new Geozone(row.getGeoZone());
			Build build = new Build(row.getBuildDuration());
			Set<Build> set = map.get(geozone);
			if (set == null) {
				Set<Build> newset = new HashSet<>();
				newset.add(build);
				map.put(geozone, newset);
			} else {
				set.add(build);
				map.put(geozone, set);
			}
		}
		logger.info("Map initialised successfully");
		return map;
	}

}
