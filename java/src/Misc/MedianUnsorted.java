package Misc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianUnsorted {

	Integer N = 100;
	Queue<Integer> max_pq_small = new PriorityQueue<Integer>(N,
			new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
		
	});
	Queue<Integer> min_pq_large = new PriorityQueue<Integer>(N,
			new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}

});
	
	public void median(Integer elem){
		
		if(max_pq_small.isEmpty() || elem < max_pq_small.peek()){
			max_pq_small.add(elem);
		}else{
			min_pq_large.add(elem);
		}
		
		if(Math.abs(max_pq_small.size() - min_pq_large.size()) > 1){
			if(max_pq_small.size() > min_pq_large.size()){
				min_pq_large.add(max_pq_small.poll());
			}else{
				max_pq_small.add(min_pq_large.poll());
			}
		}
	}
	
	public int getMedian(){
		if(max_pq_small.size() == min_pq_large.size())
			return max_pq_small.peek() + min_pq_large.peek()/2;
		else if(max_pq_small.size() > min_pq_large.size())
			return max_pq_small.peek();
		else
			return min_pq_large.peek();
	}
	
}
