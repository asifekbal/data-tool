package org.asif.report.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.asif.report.service.ReportGeneratorSevice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReportAGeratorImplTest {

	ReportAGeratorImpl reportGerator = null;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetReportType() {
		List<String> list = Arrays.asList("Report Type A", "Report Type B", "Report Type C");
		ReportGeneratorSevice reportGeneratorSevice = mock(ReportGeneratorSevice.class);
		Mockito.when(reportGeneratorSevice.getReportTypes()).thenReturn(list);
		reportGerator = new ReportAGeratorImpl(reportGeneratorSevice);

		assertEquals(3, reportGerator.getReportType().size());

	}

}
