package gBacktracking;

import java.util.Set;
import java.util.TreeSet;

public class CombinationKWord {
	/**
	 *  Initial attempt - print same words multiple times
	 */
	
	public static void combinations(String s, int length){
		combinations("", s , length);
	}

	private static void combinations(String sofar, String rest, int length) {
		if(length == 0)
			System.out.println(sofar);
		else{
			for(int i = 0; i < rest.length(); i++){
				String ch = rest.substring(i, i+1);
				if(!sofar.contains(ch)){
					 rest = rest.substring(0,i) + rest.substring(i+1);
					 combinations(sofar+ch, rest, length-1);
				}
			}
		}
	}
	
	//Improved
	public static void combinations2(String s, int length){
		Set<String> all = new TreeSet<String>();
		combinations2("", s , length, all );
		for (String comb : all){
			 System.out.println(comb);
		}
		
	}

	private static void combinations2(String sofar, String rest, int length, Set<String> all) {
		if(length == 0)
			all.add(sofar);
		else{
			for(int i = 0; i < rest.length(); i++){
				String ch = rest.substring(i, i+1);
				if(!sofar.contains(ch)){
					 rest = rest.substring(0,i) + rest.substring(i+1);
					 combinations2(sofar+ch, rest, length-1, all);
				}
			}
		}
	}
	
	
}
