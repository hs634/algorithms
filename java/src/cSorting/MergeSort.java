package cSorting;

public class MergeSort {

	Integer[] arr = {2,5,8,7,3};
	Integer[] helper = new Integer[arr.length];
	public void mergesort(int low, int high){
		if(low<high){
			int mid = (low+high)/2;
			mergesort(low, mid);
			mergesort(mid+1,high);
			merge(low,high,mid);
		}
	}

	private void merge(int low, int high, int mid) {
	    for (int i = low; i <= high; i++) {
		      helper[i] = arr[i];
		}
	    int i = low;
	    int j= mid+1;
	    int k = low;
	    while(i<=mid && j<=high){
	    	if(helper[i] < helper[j]){
	    		arr[k] = helper[i];
	    		i++;
	    	}else{
	    		arr[k] = helper[j];
	    		j++;
	    	}
	    	k++;
	    }
	    while (i <= mid) {
		      arr[k] = helper[i];
		      k++;
		      i++;
		    }
	}
	
	public static void main(String[] args){
		MergeSort m = new MergeSort();
		m.mergesort(0 ,m.arr.length-1);
	    for (int i = 0; i < m.arr.length; i++) {
	    	System.out.println(m.arr[i]);
		}
	}
}
