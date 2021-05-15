package org.asif.report.generator;

import org.asif.report.ReportTypeEnum;

public class ReportFactory {

	private ReportFactory() {

	}

	public static ReportGerator create(ReportTypeEnum reportTypeEnum) {
		ReportGerator reportGerator = null;
		if (reportTypeEnum == ReportTypeEnum.REPORT_TYPE_A) {
			reportGerator = new ReportAGeratorImpl(null);
		} else if (reportTypeEnum == ReportTypeEnum.REPORT_TYPE_B) {
			reportGerator = new ReportBGeratorImpl();
		} else if (reportTypeEnum == ReportTypeEnum.REPORT_TYPE_C) {
			reportGerator = new ReportCGeratorImpl();
		} else if (reportTypeEnum == ReportTypeEnum.REPORT_TYPE_D) {
			reportGerator = new ReportDGeratorImpl();
		}
		return reportGerator;
	}
}