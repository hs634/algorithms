package eArrays;

public class KnuthShuffle {

	/** Swaps the values at addresses pointed to by x and y. */

	public void swap(int x, int y) {

	 int temp = x;
	 x = y;
	 y = temp;
	}

	/** Shuffles the array of length @a n such that

	 * all permutations are equally likely. */

	void shuffle(int[] array, int n) {

	 for (int i = 0; i < n; i++) {

		 int r = (int) (Math.random() * (n-i)+ i);
		 swap(array[i], array[r]);

	 }

	}
	
	/** Dynamic programming approach. */

	int maximal_subarray(int[] array, int n) {

		int max_sum_so_far = 0;

		int current_sum_so_far = 0;

		for (int i = 0; i < n; i++) {

				current_sum_so_far = Math.max(current_sum_so_far + array[i], 0);

				max_sum_so_far = Math.max(max_sum_so_far, current_sum_so_far);

	 }

	 return max_sum_so_far;

	}
}
