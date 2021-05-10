package org.asif.report.validator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.asif.report.input.InputRow;
import org.asif.report.input.InputRowImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportAValidatorTest {

	ReportValidator reportValidator = null;
	List<InputRow> rows = null;
	List<InputRow> rows1 = null;

	@BeforeEach
	void setUp() throws Exception {
		rows = new ArrayList<>();
		rows1 = new ArrayList<>();
		InputRow row = new InputRowImpl("2343225", "2345", "us_east", "RedTeam", "ProjectApple", "3445s");
		InputRow row1 = new InputRowImpl("2343225", "2345", "us_east", "RedTeam", "ProjectApple", "3445");
		rows.add(row);
		rows1.add(row1);
		reportValidator = new ReportAValidator();

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testValidate01() {
		assertTrue(reportValidator.validate(rows));
	}

	@Test
	void testValidate02() {
		assertTrue(reportValidator.validate(rows1));
	}

}
