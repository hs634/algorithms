package fDynamicProgramming;

public class MaximumCoinDenomination {

	int minimumCoins(int[] denom, int C, int N){
		int i, j;
		//C
		Integer[] M = new Integer[C];
		for(i=0;i<C;i++){
			M[i] = C;
		}
		
		M[0] = 0;
		M[1] = 1;
		
		for(i=2;i<=C;i++){
			for(j=0;j<N;j++){
				if(i-denom[j] >= 0 && M[i-denom[j]] +1 < M[i])
					M[i] = M[i-denom[j]] +1;
			}
		}
		
		return M[C];
	}
	
}
