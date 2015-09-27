package eArrays;
/**
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * In probability theory and statistics, a median is described as the number separating the 
 * higher half of a sample, a population, or a probability distribution, from the lower half.
 * The median of a finite list of numbers can be found by arranging all the numbers from lowest 
 *	value to highest value and picking the middle one.
 * @author arpana
 *
 */
public class MedianSortedArray {

	public static void main(String[] args)
	{
	    int[] ar1 = {1, 12, 15, 26, 38};
	    int[] ar2 = {2, 13, 17, 30, 45};
	 
	    int n1 = ar1.length;
	    int n2 = ar2.length;
	    if (n1 == n2){
	    	int n = getMedian(ar1, ar2);
	    	 System.out.printf("Median is %d", n);
	    }
	    else
	        System.out.println("Doesn't work for arrays of unequal size");
	}
	
	/*
	 * Use merge procedure of merge sort. Keep track of count while comparing elements of two arrays. 
	 * If count becomes n(For 2n elements), we have reached the median. Take the average of the elements 
	 * at indexes n-1 and n in the merged array. 
	 */
		
	private static int getMedian(int[] ar1, int[] ar2) {
		//When all elements of first array are smaller. ar2[0] is median and vice versa
		int m1 = -1;
		int m2 = -1;
		int i =0;
		int j=0;
	    int n1 = ar1.length;
	       if(ar1[n1-1] < ar2[0]){
	    	m2 = ar2[0];
	    }
	    
	    for(int count =0 ;count <=n1; count++){
	    	if(i==n1){
	    		m1 = m2;
	    		m2 = ar2[0];
	    	}
	    	else if(j==n1){
	    		m1 = m2;
	    		m2 = ar1[0];
	    	}
	      	if(ar1[i] < ar2[j]){
	      		m1 = m2;
	      		m2 = ar1[i];
	      		i++;
	      	}
	      	else{
	      		m1 = m2;
	      		m2 = ar2[j];
	      		j++;
	      	}
	    }
		return (m1 + m2)/2;
	}
	
	/*
	 * Method 2 (By comparing the medians of two arrays)
     * This method works by first getting medians of the two sorted arrays and then comparing them.
     *1) Calculate the medians m1 and m2 of the input arrays ar1[] 
     *   and ar2[] respectively.
     *2) If m1 and m2 both are equal then we are done.
     *     return m1 (or m2)
     *3) If m1 is greater than m2, then median is present in one 
     *   of the below two subarrays.
     *    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
     *    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
     *4) If m2 is greater than m1, then median is present in one    
     *   of the below two subarrays.
     *   a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
     *   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
     *5) Repeat the above process until size of both the subarrays 
     *   becomes 2.
     *6) If size of the two arrays is 2 then use below formula to get 
     *  the median.
     *    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
	 */
	
	int median(int arr[], int n)
	{
	    if (n%2 == 0)
	        return (arr[n/2] + arr[n/2-1])/2;
	    else
	        return arr[n/2];
	}
	
	int getMedian2(int ar1[], int[] ar2, int n){
		
		int m1;
		int m2;
		
		if (n == 1)
	        return (ar1[0] + ar2[0])/2;
	 
	    if (n == 2)
	        return (Math.max(ar1[0], ar2[0]) + Math.min(ar1[1], ar2[1])) / 2;
	    
	    m1 = median(ar1, n);
	    m2 = median(ar2, n);
	    
	    if(m1==m2) return m1;
	    
	    if (m1 < m2)
	    {
	        if (n % 2 == 0)
	            return getMedian2(ar1, ar2, n - n/2 +1);
	        else
	            return getMedian2(ar1, ar2, n - n/2);
	    }
	 
	    /* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
	    else
	    {
	        if (n % 2 == 0)
	            return getMedian2(ar2, ar1, n - n/2 + 1);
	        else
	            return getMedian2(ar2, ar1, n - n/2);
	    }
		
	}
	
	/* 
	 * BINARY SEARCH:
	 * Method 3 (By doing binary search for the median):
	 * 1) Get the middle element of ar1[] using array indexes left and right.  
 	 *   Let index of the middle element be i.
	 * 2) Calculate the corresponding index j of ar2[]
 	 *     j = n Ð i Ð 1 
	 * 3) If ar1[i] >= ar2[j] and ar1[i] <= ar2[j+1] then ar1[i] and ar2[j]
 	 *   are the middle elements.
	 *      return average of ar2[j] and ar1[i]
	 * 4) If ar1[i] is greater than both ar2[j] and ar2[j+1] then 
	 *      do binary search in left half  (i.e., arr[left ... i-1])
	 * 5) If ar1[i] is smaller than both ar2[j] and ar2[j+1] then
 	 *     do binary search in right half (i.e., arr[i+1....right])
	 * 6) If you reach at any corner of ar1[] then do binary search in ar2[]
	 */
	
	/* This function returns median of ar1[] and ar2[].
	   Assumptions in this function:
	   Both ar1[] and ar2[] are sorted arrays
	   Both have n elements */
	int getMedian(int ar1[], int ar2[], int n)
	{
	    return getMedianRec(ar1, ar2, 0, n-1, n);
	}
	 
	/* A recursive function to get the median of ar1[] and ar2[]
	   using binary search */
	int getMedianRec(int ar1[], int ar2[], int left, int right, int n)
	{
	    int i, j;
	 
	    /* We have reached at the end (left or right) of ar1[] */
	    if (left > right)
	        return getMedianRec(ar2, ar1, 0, n-1, n);
	 
	    i = (left + right)/2;
	    j = n - i - 1;  /* Index of ar2[] */
	 
	    /* Recursion terminates here.*/
	    if (ar1[i] > ar2[j] && (j == n-1 || ar1[i] <= ar2[j+1]))
	    {
	        /* ar1[i] is decided as median 2, now select the median 1
	           (element just before ar1[i] in merged array) to get the
	           average of both*/
	        if (i == 0 || ar2[j] > ar1[i-1])
	            return (ar1[i] + ar2[j])/2;
	        else
	            return (ar1[i] + ar1[i-1])/2;
	    }
	 
	    /*Search in left half of ar1[]*/
	    else if (ar1[i] > ar2[j] && j != n-1 && ar1[i] > ar2[j+1])
	        return getMedianRec(ar1, ar2, left, i-1, n);
	 
	    /*Search in right half of ar1[]*/
	    else /* ar1[i] is smaller than both ar2[j] and ar2[j+1]*/
	        return getMedianRec(ar1, ar2, i+1, right, n);
	}
}
