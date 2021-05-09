package org.asif.report.output;

import java.io.File;

public interface ResultRowWriterFactory {
	public ResultRowWriter create(File file);
}

