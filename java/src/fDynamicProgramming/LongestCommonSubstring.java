package fDynamicProgramming;

public class LongestCommonSubstring {

	public static int lcs(String s , String t){
		int max = 0;
		int m = s.length();
		int n = t.length();
		Integer[][] LCS = new Integer[m+1][n+1];
		for(int i=0; i <=m ;i++){
			for(int j=0;j<=n;j++){
				if(i==0||j==0){
					LCS[i][j] = 0;
				}else if(s.charAt(i-1) == t.charAt(j-1)){
					LCS[i][j] = LCS[i-1][j-1] + 1;
					max = Math.max(max, LCS[i][j]);
				}else{
					LCS[i][j] = 0;
				}
				
			}
		}
		printMatrix(LCS);
		printLCS(LCS, s, t);
		
		return max;
	}
	
	static void printLCS(Integer[][] LCS, String s, String t){
		int row = LCS.length;
		int col = LCS[0].length;
		int max =0;
		int colIndex = 0;
		for(int i=0;i<row; i++){
			for(int j=0;j<col;j++){
				if(LCS[i][j] > max){
					colIndex = j;
					max = LCS[i][j];
				}
			}
		}
		char[] sub = new char[max];
		while(max != 0){
			sub[max-1] = t.charAt(colIndex-1);
			colIndex--;
			max--;
		}
		System.out.println(sub);
		
	}
	
	public static void printMatrix(Integer[][] lCS){
		int m = lCS.length;
		int n = lCS[0].length;
		for(int i=0;i<m;i++){
			for(int j=0; j <n; j++){
				System.out.print(lCS[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		//lcs("javajar", "ajar");
		lcs("ABC", "ABD");
	}
	/**
	 * As an example, say that s = "tofoodieÓ and t = ÒtoodyÓ. The longest substring in each is ÒoodÓ at three characters. 
	 * There are several substrings of two characters, including ÒtoÓ  and ÒooÓ and ÒodÓ. 
	 */
}
