package org.asif.report.validator;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.asif.report.input.InputRow;

public class ReportAValidator implements ReportValidator {

	@Override
	public boolean validate(List<InputRow> rows) {
		for (InputRow row : rows) {
			if (StringUtils.isEmpty(row.getContractID()) || !StringUtils.isNumeric(row.getContractID())) {
				return false;
			}
			if (StringUtils.isEmpty(row.getCustomerID()) || !StringUtils.isNumeric(row.getCustomerID())) {
				return false;
			}
		}
		return true;
	}

}
