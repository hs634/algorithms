package cSorting;

public class QuickSort {

	static int[] arr = new int[10];
	public void quicksort(int low, int high){
		if(low < high){
			int pivotIndex = partition( low, high);
			quicksort(low, pivotIndex-1);
			quicksort(pivotIndex+1, high);
		}
	}

	private int partition(int low, int high) {
		int pivot = arr[low];
		int i = low;
		int j = high+1;
		
		while(i < j){
			while(arr[i] < pivot) i++;
			while(arr[j] > pivot) j--;
			swap(i, j);
		}
		swap(i,j); // undo last swap 5 3 1 4 2(j) 8(i), 9, 7
		swap(low, j);
		return j;
	}
	
	private static void swap(int low, int j) {

		int tmp = arr[low];
		arr[low] = j;
		arr[j] = tmp;
	}
}
