package eArrays;

public class InversionCount {

	 private int[] numbers;
	  private int[] helper;
	  int inv_count = 0;
	  private int number;

	  public void sort(int[] values) {
	    this.numbers = values;
	    number = values.length;
	    this.helper = new int[number];
	    mergesort(0, number - 1);
	  }

	  private int mergesort(int low, int high) {
		  
	    // check if low is smaller then high, if not then the array is sorted
	    if (low < high) {
	      // Get the index of the element which is in the middle
	      int middle = low + (high - low) / 2;
	      // Sort the left side of the array
	      inv_count+= mergesort(low, middle);
	      // Sort the right side of the array
	      inv_count+= mergesort(middle + 1, high);
	      // Combine them both
	      inv_count+=  merge(low, middle, high);
	    }
	    return inv_count;
	  }

	  private int merge(int low, int middle, int high) {

	    // Copy both parts into the helper array
	    for (int i = low; i <= high; i++) {
	      helper[i] = numbers[i];
	    }

	    int i = low;
	    int j = middle + 1;
	    int k = low;
	    // Copy the smallest values from either the left or the right side back
	    // to the original array
	    while (i <= middle && j <= high) {
	    	int inv_count = 0;
	    	if (helper[i] <= helper[j]) {
	    		numbers[k] = helper[i];
	    		i++;
	    	} else {
	    		numbers[k] = helper[j];
	    		j++;
	    		inv_count = middle - i;
	    	}
	      k++;
	    }
	    // Copy the rest of the left side of the array into the target array
	    while (i <= middle) {
	      numbers[k] = helper[i];
	      k++;
	      i++;
	    }
	    return inv_count;
	  }
}
