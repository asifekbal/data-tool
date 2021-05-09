package org.asif.report.input;

import java.io.File;

public interface InputRowReaderFactory {

	public InputRowReader create(File file);
}
