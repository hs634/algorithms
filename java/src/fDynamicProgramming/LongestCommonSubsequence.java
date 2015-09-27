package fDynamicProgramming;

public class LongestCommonSubsequence {

	public static  String lcseq(String s, String t){
		String lcs = "";
		int m = s.length();
		int n = t.length();
		Integer[][] LCS = new Integer[m+1][n+1];
		
		for(int i=0;i<=m;i++){
			for(int j=0; j<=n; j++){
				if(i==0 || j ==0){
					LCS[i][j] = 0;
				}else if(s.charAt(i-1) == t.charAt(j-1)){
					LCS[i][j] = LCS[i-1][j-1] + 1;
				}else{
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		
		for(int i=0;i<=m;i++){
			for(int j=0; j <=n; j++){
				System.out.print(LCS[i][j] + "\t");
			}
			System.out.println();
		}
		
		lcs = printlcs(LCS, s, t);
		
		return lcs;
	}

	private static String printlcs(Integer[][] LCS, String s, String t) {
		int m = s.length();
		int n = t.length();
		String lcs1 = "";
		while(m>0 && n>0){
			if(s.charAt(m-1) == t.charAt(n-1)){
				lcs1 += s.charAt(m-1);
				m--;n--;
				
			}else if(LCS[m-1][n] > LCS[m][n-1])
				m--;
			else
				n--;
		}
		String lcs = "";
		for(int i=lcs1.length()-1;i>=0;i--){
			lcs += lcs1.charAt(i);
		}
		return lcs;
	}
	
	public static void main(String[] args){
		String lcs = lcseq("AYBT", "AYAB");
		System.out.println(lcs);
		
	}
	
	/* A Naive recursive implementation of LCS problem */
	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	int lcs(Character[] X, Character[] Y, int m, int n ){
	   if (m == 0 || n == 0)
	     return 0;
	   if (X[m-1] == Y[n-1])
	     return 1 + lcs(X, Y, m-1, n-1);
	   else
	     return Math.max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
	}
}
/*
 * insert/delete : cost =1;
 * replace is c=c' cost =;
 * 			else infinty;
 */

/**
 * Time Complexity of the above implementation is O(mn) which is much better than the 
 * worst case time complexity of Naive Recursive implementation.
 * 
 * Examples:
1) Consider the input strings AGGTAB and GXTXAYB. Last characters match for the strings. So length of LCS can be written as:
L(ÒAGGTABÓ, ÒGXTXAYBÓ) = 1 + L(AGGTA, GXTXAY)
2) Consider the input strings ABCDGH and ÒAEDFHR. Last characters do not match for the strings. So length of LCS can be written as:
L(ÒABCDGHÓ, ÒAEDFHRÓ) = MAX ( L(ABCDG, AEDFHR), L(ABCDGH, AEDFH) )
So the LCS problem has optimal substructure property as the main problem can be solved using solutions to subproblems.
2) Overlapping Subproblems:
Following is simple recursive implementation of the LCS problem. The implementation simply follows the recursive structure mentioned above.

 *Time complexity of the above naive recursive approach is O(2^n) in worst case and worst case happens when all characters of X and Y mismatch i.e., length of LCS is 0.
Considering the above implementation, following is a partial recursion tree for input strings ÒAXYTÓ and ÒAYZXÓ
                        lcs("AXYT", "AYZX")
                       /                 \
         lcs("AXY", "AYZX")            lcs("AXYT", "AYZ")
         /            \                  /               \
lcs("AX", "AYZX") lcs("AXY", "AYZ")   lcs("AXY", "AYZ") lcs("AXYT", "AY")
In the above partial recursion tree, lcs(ÒAXYÓ, ÒAYZÓ) is being solved twice.
 If we draw the complete recursion tree, then we can see that there are many subproblems which are 
 solved again and again. So this problem has Overlapping Substructure property and recomputation
 of same subproblems can be avoided by either using Memoization or Tabulation. Following is a tabulated implementation for the LCS problem.
 */


