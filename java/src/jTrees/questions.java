package jTrees;

import java.util.Arrays;
import java.util.Random;

public class questions {

	/**
	 * Write a function to return if a number is a palindrome (eg, 113848311
	 */
	// This function returns true if binary representation of x is
	// palindrome. For example (1000...001) is palindrome
	boolean isKthBitSet(int x, int k) {
		return ((x & (1 << (k - 1))) == 1) ? true : false;
	}

	boolean isPalindrome(int x) {
		int l = 1; // Initialize left position
		int r = Integer.SIZE * 8; // initialize right position

		// One by one compare bits
		while (l < r) {
			if (isKthBitSet(x, l) != isKthBitSet(x, r))
				return false;
			l++;
			r--;
		}
		return true;
	}

	// 12321
	boolean numPalindrome(int n) {

		int r = n;
		int reverse = 0;
		int sum = 0;
		while (r > 0) {
			reverse = sum * 10 + r % 10;
			r = r / 10;
		}
		if (n == reverse)
			return true;

		return false;

	}

	/**
	 * Partition an array in such way zeros to be moved on the left side of the
	 * array, other numbers on the right side of the array. Extra storage not
	 * allowed, only in-place.
	 */
	/*
	 * Count the number of non-zero elements as count. and insert such element
	 * in arr[count]
	 */
	// Function which pushes all zeros to end of an array.
	void pushZerosToEnd(int arr[], int n) {
		int count = 0; // Count of non-zero elements

		// Traverse the array. If element encountered is non-zero, then
		// replace the element at index 'count' with this element
		for (int i = 0; i < n; i++)
			if (arr[i] != 0)
				arr[count++] = arr[i]; // here count is incremented

		// Now all non-zero elements have been shifted to front and 'count' is
		// set as index of first 0. Make all elements 0 from count to end.
		while (count < n)
			arr[count++] = 0;
	}

	/**
	 * Write a function to modify a singly linked list, appending copies of the
	 * first N-1 elements to the end in reverse order. For example, ['A', 'B',
	 * 'C', 'D'] becomes ['A', 'B', 'C', 'D', 'C', 'B', 'A'].
	 */
	/*
	 * Maintain a stack, then as u pop the elements insert to linked list. else,
	 * traverse find the length of the list. Create a new list by copy. Reverse
	 * this list. Append both.
	 */

