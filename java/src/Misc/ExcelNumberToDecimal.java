package Misc;

public class ExcelNumberToDecimal {

	static String decToExcel(int decNum) {
		String result = "";
		char digit = (char) ('A' + (decNum - 1) % 26);
	    result += digit;
	    while ((decNum - 1) / 26 > 0) {
	        decNum = (decNum - 1) / 26;
	        digit = (char) ('A' + (decNum - 1) % 26);
	        result += digit;
	    }
	    String reverseResult = "";
	    for(int k=result.length()-1;k>=0;k--){
	    	reverseResult +=result.charAt(k);	
	    }
	    return reverseResult;
	}
	 
	static int excelToDec(String excelNum) {
	    int result = 0;
	    char[] charArray = excelNum.toCharArray();
	    for (int i = 0; i < (int) charArray.length; ++i) {
	        result *= 26;
	        result += charArray[i] - 'A' + 1;
	    }
	    return result;
	}
	
	public static void main(String[] args){
		
		int decNum = 30;
		String excel = decToExcel(decNum);
		int dec = excelToDec(excel);
		System.out.println(excel + "-" + dec);
	}
	
	/**
	 * Take mod 26. add 'A' + (num-1)%26 until num-1/26 >0
	 */
}
