package eArrays;

//https://github.com/JohnKurlak/Algorithms/blob/master/selection/Quickselect.java
//https://blogs.oracle.com/malkit/entry/kth_order_statistics_partial_ordering
public class TopKOrderStatistic {

	static int[] array={10,45,234,53,34,3,56,24,7,54,23,25,52,21,26,27,28,29,30,31,32,33,35,36,37,38,39,40};
	int N;
	static int[] medianArray;
	public TopKOrderStatistic(int N){
		this.N = N;
		medianArray = new int[N];
	}
	
	
	public static void main(String[] args){
		int N = array.length;
		findKlargest(0, N, 3);
	}
	
	public static int findKlargest(int left, int right, int k){
		int N = array.length;
		int pivot = selectMedian(N);

		int pivotIndex = partition(pivot, left, right);
		int sizeLeft = pivotIndex - left +1;
		if(sizeLeft == k){
			return pivotIndex;
		}else if (sizeLeft > k) {
            return findKlargest(left, pivotIndex - 1, k);
        } else {
            return findKlargest(pivotIndex + 1, right, k - sizeLeft);
        }
	}
	
	public static int selectMedian(int N){
		int median = 0;
		while(N/5 >=0){
			if(N < 5){
				int sum = 0;
				for(int i = 0; i < N; i++){
					sum+= array[i];
				}
				median = sum/N;
			}else{
				int set = N/5; // 50/5 = 10
				for(int i = 0; i < set; i++){
					int start = i*4+i;
					int last = start + 4;
					int sum = 0;
					for(int j=start;j<last;j++){
						sum+= array[j];
					}
					median = sum/5;
					medianArray[i] = median;
				}
			}
		}
	
		return median;
	}
	
	public static int partition(int pivot, int low, int high){
		int i = low + 1;
		int j = high;

		while(i<j){
			while(array[i] < pivot) i++;
			while(array[j] > pivot) j--;
			if(i < j)
				swap(i,j);
			
		}
		swap(low , j);
		return j;
		}

	
	private static void swap(int low, int j) {

		int tmp = array[low];
		array[low] = j;
		array[j] = tmp;
	}

	
}