	/**
	 * Find maximun element or minimum element in rotated sorted array
	 * 
	 */
	/*
	 * It is the rotating point
	 */
	public static int findMaxInRotate(int ar[]) {
		if (ar == null || ar.length == 0)
			return -1;
		if (ar.length == 1)
			return ar[0];
		int left = 0, right = ar.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (mid == 0 || mid == ar.length - 1 || ar[mid] > ar[mid + 1])
				return ar[mid];
			else if (ar[mid] > ar[left])
				left = mid;
			else
				right = mid;
		}
		return -1;
	}

	/**
	 * You need to write a function to climb n steps you can climb either 1 step
	 * at a time or 2 steps a time, write a function to return number of ways to
	 * climb a ladder with n step.
	 */
	/*
	 * If you take 1 step there are n-1 steps if take 2 steps ther are n-2 steps
	 * so this is fibbonocci series
	 */
	/**
	 * How do you find middle element of a linked list in single pass. How do
	 * you find 3rd element from last in single pass.
	 */
	/*
	 * Maintain 2 ptrs, fast and slow. Or Move one k steps
	 */
	/**
	 * Given a 2D boolean array. Return the length of the biggest square where
	 * all elements inside it is true
	 */

	/**
	 * Smallest window containing the substring
	 */
	/*
	 * For example,S = “ADOBECODEBANC” T = “ABC” Minimum window is “BANC”. We
	 * start with our very first window: “ADOBEC”, windowSize = 6. We now have
	 * “A”:1, “B”:1, “C”:1 We skip the following character “ODE” since none of
	 * them is in our target T. We then see another “B” so we update “B”:2. Our
	 * candidate solution starts with an “A” so getting another “B” cannot make
	 * us a “trade”. We then see another “A” so we update “A”:2. Now we have two
	 * “A”s and we know we only need 1. If we keep the new position of this “A”
	 * and disregard the old one, we could move forward of our starting position
	 * of window. We move from A->D->O->B. Can we keep moving? Yes, since we
	 * know we have 2 “B”s so we can also disregard this one. So keep moving
	 * until we hit “C”: we only have 1 “C” so we have to stop. Therefore, we
	 * have a new candidate solution, “CODEBA”. Our new map is updated to “A”:1,
	 * “B”:1, “C”:1. We skip the next “N” and we arrive at “C”. Now we have two
	 * “C”s so we can move forward the starting position of last candidate: we
	 * move along this path C->O->D->E until we hit “B”. We only have one “B” so
	 * we have to stop. We have yet another new candidate, “BANC”. We have hit
	 * the end of S so we just output our best candidate, which is “BANC”
	 */
	public String minWindow(String S, String T) {
		int[] needToFind = new int[256];
		int[] hasFound = new int[256];

		for (int i = 0; i < T.length(); ++i) {
			needToFind[T.charAt(i)]++;
		}

		int count = 0;
		int minWindowSize = Integer.MAX_VALUE;
		int start = 0, end = 0;
		String window = "";

		for (; end < S.length(); end++) {
			if (needToFind[S.charAt(end)] == 0)
				continue;
			char c = S.charAt(end);
			hasFound[c]++;

			if (hasFound[c] <= needToFind[c]) {
				count++;
			}

			if (count == T.length()) {
				while (needToFind[S.charAt(start)] == 0
						|| hasFound[S.charAt(start)] > needToFind[S
								.charAt(start)]) {
					if (hasFound[S.charAt(start)] > needToFind[S.charAt(start)])
						hasFound[S.charAt(start)]--;
					start++;
				}

				if (end - start + 1 < minWindowSize) {
					minWindowSize = end - start + 1;
					window = S.substring(start, end + 1);
				}
			}
		}

		return window;
	}

	/**
	 * Maximum size sub square matrix 1) Construct a sum matrix S[R][C] for the
	 * given M[R][C]. a) Copy first row and first columns as it is from M[][] to
	 * S[][] b) For other entries, use following expressions to construct S[][]
	 * If M[i][j] is 1 then S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
	 * Else If M[i][j] is 0 S[i][j] = 0 2) Find the maximum entry in S[R][C] 3)
	 * Using the value and coordinates of maximum entry in S[i], print
	 * sub-matrix of M[][] 0 1 1 0 1 1 1 0 1 0 0 1 1 1 0 1 1 1 1 0 1 1 1 1 1 0 0
	 * 0 0 0 0 1 1 0 1 1 1 0 1 0 0 1 1 1 0 1 1 2 2 0 1 2 2 3 1 0 0 0 0 0
	 */

	void printMaxSubSquare(int[][] M, int R, int C) {
		int i, j;
		int[][] S = new int[R][C];
		int max_of_s, max_i, max_j;

		/* Set first column of S[][] */
		for (i = 0; i < R; i++)
			S[i][0] = M[i][0];

		/* Set first row of S[][] */
		for (j = 0; j < C; j++)
			S[0][j] = M[0][j];

		/* Construct other entries of S[][] */
		for (i = 1; i < R; i++) {
			for (j = 1; j < C; j++) {
				if (M[i][j] == 1)
					S[i][j] = Math.min(Math.min(S[i][j - 1], S[i - 1][j]),
							S[i - 1][j - 1]) + 1;
				else
					S[i][j] = 0;
			}
		}

		/*
		 * Find the maximum entry, and indexes of maximum entry in S[][]
		 */
		max_of_s = S[0][0];
		max_i = 0;
		max_j = 0;
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				if (max_of_s < S[i][j]) {
					max_of_s = S[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}
		int low_x = max_i - max_of_s;
		int low_y = max_j - max_of_s;
		// printf("\n Maximum size sub-matrix is: \n");
		for (i = max_i; i > max_i - max_of_s; i--) {
			for (j = max_j; j > max_j - max_of_s; j--) {
				// ("%d ", M[i][j]);
			}
			// printf("\n");
		}
	}

	/*
	 * Maximum of 2 numbers: if a > b a-b is +ve return A else b a-b=-ve let k=1
	 * else k=0 returns a-k*(a-b) Let c = a-b, k = most significant bit of c,
	 * return a- k*c
	 */

	int getMax(int a, int b) {
		int c = a - b;
		int k = (c >> 31) & 1;
		int max = a - k * c;
		return max;
	}

	/*
	 * Add two numbers without using arithmetic operators 2 + 2 = 10 + 10 = 4 =
	 * 100 10 XOR 10 = 00 10 AND 10 = 1
	 */
	int Add(int x, int y)
	{
	    // Iterate till there is no carry  
	    while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	    }
	    return x;
	}
	
	int Add_recur(int x, int y)
	{
	    if (y == 0)
	        return x;
	    else
	        return Add( x ^ y, (x & y) << 1);
	}
	
	/*Find pairs of integers in an array that sum to a value*/
	public static void printPairSums(int[] array, int sum) {
	    Arrays.sort(array);
	    int first = 0;
	    int last = array.length - 1;
	    while (first < last) {
	        int s = array[first] + array[last];
	        if (s == sum) {
	            System.out.println(array[first] + "" + array[last]);
	            ++first;
	            --last;
	        } else {
	            if (s < sum)
	                ++first;
	            else
	                --last;
	        }
	    }
	}

	/*
	 * Given a function which generates a random integer in the range 1 to 7, write a function which generates
	 *  a random integer in the range 1 to 10 uniformly
	 */
	
	public int random1to10(){
		Random rand = new Random(); 
		int max = 7;
		int min =1;
		int n1 = rand.nextInt((max - min) + 1) + min; 
		int n2 = rand.nextInt((max - min) + 1) + min;
		if(n1*n2  < 40)
			return (n1*n2 ) % 10 + 1;
		else 
			return random1to10();
		}
		
}
