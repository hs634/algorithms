package gBacktracking;

public class RecSubset {

	public static void recSubset(String sofar, String rest){
		if(rest.isEmpty())
			System.out.println(sofar);
		else{
			recSubset(sofar+rest.charAt(0),rest.substring(1));
			recSubset(sofar, rest.substring(1));
		}
	}
	
	public static void main(String[] args){
		recSubset("", "abcd");
	}
	
	/**
	 * 				subset("", abcd)
	 * 				/			\
	 *		subset("a", "bcd") subset("", "bcd")
	 *			/		\
	 *subset("ab", "cd") subset("a", "cd")
	 *		/   \
	 *subset("abc",d) subset("ab" , "d")
	 *= abcd, abc		abd		ab
	 */
}
