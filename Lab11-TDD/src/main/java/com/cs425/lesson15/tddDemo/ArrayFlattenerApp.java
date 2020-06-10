package com.cs425.lesson15.tddDemo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFlattenerApp {

	public ArrayFlattenerApp() {
		
	}
	
public static Integer[] flattenArray(Integer[][] arr) {
	
	if(arr==null)
		return null;

    List<Integer> list = new ArrayList<>();

    for (Integer[] array : arr) {
      Arrays.stream(array).forEach(list::add);
    }

    return list.stream().toArray(Integer[]::new);
  }
}
