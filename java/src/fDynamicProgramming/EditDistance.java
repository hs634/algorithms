package fDynamicProgramming;

public class EditDistance {

	public int recursiveEditDistance(String word1, String word2){
	
		int word1_length = word1.length();
		int word2_length = word2.length();
		
		if(word1_length == 0 || word2_length ==0){
			return Math.abs(word1_length - word2_length);
		}
		
		String sub_word1 = word1.substring(1, word1_length-1);
		String sub_word2 = word2.substring(1, word2_length-1);
		
		if(word1.charAt(0)==word2.charAt(0)){
			return recursiveEditDistance(sub_word1, sub_word2);
		}
		else{
			return(1 + Math.min(recursiveEditDistance(sub_word1, sub_word2),
					Math.min(recursiveEditDistance(sub_word1, word2), 
							recursiveEditDistance(word1, sub_word2))
							));
		}
	}
	
	public static int editDistance(String word1, String word2){
		int len1 = word1.length();
		int len2 = word2.length();
		
		if (len1 == 0 || len2 == 0) 
			return Math.abs(len2 - len1);
		
		int[][] dist = new int[len1][len2];
		dist[0][0] = (word1.charAt(0)==word2.charAt(0))?0:1;
		
		for(int i=1; i<len1; i++){
			dist[i][0] = (word1.charAt(i) == word2.charAt(0))? i : dist[i-1][0]+1;
		}
		
		for(int j=1; j<len2; j++){
			dist[0][j] = (word1.charAt(0) == word2.charAt(j))?j : dist[0][j-1]+1;
		}
		
		for(int i=1; i<len1;i++){
			for(int j=1;j<len2;j++){
				if(word1.charAt(i) == word2.charAt(j))
				{
					dist[i][j] = dist[i-1][j-1];
				}
				else
				{
					dist[i][j] = 1 + Math.min(dist[i-1][j-1], Math.min(dist[i-1][j], dist[i][j-1]));
				}
			}
		}
		
		printMatrix(dist);
		
        return dist[len1-1][len2-1]; 
	}
	
	public static void printMatrix(int[][] LCS){
		int m = LCS.length;
		int n = LCS[0].length;
		for(int i=0;i<m;i++){
			for(int j=0; j <n; j++){
				System.out.print(LCS[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		String word1 = "ABC";
		String word2 = "BAC";
		int dist = editDistance(word1, word2);
		System.out.println(dist);
	}
	
/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

Solution:
Assume that the total number of operations is d. Pick letters from both strings: x1 and x2. If x1 = x2, remove both and pick next letters.
SAMOSA and VERBOSA
If they are different, compare three operations:
a) insert a character, i.e., remove x2 from word2 since we will insert x2 to word1. Then pick letters from word1 and word2 again.
VSAMOSA
ERBOSA
b) delete a character, i.e., remove x1 from word1.
AMOSA
VERBOSA
c) replace a character, i.e., remove both x1 and x2.
AMOSA
ERBOSA
All these cases we need one extra operation.

So the recursion is:
s1 = delete the first character of word1
s2 = delete the first character of word2
d(word1, word2) = d(s1, s2), if the first characters are the same.
d(word1, word2) = 1 + min(d(s1, word2), d(word1, s2), d(s1, s2))
*/
}
