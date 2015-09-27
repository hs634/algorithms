package eArrays;

import java.util.Stack;

public class StockMaximize {
	
	public static void main(String[] args){
		Integer[] stock = {1,7,2,4,5,9,1,2,6};
		int profit = maxProfit(stock);
		System.out.println(profit);
		
	}
	
	public static int maxProfit(Integer[] stock){
		int profit = 0;
		Stack<Integer> stack = new Stack<Integer>();
		//Place 6 on the stack - the index
		int curr = stock[stock.length-1];
		stack.push(stock.length-1);
		for(int i = stock.length -2; i >=0;){
			while(i>=0 && stock[i] < curr) {
				i--;
			}
			if(i>=0){
				//9 will be on top of stack now.
				stack.push(i);
				curr = stock[i];
				i--;
			}
		}
	
		int sum = 0, counter = 0;
		for(int i=0 ; i<stock.length; i++){
			if(i<stack.peek()){
				sum+=stock[i];
				counter++;
			}else{
				profit+= stock[i]*counter - sum;	
				stack.pop();
				sum=0;
				counter = 0;
			}
		}
		
		return profit;
	}

}
