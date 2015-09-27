package gBacktracking;

public class PermuteCode {
	
/**
 * 	Permute("", "abcd") -> P("a","bcd") P("b","acd") P("c","abd") P("d","abc")
	P("a","bcd")  -> P("ab","cd") P("ad","bc") P("ac", "bd")
	 P("ab","cd") -> P("abc","d") P("abd","c")
	 P("abc","d")  -> P("abcd","")
	 P("abd","c") -> P("abdc","")

 */
	/*
	 *  We want to generate all possible sequences of letters.
		for (each possible first letter):
			for (each possible second letter): for (each possible third letter):
			... print!
	 */

	public static void recPermute(String sofar, String rest){
		if(rest.isEmpty())
			System.out.println(sofar);
		else{
			for(int i=0;i<rest.length();i++){
				String next = sofar + rest.charAt(i);
				String remaining = rest.substring(0, i) + rest.substring(i+1);
				recPermute(next, remaining);
			}
		}
	}
	
	public static void mina(String[] args){
		recPermute("","abcd");
	}
}
