package fDynamicProgramming;

public class maximalSubArray {

	public static int maxSubArray(Integer[] arr){
		
		int curr_sum = 0;
		int max_sum = 0;
		
		for(int i=0; i< arr.length; i++){
			curr_sum = Math.max(curr_sum + arr[i],0);
			max_sum = Math.max(max_sum, curr_sum);
		}
		
		return max_sum;
	}
	
public static int maxSubArray2(Integer[] arr){
		
		int curr_sum = 0;
		int max_sum = 0;
		int index = -1;
		for(int i=0; i< arr.length; i++){
			curr_sum = Math.max(curr_sum + arr[i],0);
			if(max_sum < curr_sum){
				max_sum = curr_sum;
				index = i;
			}
			//max_sum = Math.max(max_sum, curr_sum);
		}
		if(index!= -1){
			int max = max_sum;
			while(max != 0){
				System.out.println(arr[index]);
				max = max - arr[index];
				index--;
			}
		
			
		}
		
		return max_sum;
	}
	
	public static void main(String[] args){
		Integer[] ints  = new Integer[]{-1,-2,6,7,-9};
		int max = maxSubArray2(ints);
		System.out.println(max);
	}
	
	
	/**
	 * [-1,5,100,-1000] -> 5 + 100 = 105 
 [-1,-2,-3,-4] -> 0 
[1000,20000,-1,300000000] -> whole array
	 */
	/** Brute force approach */
	/*
	Take all possible (start,end) pairs and compute the 
	maximum sum
	*/
	int maximal_subarray_dumb(int[] array, int n) {
	  int max_sum = 0;
	  for (int start = 0; start < n; start++) {
	    for (int end = start; end < n; end++) {
	      int sum = 0;
	      for (int i = start; i <= end; i++) {
	        sum += array[i];
	      }
	      max_sum = Math.max(max_sum, sum);
	    }
	  }
	  return max_sum;
	}
	
	int maximal_subarray_space(int[] array, int n) {
		  // build out solution array
		  int[] subproblems = new int[n];
		  subproblems[0] = Math.max(array[0], 0);
		  for (int i = 1; i < n; i++) {
		    subproblems[i] = Math.max(subproblems[i-1] + array[i], 0);
		  }
		  // iterate through to find the maximum
		  int max = 0;
		  for (int i = 0; i < n; i++) {
		    max = Math.max(max, subproblems[i]);
		  }
		  return max;
		}
	
}
