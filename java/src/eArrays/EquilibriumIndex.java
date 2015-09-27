package eArrays;

/*Equilibrium index of an array is an index such that the sum of elements 
 * at lower indexes is equal to the sum of elements at higher indexes.
 * 
 * Initialize leftsum  as 0
 * 2) Get the total sum of the array as sum
 * 3) Iterate through the array and for each index i, do following.
 * 		a)  Update sum to get the right sum.  
           sum = sum - arr[i] 
       // sum is now right sum
        b) If leftsum is equal to sum, then return current index. 
        c) leftsum = leftsum + arr[i] // update leftsum for next iteration.
4) return -1 // If we come out of loop without returning then
             // there is no equilibrium index
 */
public class EquilibriumIndex {

	int equilibrium(int arr[], int n)
	{
	   int sum = 0;      // initialize sum of whole array
	   int leftsum = 0; // initialize leftsum
	   int i;
	 
	   /* Find sum of the whole array */
	   for (i = 0; i < n; ++i)
	        sum += arr[i];
	 
	   for( i = 0; i < n; ++i)
	   {
	      sum -= arr[i]; // sum is now right sum for index i
	 
	      if(leftsum == sum)
	        return i;
	 
	      leftsum += arr[i];
	   }
	 
	    /* If no equilibrium index found, then return 0 */
	    return -1;
	}
}
