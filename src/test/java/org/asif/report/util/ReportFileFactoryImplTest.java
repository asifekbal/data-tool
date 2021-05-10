package org.asif.report.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.asif.report.ReportTypeEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportFileFactoryImplTest {

	ReportTypeEnum typeEnum = null;
	ReportFileFactory fileFactory = null;

	@BeforeEach
	void setUp() throws Exception {
		typeEnum = ReportTypeEnum.NONE;

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testResultFile() {
		fileFactory = new ReportFileFactoryImpl(null);
		assertThrows(NullPointerException.class, () -> fileFactory.createResultFile());
	}
}