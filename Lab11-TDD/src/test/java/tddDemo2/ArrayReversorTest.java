package tddDemo2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class ArrayReversorTest {	
	private ArrayFlattenerService arrayFlattenerService=mock(ArrayFlattenerService.class);
	private ArrayReversor arrayReversor;


	@Before
	public void setUp() throws Exception {
	
		this.arrayReversor=new ArrayReversor(arrayFlattenerService);
	}

	@After
	public void tearDown() throws Exception {
		
		this.arrayReversor=null;
	}

	@Test
	public void testReverseArray() {
		Integer[][] input=new Integer[][] {{1,2,3},{4,5,6},{7,8}};
		Integer[] result=new Integer[] {1,2,3,4,5,6,7,8};
		
		when(arrayFlattenerService.flattenArray(input))
		.thenReturn(result);
		Integer[] actual=arrayReversor.reverseArray(input);
		Integer[] expected=new Integer[]{8,7,6,5,4,3,2,1};
		assertArrayEquals(expected, actual);
	
		verify(arrayFlattenerService).flattenArray(input);
	}

}
