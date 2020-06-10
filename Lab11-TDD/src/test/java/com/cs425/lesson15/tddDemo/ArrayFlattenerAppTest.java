package com.cs425.lesson15.tddDemo;


import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ArrayFlattenerAppTest {
	private ArrayFlattenerApp arrayFlattenerApp=null;

	@Before
	public void setUp() throws Exception {
		this.arrayFlattenerApp=new ArrayFlattenerApp();
	}

	@After
	public void tearDown() throws Exception {
		this.arrayFlattenerApp=null;
	}

	@Test
	public void testFlattenArray() {
		Integer[][] input =  {{1,2,3},{3,4,5},{6,7,8}};
		Integer[] expected=  { 1, 2, 3, 3, 4, 5, 6, 7, 8};
		Integer[] actual= this.arrayFlattenerApp.flattenArray( input);
		
	assertArrayEquals(expected, actual);
	}

}
