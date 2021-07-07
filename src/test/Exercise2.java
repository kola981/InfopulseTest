package test;

public class Exercise2 {

	private static int[] array = new int[10];

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			array[i] = (int) (100 * Math.random());

		sort(array);
		
		assert isSorted();
		printArray();
		
	}

	private static void sort(int[] arr) {
		int[] tempArr = new int[arr.length];		
		sort(arr, tempArr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int[] tempArr, int begin, int end) {
		if (end <= begin) return;
		int mid = begin + (end - begin) / 2;
		sort(arr, tempArr, begin, mid);
		sort(arr, tempArr, mid + 1, end);
		merge(arr, tempArr, begin, mid, end);
	}

	private static void merge(int[] arr, int[] tempArr, int begin, int mid, int end) {
		for (int i = begin; i <= end; i++) {
			tempArr[i] = arr[i];
		}
		
		int j = begin;
		int k = mid + 1;
		
		for (int i = begin; i <= end; i++) {
			
			if (j > mid)                       arr[i] = tempArr[k++];
			else if (k > end)                  arr[i] = tempArr[j++];
			else if (tempArr[k] < tempArr[j])  arr[i] = tempArr[k++];
			else                               arr[i] = tempArr[j++];
		
		}

	}

	
	private static boolean isSorted() {
		for (int i = 0; i < 9; i++) {
			if (array[i] > array[i + 1])
				return false;
		}
		return true;
	}

	
	private static void printArray() {
		for (int i = 0; i < array.length; i++)
			System.out.print(" "+array[i]);
		System.out.println();
	}
	
}
