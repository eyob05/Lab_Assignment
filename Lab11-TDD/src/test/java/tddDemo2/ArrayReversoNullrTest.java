package tddDemo2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayReversoNullrTest {
	private ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);
	private ArrayReversor arrayReversor;

	@Before
	public void setUp() throws Exception {
		this.arrayReversor = new ArrayReversor(arrayFlattenerService);
	}

	@After
	public void tearDown() throws Exception {
		this.arrayReversor = null;
	}

	@Test
	public void testReverseArray() {

		when(arrayFlattenerService.flattenArray(null)).thenReturn(null);
		Integer[] actual = arrayReversor.reverseArray(null);
		Integer[] expected = null;
		assertArrayEquals(expected, actual);

	}

}
