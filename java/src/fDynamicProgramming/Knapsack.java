package fDynamicProgramming;

public class Knapsack {
/*
 * http://algorithmsandme.blogspot.com/2014/01/dynamic-problem-0-1-knapsack-problem.html#.U6q-hfldXeo
 */
	static int knapsack(int W, int wt[], int val[], int N){
		
		Integer[][] K = new Integer[N+1][W+1];
		   
		for(int i=0; i<=N; i++){
			for(int w=0; w<=W;w++){
				if(i==0||w==0)
					K[i][w] = 0;
				else if(wt[i-1]<=w)
					K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
		           else
		                 K[i][w] = K[i-1][w];
			}
			
		}
		return K[N][W];
		
	}
	
	public static void main(String[] args){

			int val[] = {60, 100, 120};
		    int wt[] = {10, 20, 30};
		    int W = 50;
		    int N = 3;
		    
		    int value = knapsack(W, wt, val, N);
		    System.out.println(value);

	}
	
	/**
	 * Naive
	 * @param w
	 * @param v
	 * @param N
	 * @param W
	 * @return
	 */
	int knapsack(int w[], int v[], int N, int W){
		int[][] table = new int[N+1][W+1];
		
		for(int i=0; i < N; i++){
			for(int j=0; j <W; j++){
				table[i][j] = 0;
			}
	}
		for(int i=0; i < N; i++){
			for(int j=0; j <W; j++){
				if(i==0||j==0)
					table[i][j] = 0;
				else if(w[i] < j){
					if(v[i] + table[i-1][j-w[i-1]] > table[i][j]){
						table[i][j] = v[i] + table[i-1][j-w[i-1]];
					}else{
						table[i][j] = table[i-1][j];
					}
				}else{
					table[i][j] = table[i-1][j];
				}
			}
	}

	return table[N][W];
	}

	//Recursive solution:

	int knapSack(int W, int wt[], int val[], int n)
	{
	   // Base Case
	   if (n == 0 || W == 0)
	       return 0;
	 
	   // If weight of the nth item is more than Knapsack capacity W, then
	   // this item cannot be included in the optimal solution
	   if (wt[n-1] > W)
	       return knapSack(W, wt, val, n-1);
	 
	   // Return the maximum of two cases: (1) nth item included (2) not included
	   else return Math.max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
	                    knapSack(W, wt, val, n-1)
	                  );
	}

	
}
