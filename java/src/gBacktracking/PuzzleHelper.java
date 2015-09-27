package gBacktracking;

import java.util.HashMap;

public class PuzzleHelper {

	Character[] add1 = {'S','E','N','D'};
	Character[] add2 = {'M','O','R','E'};
	Character[] result = {'M','O','N','E','Y'};
	
	public HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	
	public boolean isPuzzleSolved(){
		int first = 0;
		int second = 0;
		int res = 0;
		for(int i=0; i<add1.length; i++){
			first= first*10 + map.get(add1[i]);
			second= map.get(add2[i]) + second *10;
		}
		for(int i=0; i<result.length; i++){
			res= res*10 + map.get(result[i]);
		}
		
		if(first + second == res)
			return true;
		return false;
		
	}
	
}
