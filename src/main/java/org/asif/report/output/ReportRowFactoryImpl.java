package org.asif.report.output;

import org.asif.reporting.ReportTypeEnum;

public class ReportRowFactoryImpl implements ReportRowFactory {

	private ReportTypeEnum reportType;

	public ReportRowFactoryImpl(ReportTypeEnum reportType) {
		super();
		this.reportType = reportType;
	}

	@Override
	public ResultRow create(String str1, String str2) {
		ResultRow resultRow = null;
		if (reportType == ReportTypeEnum.REPORT_TYPE_A) {
			resultRow = new ReportAResultRowImpl(str1, str2);
		} else if (reportType == ReportTypeEnum.REPORT_TYPE_B) {
			resultRow = new ReportBResultRowImpl(str1, str2);
		} else if (reportType == ReportTypeEnum.REPORT_TYPE_C) {
			resultRow = new ReportCResultRowImpl(str1, str2);
		} else if (reportType == ReportTypeEnum.REPORT_TYPE_D) {
			resultRow = new ReportDResultRowImpl(str1, str2);
		}
		return resultRow;
	}
}