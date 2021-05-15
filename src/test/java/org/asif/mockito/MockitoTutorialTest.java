package org.asif.mockito;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MockitoTutorialTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMockJavaListSize() {
		List mockList = Mockito.mock(List.class);
		Mockito.when(mockList.size()).thenReturn(2);
		Assertions.assertEquals(2, mockList.size());
		Assertions.assertEquals(2, mockList.size());
		Assertions.assertEquals(2, mockList.size());
	}

	@Test
	void testMockJavaListSize_MultipleValue() {
		List mockList = Mockito.mock(List.class);
		Mockito.when(mockList.size()).thenReturn(2).thenReturn(3).thenReturn(4);
		Assertions.assertEquals(2, mockList.size());
		Assertions.assertEquals(3, mockList.size());
		Assertions.assertEquals(4, mockList.size());
		Assertions.assertEquals(4, mockList.size());
	}

	@Test
	void testMockJavaListGet() {
		List mockList = Mockito.mock(List.class);
		Mockito.when(mockList.get(0)).thenReturn("Asif");
		Assertions.assertEquals("Asif", mockList.get(0));
		Assertions.assertEquals(null, mockList.get(1));
	}

	@Test
	void testMockJavaListGet_AnyIndex() {
		List mockList = Mockito.mock(List.class);
		Mockito.when(mockList.get(Mockito.anyInt())).thenReturn("Asif");
		Assertions.assertEquals("Asif", mockList.get(0));
		Assertions.assertEquals("Asif", mockList.get(1));
	}

	@Test()
	void testMockJavaListGet_throwException() {
		List mockList = Mockito.mock(List.class);
		Mockito.when(mockList.get(Mockito.anyInt())).thenThrow(new RuntimeException("Something went wrong!!"));
		Assertions.assertThrows(RuntimeException.class, () -> mockList.get(0));
	}

	@Test()
	@Disabled
	void testMockJavaListGet_mixingUp() {
		List mockList = Mockito.mock(List.class);
		// mixing up mock argument and actual argument won't work. Example below
		Mockito.when(mockList.subList(Mockito.anyInt(), 5)).thenThrow(new RuntimeException("Something went wrong!!"));
		Assertions.assertThrows(RuntimeException.class, () -> mockList.get(0));
	}

}
