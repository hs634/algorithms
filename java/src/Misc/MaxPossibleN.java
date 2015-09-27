package Misc;

/*
Given an unsorted array of integers, you need to return maximum possible n such that 
the array consists at least n values greater than or equals to n. Array can contain duplicate values. 
Sample input : [1, 2, 3, 4] -- output : 2 
Sample input : [900, 2, 901, 3, 1000] -- output: 3
*/
public class MaxPossibleN {

	int N;
	public Integer[] array;
	
	public MaxPossibleN(int N){
		this.N = N;
		this.array = new Integer[N];
	}
	
	public int maxN(){
		int ret = -1;
		int len = array.length;
		for(Integer n : array){
			int val = 0;
			if(n < len){
				for(Integer cmp : array){
					if(cmp >= n){
						val++;
						if(val >= n)
							break;
					}
				}
				if(val >=n && n > ret)
					ret = n;
			}
		}
		System.out.println(ret);
		return ret;
	}
	
	public static void main(String[] args){
		MaxPossibleN maxP = new MaxPossibleN(5);
		maxP.array[0] = 900;
		maxP.array[1] = 2;
		maxP.array[2] = 901;
		maxP.array[3] = 3;
		maxP.array[4] = 1000;
		maxP.maxN();
	}
}
