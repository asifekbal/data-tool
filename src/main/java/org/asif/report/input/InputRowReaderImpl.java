package org.asif.report.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputRowReaderImpl implements InputRowReader {

	public static final Logger logger = LogManager.getLogger(InputRowReaderImpl.class);

	private static final String COL_SEPARATOR = ",";
	private final BufferedReader reader;

	public InputRowReaderImpl(BufferedReader reader) {
		super();
		this.reader = reader;
	}

	@Override
	public List<InputRow> read() throws IOException {
		List<InputRow> rows = new ArrayList<>();
		try {
			logger.info("Reading input file");
			String st = null;
			while ((st = reader.readLine()) != null) {
				String[] s = st.split(COL_SEPARATOR);
				InputRow row = new InputRowImpl(s[0], s[1], s[2], s[3], s[4], s[5]);
				rows.add(row);
			}
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		}
		return rows;
	}

	@Override
	public void close() {
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException ex) {
				logger.error(ex.getMessage());
			}
		}
	}
}