package org.asif.report.output;

import java.util.List;

public interface OutputFactory {
	public void writeOutput(List<ResultRow> rows);
}
