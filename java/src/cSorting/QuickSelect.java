package cSorting;

/**
 * Max order
 *
 */
public class QuickSelect {

	static int[] arr = {10,45,234,53,34,3,56,24,7,54};
	static int[] medianArray = new int[10];;
	
	public static void main(String[] args){
		findKlargest(0, 9, 3);
		System.out.println(arr[0] + "-" + arr[1] + "-" + arr[2]);
	}
	
	public static void findKlargest(int low, int high, int k){
		if(low < high){
			int pivotIndex = partition( low, high);
			int sizeLeft = pivotIndex - low + 1;
			if(sizeLeft == k)
				return;
			else if(sizeLeft > k)
				findKlargest(low, pivotIndex-1, k);
			else
				findKlargest(pivotIndex+1, high, k);
		}
	}
	
	private static int partition(int low, int high) {
		int pivot = selectMedian(low, high);
		int i = low + 1;
		int j = high;
		
		while(i < j){
			while(arr[i] > pivot) i++;
			while(arr[j] < pivot) j--;
			swap(i, j);
		}
		swap(i,j); // undo last swap 5 3 1 4 2(j) 8(i), 9, 7
		swap(low, j);
		return j;
	}
	
	
	public static int selectMedian(int low, int high){
		int N = high - low;
		int k=0;
		for(int i = low; i < high; i++){
			medianArray[k] = arr[i];
			k++;
		}
		int median = 0;
		while(N/5 >=0){
			if(N < 5){
				int sum = 0;
				for(int i = 0; i < N; i++){
					sum+= medianArray[i];
				}
				median = sum/N;
			}else{
				int set = N/5; // 50/5 = 10
				for(int i = 0; i < set; i++){
					int start = i*4+i;
					int last = start + 4;
					int sum = 0;
					for(int j=start;j<last;j++){
						sum+= medianArray[j];
					}
					median = sum/5;
					medianArray[i] = median;
				}
				N=set;
			}
		}
	
		return median;
	}
	
/*
	private static int partition(int low, int high) {
		int pivot = arr[low];
		int i = low + 1;
		int j = high;
		
		while(i < j){
			while(arr[i] > pivot) i++;
			while(arr[j] < pivot) j--;
			swap(i, j);
		}
		swap(i,j); // undo last swap 5 3 1 4 2(j) 8(i), 9, 7
		swap(low, j);
		return j;
	}*/
	
	private static void swap(int low, int j) {

		int tmp = arr[low];
		arr[low] = arr[j];
		arr[j] = tmp;
	}
}
