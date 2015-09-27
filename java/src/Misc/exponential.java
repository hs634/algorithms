package Misc;

public class exponential {

	/*
	 * o(n)
	 */
	 public static double pow(double base, int exp){
	      if(exp < 0) return 1 / pow(base, -exp);
	      double ans = 1.0;
	      for(;exp > 0;--exp) ans *= base;
	      return ans;
	   }
	 /*
	  * O(log(n)+log(n))
	  * 1 if n > 0
	  * 1/x ^ -n if n <0
	  * x.x^n-1/2 ^ 2
	  * 
	  */
	 
	 int expo(int base, int exp){
		    int result;
		    
		    if (exp==2)
		        return base * base;

		    if (exp==1)
		        return base;

		    if (exp%2==1){
		        return base * expo(base,exp-1);
		    }
		    else{
		        result = expo(base,exp/2);
		        return result * result;
		    }
		}
	 
	 int expo_iterative(int base, int exp){
		  int result = 1;

		  while (exp > 0){
		    if (exp%2==1){
		      result *= base;
		    }
		    exp /= 2;
		    base *= base;
		  }

		  return result;
		}
	 
	 /**
	  * We can use bitwise AND (&) operator to check odd or even, as an example consider binary of 7
	  *	(0111) when we perform 7 & 1 the result will be one and you may observe that the least significant bit 
	  * of every odd number is 1, so ( odd_number & 1 ) will be one always and also ( even_number & 1 ) is zero.
	  */
	 int expo_mod(int base, int exp){
		  int result = 1;

		  while (exp > 0){
		    if ((exp&1) == 1){
		      result *= base;
		    }
		    exp >>=1 ;
		    base *= base;
		  }

		  return result;
		}
}
