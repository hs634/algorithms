package bStrings;

public class LongestPalindromicSubstring {
/*
 * 

http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html

http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/

 */
	//Naive Solution O(n3)
	public boolean isPalindrome(String s){
		int end = s.length();
		int start = 0;
		for(int i=0; i <= (start + end)/2; i++ ){
			if(s.charAt(i) == s.charAt((start+end)-i))
				continue;
			return false;
		}
		return true;
	}

	public String longestPalindrome(String s){
		int length = s.length();
		int longStart = 0;
		int longEnd = 0;
		for(int i=0; i<length; i++){
			for(int j=i+1; j <= length; j++){
				if(isPalindrome(s.substring(i,j+1))){
					if((j-i) > (longEnd-longStart)){
						longStart = i;
						longEnd = j;
					}

				}
			}
		}
		return s.substring(longStart, longEnd);
	}

	//Dynamic programming:
//	P[i,j] = P[i+1, j-1] && S[i] == S[j];
//	base case:
//	P[i, i]=true
//	P[i, i +1] = true if Si = Si+1;

	String longestPalindromeDP(String s) {
	  int n = s.length();
	  int longestBegin = 0;
	  int maxLen = 1;
	  Boolean[][] table = new Boolean[1000][1000];
	  
	  for (int i = 0; i < n; i++) {
	    table[i][i] = true;
	  }
	  for (int i = 0; i < n-1; i++) {
	    if (s.charAt(i) == s.charAt(i+1)) {
	      table[i][i+1] = true;
	      longestBegin = i;
	      maxLen = 2;
	    }
	  }
	 for (int len = 3; len <= n; len++) {
	    for (int i = 0; i < n-len+1; i++) {
	      int j = i+len-1;
	      if (s.charAt(i) == s.charAt(j) && table[i+1][j-1]) {
	        table[i][j] = true;
	        longestBegin = i;
	        maxLen = len;
	      }
	    }
	  }
	  return s.substring(longestBegin, maxLen);
	}

	/*We observe that center, and there are only 2N-1 such centers.
	You might be asking why there are 2N-1 but not N centers? The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as ÒabbaÓ) and its center are between the two ÔbÕs. a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its 
*/
	String expandAroundCenter(String s, int c1, int c2) {
	  int left = c1, right = c2;
	  int n = s.length();
	  while (left >= 0 && right <= n-1 && s.charAt(left) == s.charAt(right)) {
	    left--;
	    right++;
	  }
	  return s.substring(left+1, right-left-1);
	}
	 
	String longestPalindromeSimple(String s) {
	  int n = s.length();
	  if (n == 0) return "";
	  String longest = s.substring(0, 1);  // a single char itself is a palindrome
	  for (int i = 0; i < n-1; i++) {
	    String p1 = expandAroundCenter(s, i, i);
	    if (p1.length() > longest.length())
	      longest = p1;
	 
	    String p2 = expandAroundCenter(s, i, i+1);
	    if (p2.length() > longest.length())
	      longest = p2;
	  }
	  return longest;
	}
}
