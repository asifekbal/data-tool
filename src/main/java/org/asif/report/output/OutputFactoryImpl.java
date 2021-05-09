package org.asif.report.output;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.asif.report.ReportTypeEnum;
import org.asif.report.util.ReportFileFactory;
import org.asif.report.util.ReportFileFactoryImpl;

public class OutputFactoryImpl implements OutputFactory {

	private ResultRowWriterFactory writerFactory;
	private ReportFileFactory fileFactory;

	public OutputFactoryImpl(ReportTypeEnum reportTypeEnum) {
		super();
		this.writerFactory = new ResultRowWriterFactoryImpl();
		this.fileFactory = new ReportFileFactoryImpl(reportTypeEnum);
	}

	@Override
	public void writeOutput(List<ResultRow> rows) {
		File file = fileFactory.createResultFile();
		ResultRowWriter writer = writerFactory.create(file);
		try {
			for (ResultRow row : rows) {
				writer.write(row);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
