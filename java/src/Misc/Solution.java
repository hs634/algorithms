package Misc;
import java.io.*;
import java.util.HashMap;
public class Solution {
	int K;
	int L;
	int M;
	int N;
	String str;
    public Solution(int K, int L, int M, int N, String str) {
		this.K = K;
		this.L = L;
		this.M = M;
		this.N = N;
		this.str = str;
	}

	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	try{
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       	 	String line = br.readLine();
       	 	int N = Integer.parseInt(line);
       	 	line = br.readLine();
       	 	String[] splitLine = line.split(line, ' ');
       	 	int K = Integer.parseInt(splitLine[0]);
       	 	int L = Integer.parseInt(splitLine[1]);
       	 	int M = Integer.parseInt(splitLine[2]);
       	 	String str = br.readLine();
       	 	Solution sol = new Solution(K, L , M, N, str);
       	 	sol.frequentSubstring();
       	 	
    	}catch(IOException e){
    		throw new IllegalArgumentException("Please check your input");
    	}
    }

	private void frequentSubstring() {
		 HashMap<String, Integer> subMap = new HashMap<String, Integer>();
	      for(int c = K ; c <= L ; c++ )
	      {
	         for(int i = 0  ; i <= N-c ; i++ )
	         {
	            String sub = str.substring(i, c + i );
	            Integer count = subMap.get(sub);
	            if(count == null){
	            	subMap.put(sub, 1);
	            }else{
	            	subMap.put(sub, count+1);
	            }
	         
	         }
	      }
	      Integer maximum = 0;
	      for (int value : subMap.values()) {
             if(value > maximum){
                 maximum = value;
             }    
         }
	      String s = String.valueOf(maximum);
	      char[] c = s.toCharArray();
	      for(int i = 0; i< s.length();i++){
	    	  System.out.println(c[i]);
	      }
         
}
}