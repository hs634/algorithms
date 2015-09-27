package bStrings;

public class ReverseWordsInString {

	public static void main(String[] args){
		String s = "HOW ARE YOU";
		String t = reverse(s);
		System.out.println(t);
	}
	
	public static String reverse(String s){
		char[] sc = s.toCharArray();
		String t="";
		int j = s.length()-1;
		j = rev(sc, j);
		System.out.println(sc);
		
		j=0; 
		int k = 0;
		for(int i=0;i<sc.length;){
			while(j< sc.length-1 && sc[j]!=' ') j++;
			k = j;
			int len = j-i;
			j--;
			if(len!=0){
				while(i<j){
					char tmp = sc[i];
					sc[i] = sc[j];
					sc[j] = tmp;
					i++;
					j--;
				}
				
			}
			j = k+1;
			i = j;
		}
		System.out.println(sc);
		return t;
	}

	private static int rev(char[] sc, int j) {
		for(int i=0;i<sc.length/2; i++){
			char tmp = sc[i];
			sc[i] = sc[j];
			sc[j] = tmp;
			j--;
		}
		return j;
	}
}

