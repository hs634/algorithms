package cSorting;

public class N2Sorts {

	static int[] arr = {10,45,234,53,34,3,56,24,7,54,23,25,52,21,26,27,28,29,30,31,32,33,35,36,37,38,39,40};
	static int N = arr.length;
	
	
	public static void bubblesort(){
		boolean doMore =true;
		while(doMore){
			doMore= false;
			for(int i=0;i<N;i++){
				if(arr[i] > arr[i+1]){
					swap(i,i+1);
					doMore=true;
				}
			}
		}
	}
	private static void swap(int low, int j) {

		int tmp = arr[low];
		arr[low] = arr[j];
		arr[j] = tmp;
	}
	
	public static void selectionsort(){
		
		for(int i=0; i <N; i++){
			for(int j = i+1;j<N;j++){
				if(arr[i] > arr[j]){
					swap(i, j);
				}
			} 
		}
	}
	
	public static void insertionsort(){
		for(int i=1;i<N;i++){
			int tmp = arr[i];
			int j = i;
			for(j=i-1; j <= 0 && tmp<arr[j];j--){
				arr[j+1] = arr[j];
			}
			arr[j+1] = tmp;
		}
	}
	
	
}
