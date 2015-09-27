package eArrays;

/*
 * Maximum sum such that no two elements are adjacent
 * 
 * Algorithm:
Loop for all elements in arr[] and maintain two sums incl and excl where 
incl = Max sum including the previous element and excl = Max sum excluding the previous element.

Max sum excluding the current element will be max(incl, excl) and max sum including the current element will be 
excl + current element (Note that only excl is considered because elements cannot be adjacent).

At the end of the loop return max of incl and excl.

Example:

  arr[] = {5,  5, 10, 40, 50, 35}

  inc = 5 
  exc = 0

  For i = 1 (current element is 5)
  incl =  (excl + arr[i])  = 5
  excl =  max(5, 0) = 5

  For i = 2 (current element is 10)
  incl =  (excl + arr[i]) = 15
  excl =  max(5, 5) = 5

  For i = 3 (current element is 40)
  incl = (excl + arr[i]) = 45
  excl = max(5, 15) = 15

  For i = 4 (current element is 50)
  incl = (excl + arr[i]) = 65
  excl =  max(45, 15) = 45

  For i = 5 (current element is 35)
  incl =  (excl + arr[i]) = 80
  excl = max(5, 15) = 65

And 35 is the last element. So, answer is max(incl, excl) =  80

 */
public class MaxSum {

	/*Function to return max sum such that no two elements
	 are adjacent */
	int FindMaxSum(int arr[], int n)
	{
	  int incl = arr[0];
	  int excl = 0;
	 
	  for (int i = 1; i < n; i++)
	  {
	     /* current max including i */
	     incl = excl + arr[i];
	     /* current max excluding i */
	     excl = Math.max(incl, excl);
	  }
	 
	   /* return max of incl and excl */
	   return Math.max(incl, excl);
	}
}
