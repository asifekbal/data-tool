package org.asif.report.validator;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.asif.report.input.InputRow;

public class ReportCValidator implements ReportValidator {

	@Override
	public boolean validate(List<InputRow> rows) {
		for (InputRow row : rows) {
			if (StringUtils.isEmpty(row.getGeoZone()) || !StringUtils.isAsciiPrintable(row.getGeoZone())) {
				return false;
			}
			if (StringUtils.isEmpty(row.getBuildDuration()) || !StringUtils.isAlphanumeric(row.getBuildDuration())) {
				return false;
			}
			String str = row.getBuildDuration();
			String duration = str.substring(0, str.length() - 1);
			if (!StringUtils.isNumeric(duration)) {
				return false;
			}
		}
		return true;
	}

}
