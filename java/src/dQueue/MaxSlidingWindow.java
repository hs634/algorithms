package dQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/*4,6,2,5,10,4,7,1,8,2,11
 * k = 3, then print max in [4,6,2],[6,2,5],[10,4,7],[4,7,1],[7,1,8],[1,8,2],[8,2,11]
 * n*k solution is to loop through outer and inner
 */

/*
 *  For example, if the current queue has the elements: [10 5 3], and a new element in the window has the element 11. 
 *  Now, we could have emptied the queue without considering elements 10, 5, and 3, and insert only element 11 into the queue.
 *  Remove the elements from back which are lesser than current. Also remove the front if its index is out of the current
 *  window. So the queue is always sorted and contains only elements that matter
 *  Ex: 6: 6,2:  6,5: 10 : 10,4 : 10,7: 7,1: 8: 8:2, 11
 */
public class MaxSlidingWindow {

	public static void maxslidingWindow(int[] arr, int k){
		Deque<Integer> q = new ArrayDeque<Integer>();
		int n = arr.length;
		for(int i=0;i<k;i++){
			while(!q.isEmpty() && arr[q.peekLast()] < arr[i]){
				q.removeLast();
			}
			q.addLast(i);
		}
		System.out.println(arr[q.peekFirst()] + " ");
		for(int i=k;i<n;i++){
			while(!q.isEmpty() && arr[q.peekLast()] < arr[i]){
				q.removeLast();
			}
			while(!q.isEmpty() && q.peekFirst() <= i-k){
				q.removeFirst();
			}
			q.addLast(i);
			System.out.println(arr[q.peekFirst()] + " ");
		}
		
	}
	
	public static void main(String[] args){
		int[] arr = {4,6,2,5,10,4,7,1,8,2,11};
		maxslidingWindow(arr, 3);
	}
}
