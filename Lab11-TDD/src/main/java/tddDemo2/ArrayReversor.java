package tddDemo2;

public class ArrayReversor {
	private ArrayFlattenerService arrayFlattenerService;

	public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
		this.arrayFlattenerService = arrayFlattenerService;

	}

	public Integer[] reverseArray(Integer[][] arr) {

		

		Integer[] a = arrayFlattenerService.flattenArray(arr);
		if (arr == null)
			return null;

		Integer[] newArray = new Integer[a.length];
		
		for (int i = a.length - 1, j = 0; i >= 0; i--, j++) {
			newArray[j] = a[i];
		}

		return newArray;
	}

}
