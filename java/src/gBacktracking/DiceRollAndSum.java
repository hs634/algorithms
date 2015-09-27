package gBacktracking;

import java.util.ArrayList;
import java.util.List;

public class DiceRollAndSum {

	/*
	 * Prints all possible outcomes of rolling the given number of six-sided dice in [#, #, #] format.
	 */
	
	public static void diceRolls(int dice){
		List<Integer> chosen = new ArrayList<Integer>();
		diceRolls(dice, chosen);
	}

	private static void diceRolls(int dice, List<Integer> chosen) {
		if(dice == 0)
			System.out.println(chosen);
		else{
			for(int i = 1; i<=6; i++){
				chosen.add(i);				//choose
				diceRolls(dice - 1 , chosen); //explore
				chosen.remove(chosen.size() - 1); //unchoose
			}
		}
	}
	
	/**
	 * Write a method diceSum similar to diceRoll, but it also accepts a desired sum and prints only 
	 * combinations that adds up to exactly that sum.
	 */
	
	public static void diceSum(int dice, int sum){
		List<Integer> chosen = new ArrayList<Integer>();
		diceSum(dice, sum, chosen);
	}

	private static void diceSum(int dice, int sum, List<Integer> chosen) {

		if(dice == 0 && sums(chosen) == sum){
			System.out.println(chosen);
		}
		else{
			for(int i=1; i <= 6; i++){
				chosen.add(i);
				diceSum(dice -1 , sum, chosen);
				chosen.remove(chosen.size() -1);
			}
		}
	}

	private static int sums(List<Integer> chosen) {
		int sum = 0;
		for(Integer i : chosen){
			sum += i;
		}
		return sum;
	}
	
}
