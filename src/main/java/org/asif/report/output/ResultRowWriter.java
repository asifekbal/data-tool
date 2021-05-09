package org.asif.report.output;

import java.io.IOException;

public interface ResultRowWriter {

	public void write(ResultRow r) throws IOException;

	public void close();
}
