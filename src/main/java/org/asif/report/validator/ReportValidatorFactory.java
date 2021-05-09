package org.asif.report.validator;

import org.asif.report.ReportTypeEnum;

public class ReportValidatorFactory {

	private ReportValidatorFactory() {

	}

	public static ReportValidator create(ReportTypeEnum reportTypeEnum) {
		ReportValidator reportValidator = null;
		if (reportTypeEnum == ReportTypeEnum.REPORT_TYPE_A) {
			reportValidator = new ReportAValidator();
		} else if (reportTypeEnum == ReportTypeEnum.REPORT_TYPE_B) {
			reportValidator = new ReportBValidator();
		} else if (reportTypeEnum == ReportTypeEnum.REPORT_TYPE_C) {
			reportValidator = new ReportCValidator();
		} else if (reportTypeEnum == ReportTypeEnum.REPORT_TYPE_D) {
			reportValidator = new ReportDValidator();
		}
		return reportValidator;
	}
}