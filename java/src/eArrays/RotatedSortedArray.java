package eArrays;

public class RotatedSortedArray {

	/**
	 * http://leetcode.com/2010/04/searching-element-in-rotated-array.html
	 * Consider rotated sorted array - 4,5,6,7,0,1,2
	 * Say u r searching for element 1.
	 * 
	 * Check the middle element 7, Compare with left and right which is 4 and 2.
	 * Since 4 is less than 7, the left array is sorted. If search element is in
	 * between 4 and 7 then search in this sub array else search on the right
	 * 
	 * Stop while the index cross overs. this works only for non-duplicate array
	 * Takes O(log n)
	 */
	
	
	public static int rotatedBinarySearch(Integer[] arr, int N, int key){
		int low = 0;
		int high = N-1;
		
		while(low < high){
			
			int mid = low + ((high - low)/2);
			
			//If you find the middle element
			if(arr[mid] == key) return mid;
			
			//Else, check if bottom half is sorted
			if(arr[low] <= arr[mid]){
				if(arr[low] < key && key < arr[mid])
					high = mid -1;
				else
					low = mid +1;
			}
			
			//Upper half is sorted
			else{
				if(arr[mid] < key && key <arr[high])
					low = mid+1;
				else
					high = mid -1;
			}
			
		}
		
		return -1;
	}
	
	
	public static int FindIndexOfSortedArray(Integer[] arr, int N){
		int low = 0;
		int high = N-1;
		
		while(arr[low] > arr[high]){
			int mid = low + (high -low)/2;
			if(arr[mid] > arr[high])
				low = mid +1;
			else
				high = mid;
		}
		
		return low;
		
	}
	
	
}
