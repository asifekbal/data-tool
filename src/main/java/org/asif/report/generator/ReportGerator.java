package org.asif.report.generator;

import java.util.List;

import org.asif.report.input.InputRow;
import org.asif.report.output.ResultRow;

public interface ReportGerator {

	public List<ResultRow> processReport(List<InputRow> rows);
}
