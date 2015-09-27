package fDynamicProgramming;

import java.util.ArrayList;

public class TextJustification {
	
	private static String[] words = {"Here"," ","is"," ", "the", " " ,"page"," ", "length"," ","and"," ","the"," ", "width"," ","of"," ", "the"," ","lines"};
	static int width = 10;
	
	public static void textJustification(String[] words){
		int N = words.length;
		Double[] DP = new Double[N];
		DP[N] = 0.0;
		for(int i = 0 ;i < N;i++){
			for(int j=i+1; j < N;j++){
				DP[i] = Math.min(DP[j] , DP[j] + badness(i,j));
			}
			
		}
	}

	
	public static double badness(int i, int j){
		int len =0;
		double badness = Long.MAX_VALUE;
		
		for(int k=i;k<j;k++){
			len += words[k].length();
		}
		
		if(len < width){
			badness = Math.pow((width - len),3);
		}
		return badness;
		
	}
	
	public static void main(String[] args){
		
		ArrayList<String> line = fullJustify(words, 10);
		for(String w : line){
			System.out.print(w);
		}
		
	}
	

/**	
List of words n. How to pack in to lines such that they are good lines
Define a quantity badness. badness(i:j) is badness of having words i through j in a single line
badness(i:j) = {
		infinity if total_length of words s + spaces > width of line;
		(page width − total length)3 otherwise 
//discourages big gaps and heavily discourages ones that don't fit.
If u take greedy approach then the first line is well fit but the next lines may not be.

1. Sub-Problems
are going to be suffixes. if there are n words, then there are n possible suffixes.
# of subproblems = n
2.Guess
where to start the line, second line and so forth..
3.Recurrence:  for given ith word
DP(n) = 0 // blank line. nothing after n
DP(i) = 
//to get all possible guesses
min( DP(j) + badness(i:j) for j in range(i+1 : n+1))

4. Total Time = # sub problems * time = n * n = O(n2)
5. Original problem is DP(0) = includes all words

Parent Pointers - remember which guess was best.
parent[i] = argmin(j); // min( DP(j) + badness(i:j) for j in range(i+1 : n+1))
0 -> parent(0) - >parent(parent(0))

http://www.darrensunny.me/leetcode-text-justification/
package me.darrensunny.leetcode;
*/ 
	
    public static ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        if (words == null || words.length == 0)
            return result;
        int begin = 0, end = 0; 	// words[begin...end-1] as a line
        while (begin < words.length) {
            // Determine end such that words[begin...end-1] fit in a line and
            // words[begin...end] do not.
            int currentLength = words[begin].length();
            for (end = begin+1; end < words.length; end++) {
                if (currentLength + words[end].length() + 1 <= L)
                    currentLength += words[end].length() + 1;
                else
                    break;
            }
            // Construct a justified line with words[begin...end-1]
            StringBuilder temp = new StringBuilder();
            temp.append(words[begin]);
            if (end == words.length || end == begin+1) {    // Last line or a line with only one word
                // Left justified
                for (int i = begin+1; i < end; i++) {
                    temp.append(' ');
                    temp.append(words[i]);
                }
                for (int i = 0; i < L - currentLength; i++)
                    temp.append(' ');
            } else {        // Regular lines
                // Fully justified
                int spaceInBetween = end - begin - 1;
                double spaces = L - currentLength + spaceInBetween;
                for (int i = begin+1; i < end; i++) {
                    for (int j = 0; j < spaces/spaceInBetween; j++) {
                        temp.append(' ');
                    }
                    spaces -= Math.ceil(spaces/spaceInBetween);
                    spaceInBetween--;
                    temp.append(words[i]);
                }
            }
            // Add the line to the resulting list, and slide the window to the next position
            result.add(temp.toString());
            begin = end;
        }
        return result;
    }

}


