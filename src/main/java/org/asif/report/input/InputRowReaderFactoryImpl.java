package org.asif.report.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputRowReaderFactoryImpl implements InputRowReaderFactory {

	public static final Logger logger = LogManager.getLogger(InputRowReaderFactoryImpl.class);

	@Override
	public InputRowReader create(File file) {
		FileReader fr = null;
		BufferedReader buff = null;
		InputRowReader reader = null;
		try {
			fr = new FileReader(file);
			buff = new BufferedReader(fr);
			reader = new InputRowReaderImpl(buff);
		} catch (Exception ex) {
			if (buff != null) {
				try {
					buff.close();
				} catch (IOException ex2) {
					logger.error(ex2.getMessage());
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException ex2) {
					logger.error(ex2.getMessage());
				}
			}
		}
		return reader;
	}
}