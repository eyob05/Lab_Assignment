package tddDemo2;

public class ArrayReversor {
	private ArrayFlattenerService arrayFlattenerService;

	public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
		this.arrayFlattenerService = arrayFlattenerService;

	}

	public Integer[] reverseArray(Integer[][] arr) {

		if (arr == null)
			return null;

		Integer[] a = arrayFlattenerService.flattenArray(arr);

		Integer[] newArray = new Integer[a.length];
		
		for (int i = a.length - 1, j = 0; i >= 0; i--, j++) {
			newArray[j] = a[i];
		}

		return newArray;
	}

}
