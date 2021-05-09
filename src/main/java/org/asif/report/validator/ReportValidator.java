package org.asif.report.validator;

import java.util.List;

import org.asif.report.input.InputRow;

public interface ReportValidator {
	public boolean validate(List<InputRow> rows);
}
