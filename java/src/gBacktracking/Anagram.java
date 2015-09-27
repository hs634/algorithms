package gBacktracking;

import java.util.HashSet;

public class Anagram {

	/**
	 * If permuting the input "zicquzcal", once you have assembled "zc" as the leading characters, 
	 * there are no English words that start with that prefix,
	 * This means inserting an additional base case that returns 
	 * the empty string right away when soFar is not a valid prefix.
	 *  
	 */
	HashSet<String> lexicon = new HashSet<String>();
	
	String findWord(String sofar, String rest){
		if(rest.isEmpty())
			return lexicon.contains(sofar)?sofar:"";
		for(int i = 0; i< rest.length();i++){
			String next = sofar + rest.charAt(i);
			String remain = rest.substring(0,i) + rest.substring(i+1);
			String found = findWord(next, remain);
			if(!found.isEmpty())
				return found;
		}
		return "";
	}
	
	/**
	 * Instead of permuation, construct a dictionary by sorting the word 
	 * and saving it as key and values is all possible words
	 * 
	 * Sort the incoming word and check the dictionary if it exists
	 */
	
}
