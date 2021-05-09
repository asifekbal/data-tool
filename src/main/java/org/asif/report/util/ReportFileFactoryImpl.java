package org.asif.report.util;

import java.io.File;

import org.asif.reporting.ReportTypeEnum;

public class ReportFileFactoryImpl implements ReportFileFactory {

	private static final String ROOT_DIRECTORY = "/Users/asifekbal/git/workspace/data-tool/";
	private static final String DOT = ".";
	private static final String INPUT_FILE_NAME = "INPUT";
	private static final String INPUT_FILE_EXT = "TXT";
	private static final String OUTPUT_FILE_NAME = "_OUTPUT";
	private static final String OUTPUT_FILE_EXT = "CSV";
	private ReportTypeEnum reportTypeEnum;

	public ReportFileFactoryImpl(ReportTypeEnum reportTypeEnum) {
		super();
		this.reportTypeEnum = reportTypeEnum;
	}

	@Override
	public File createResultFile() {
		StringBuilder sb = new StringBuilder(ROOT_DIRECTORY);
		sb.append(reportTypeEnum.toString() + OUTPUT_FILE_NAME);
		sb.append(DOT);
		sb.append(OUTPUT_FILE_EXT);
		return new File(sb.toString());
	}

	@Override
	public File createInputFile() {
		StringBuilder sb = new StringBuilder(ROOT_DIRECTORY);
		sb.append(INPUT_FILE_NAME);
		sb.append(DOT);
		sb.append(INPUT_FILE_EXT);
		return new File(sb.toString());
	}

}
