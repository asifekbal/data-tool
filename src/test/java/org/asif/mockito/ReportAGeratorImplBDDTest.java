package org.asif.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.*;
import java.util.Arrays;
import java.util.List;

import org.asif.report.generator.ReportAGeratorImpl;
import org.asif.report.service.ReportGeneratorSevice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReportAGeratorImplBDDTest {

	ReportAGeratorImpl reportGerator = null;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetReportType() {
		// Given
		ReportGeneratorSevice reportGeneratorSevice = mock(ReportGeneratorSevice.class);
		List<String> list = Arrays.asList("Report Type A", "Report Type B", "Report Type C");
		given(reportGeneratorSevice.getReportTypes()).willReturn(list);
		reportGerator = new ReportAGeratorImpl(reportGeneratorSevice);
		// When
		List<String> reportList = reportGerator.getReportType();
		// Then
		assertEquals(3, reportList.size());

	}
}
