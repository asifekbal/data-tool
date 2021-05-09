package org.asif.report.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResultRowWriterFactoryImpl implements ResultRowWriterFactory {

	public static final Logger logger = LogManager.getLogger(ResultRowWriterFactoryImpl.class);

	@Override
	public ResultRowWriter create(File file) {
		FileWriter fw = null;
		BufferedWriter buff = null;
		ResultRowWriter writer = null;
		try {
			fw = new FileWriter(file);
			buff = new BufferedWriter(fw);
			writer = new ResultRowWriterImpl(buff);
		} catch (Exception ex) {
			if (buff != null) {
				try {
					buff.close();
				} catch (IOException ex2) {
					logger.error(ex2.getMessage());
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException ex2) {
					logger.error(ex2.getMessage());
				}
			}
		}
		return writer;
	}
}
