package org.asif.report.service;

import java.util.ArrayList;
import java.util.List;

import org.asif.report.ReportTypeEnum;

public class ReportGeneratorServiceImpl implements ReportGeneratorSevice {

	@Override
	public List<String> getReportTypes() {
		List<String> list = new ArrayList<>();
		for (ReportTypeEnum reportType : ReportTypeEnum.values()) {
			list.add(reportType.toString());
		}
		return list;
	}

}
