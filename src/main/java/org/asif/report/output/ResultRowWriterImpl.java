package org.asif.report.output;

import java.io.BufferedWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResultRowWriterImpl implements ResultRowWriter {

	public static final Logger logger = LogManager.getLogger(ResultRowWriterImpl.class);

	private static final String COL_SEPARATOR = ",";
	private static final String LINE_SEPARATOR = "\n";
	private final BufferedWriter writer;
	private static boolean header = true;

	public ResultRowWriterImpl(BufferedWriter writer) {
		super();
		this.writer = writer;

	}

	@Override
	public void write(ResultRow row) throws IOException {
		if (header) {
			String[] headers = row.getHeaders();
			writer.write(headers[0]);
			writer.write(COL_SEPARATOR);
			writer.write(headers[1]);
			writer.write(LINE_SEPARATOR);
			header = false;
		}
		String[] cols = row.getValues();
		writer.write(cols[0]);
		writer.write(COL_SEPARATOR);
		writer.write(cols[1]);
		writer.write(LINE_SEPARATOR);
	}

	@Override
	public void close() {
		header = true;
		if (writer != null) {
			try {
				writer.close();
			} catch (IOException ex) {
				logger.error(ex.getMessage());
			}
		}
	}

}
