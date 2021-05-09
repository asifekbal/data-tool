package org.asif.report.input;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.asif.report.util.ReportFileFactory;
import org.asif.report.util.ReportFileFactoryImpl;
import org.asif.reporting.ReportTypeEnum;

public class InputFactoryImpl implements InputFactory {

	private InputRowReaderFactory readerFactory;
	private ReportFileFactory fileFactory;

	public InputFactoryImpl(ReportTypeEnum reportTypeEnum) {
		super();
		this.readerFactory = new InputRowReaderFactoryImpl();
		this.fileFactory = new ReportFileFactoryImpl(reportTypeEnum);
	}

	@Override
	public List<InputRow> readInput() {
		File file = fileFactory.createInputFile();
		InputRowReader reader = readerFactory.create(file);
		List<InputRow> rows = null;
		try {
			rows = reader.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reader.close();
		return rows;
	}
}
