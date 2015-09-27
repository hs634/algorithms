package gBacktracking;

import java.util.ArrayList;
import java.util.List;
/**
 * Preemptively prune the results. Do not go to all the leaves to make a decision
 * Current sun is already too high
 * Current is so low that rolling 6 for every die would still not lead to the desired sum
 * @author arpana
 *
 */
public class DiceSumImproved {

	public static void diceSum(int dice, int desiredSum) {
		List<Integer> chosen = new ArrayList<Integer>(); 
		diceSum2(dice, desiredSum, chosen, 0);
	}

	
	private static void diceSum2(int dice, int desiredSum,List<Integer> chosen, int sumSoFar) {
		
		 if (dice == 0 && (sumSoFar == desiredSum)) 
	           System.out.println(chosen);
		 else if (sumSoFar <= desiredSum && sumSoFar + (6 * dice) >= desiredSum){
			 for (int i = 1; i <= 6; i++){
				 	chosen.add(i);
		           diceSum2(dice - 1, desiredSum, chosen, sumSoFar + i);
		           chosen.remove(chosen.size() - 1);
			 }
		 }
	}
	
	
}
