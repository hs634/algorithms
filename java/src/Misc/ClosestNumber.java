package Misc;

/*
 * In a sorted array, find the number closest to a given number.

 */
/*
 * Find the given number using binary search. Get the index and index-1 and index+1
 */
public class ClosestNumber {

	int N;
	public Integer[] array;
	
	public ClosestNumber(int N){
		this.N = N;
		this.array = new Integer[N];
	}
	
	
	public int search(int key){
		int low = 0;
		int high = N-1;
		int index = -1;
		int ret = -1;
		while(low <= high){
			
			int mid = (low+high)/2;
			
			if(array[mid] == key){
				index = mid;
				break;
			}else if(array[mid] > key){
				high = mid-1;
			}else{
				low = mid+1;
			}
			
		}
		
		if(index !=-1){
			if(index == 0){
				ret = array[index +1];
			}
			else{
				ret = array[index-1];
			}
		}
		
		return ret;
		
	}
	
	
	public static void main(String[] args){
		ClosestNumber maxP = new ClosestNumber(5);
		maxP.array[0] = 2;
		maxP.array[1] = 3;
		maxP.array[2] = 5;
		maxP.array[3] = 7;
		maxP.array[4] = 10;
		int closest = maxP.search(7);
		System.out.println(closest);
	}
	
}
