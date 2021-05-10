package org.asif.report.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.asif.report.input.InputRow;
import org.asif.report.input.InputRowImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportCValidatorTest {

	static ReportValidator reportValidator = null;
	List<InputRow> rows = null;
	List<InputRow> rows1 = null;

	@BeforeAll
	static void init() {
		reportValidator = new ReportCValidator();
	}

	@BeforeEach
	void setUp() throws Exception {
		rows = new ArrayList<>();
		rows1 = new ArrayList<>();
		InputRow row = new InputRowImpl("2343225", "2345", "us_east", "RedTeam", "ProjectApple", "3445s");
		InputRow row1 = new InputRowImpl("2343225", "2345", "us_east", "RedTeam", "ProjectApple", "3445");
		rows.add(row);
		rows1.add(row1);

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
		assertFalse(reportValidator.validate(rows1));
	}

}
