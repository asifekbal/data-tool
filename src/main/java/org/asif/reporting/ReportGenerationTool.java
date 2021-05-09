package org.asif.reporting;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.asif.report.generator.ReportFactory;
import org.asif.report.generator.ReportGerator;
import org.asif.report.input.InputFactory;
import org.asif.report.input.InputFactoryImpl;
import org.asif.report.input.InputRow;
import org.asif.report.output.OutputFactory;
import org.asif.report.output.OutputFactoryImpl;
import org.asif.report.output.ResultRow;
import org.asif.report.validator.ReportValidator;
import org.asif.report.validator.ReportValidatorFactory;

public class ReportGenerationTool {
	public static final Logger logger = LogManager.getLogger(ReportGenerationTool.class);

	public static void main(String[] args) {

		logger.info("****REPORT GENERATION IS STARTED****");

		InputFactory inputFactory = new InputFactoryImpl(ReportTypeEnum.NONE);
		List<InputRow> rows = inputFactory.readInput();

		logger.info("Report Generation Step 1 of 4 started.");
		ReportValidator reportValidator = ReportValidatorFactory.create(ReportTypeEnum.REPORT_TYPE_A);
		if (!reportValidator.validate(rows)) {
			logger.error("Error in Input Data of Report Type A ");
		}
		ReportGerator reportGerator = ReportFactory.create(ReportTypeEnum.REPORT_TYPE_A);
		List<ResultRow> results = reportGerator.processReport(rows);
		OutputFactory outputFactory = new OutputFactoryImpl(ReportTypeEnum.REPORT_TYPE_A);
		outputFactory.writeOutput(results);
		logger.info("Report Generation Step 1 of 4 completed.");

		logger.info("Report Generation Step 2 of 4 started.");
		reportValidator = ReportValidatorFactory.create(ReportTypeEnum.REPORT_TYPE_B);
		if (!reportValidator.validate(rows)) {
			logger.error("Error in Input Data of Report Type B ");
		}
		reportGerator = ReportFactory.create(ReportTypeEnum.REPORT_TYPE_B);
		results = reportGerator.processReport(rows);
		outputFactory = new OutputFactoryImpl(ReportTypeEnum.REPORT_TYPE_B);
		outputFactory.writeOutput(results);
		logger.info("Report Generation Step 2 of 4 completed.");

		logger.info("Report Generation Step 3 of 4 started.");
		reportValidator = ReportValidatorFactory.create(ReportTypeEnum.REPORT_TYPE_C);
		if (!reportValidator.validate(rows)) {
			logger.error("Error in Input Data of Report Type C ");
		}
		reportGerator = ReportFactory.create(ReportTypeEnum.REPORT_TYPE_C);
		results = reportGerator.processReport(rows);
		outputFactory = new OutputFactoryImpl(ReportTypeEnum.REPORT_TYPE_C);
		outputFactory.writeOutput(results);
		logger.info("Report Generation Step 3 of 4 completed.");

		logger.info("Report Generation Step 4 of 4 started.");
		reportValidator = ReportValidatorFactory.create(ReportTypeEnum.REPORT_TYPE_D);
		if (!reportValidator.validate(rows)) {
			logger.error("Error in Input Data of Report Type D ");
		}
		reportGerator = ReportFactory.create(ReportTypeEnum.REPORT_TYPE_D);
		results = reportGerator.processReport(rows);
		outputFactory = new OutputFactoryImpl(ReportTypeEnum.REPORT_TYPE_D);
		outputFactory.writeOutput(results);
		logger.info("Report Generation Step 4 of 4 completed.");

		logger.info("****REPORT GENERATION SUCCESSFULL NOW****");
	}
}