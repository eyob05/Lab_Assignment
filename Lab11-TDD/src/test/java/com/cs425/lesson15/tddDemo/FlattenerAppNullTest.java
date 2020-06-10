package com.cs425.lesson15.tddDemo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FlattenerAppNullTest {
	
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
		Integer[][] input =  null;
		Integer[] expected=  null;
		Integer[] actual= this.arrayFlattenerApp.flattenArray( input);
		
	assertArrayEquals(expected, actual);
	}

}
