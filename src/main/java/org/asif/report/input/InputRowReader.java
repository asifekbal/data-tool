package org.asif.report.input;

import java.io.IOException;
import java.util.List;

public interface InputRowReader {

	public List<InputRow> read() throws IOException;

	public void close();
}
