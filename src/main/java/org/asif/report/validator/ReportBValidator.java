package org.asif.report.validator;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.asif.report.input.InputRow;

public class ReportBValidator implements ReportValidator {

	@Override
	public boolean validate(List<InputRow> rows) {
		for (InputRow row : rows) {
			if (StringUtils.isEmpty(row.getGeoZone()) || !StringUtils.isAsciiPrintable(row.getGeoZone())) {
				return false;
			}
			if (StringUtils.isEmpty(row.getCustomerID()) || !StringUtils.isNumeric(row.getCustomerID())) {
				return false;
			}
		}
		return true;
	}
}