package kGraph;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;


public class ADijskstra {
	AdjancencyMatrix G;
	int V;
	int[] dist;
	int[] path;
	Queue<TermCount> minPQ;
	
	ADijskstra(int V){
		this.G = new AdjancencyMatrix(V);
		this.V = V;
		dist = new int[V];
		path = new int[V];
	}
	
	static class TermCount {
		Integer term;
		Integer dist;

		TermCount(int term, int dist) {
			this.term = term;
			this.dist = dist;
		}
	}
	public void dijkstras(int src){
		
		for(int i=0; i <G.V();i++){
			dist[i] = Integer.MAX_VALUE;
		}
		
		minPQ = new PriorityQueue<TermCount>(V,
				new Comparator<TermCount>() {
			@Override
			public int compare(TermCount x, TermCount y) {
				return x.dist.compareTo(y.dist);
			}
		});
		
		TermCount t = new TermCount(src, 0);
		minPQ.add(t);
		
			dist[src] = 0;
			while(!minPQ.isEmpty()){
				TermCount v = minPQ.remove();
				for(int w : G.adj(v.term)){
					int new_d = dist[v.term] + G.adj[v.term][w];
					if(dist[w] > new_d){
						dist[w] = new_d;
						path[w] = v.term;
						Iterator<TermCount> iter = minPQ.iterator();
						while(iter.hasNext()){
							TermCount te = iter.next();
							if(te.term == w){
								te.dist = new_d;
							}
						}
						TermCount te = new TermCount(w, dist[w]);
						if(!minPQ.contains(te)){
							minPQ.add(te);
						}
						
					}
				} 
				
			}
	}

	

	/**
	 * PriorityQueue minPQ = new PriorityQueue();
	 * minPQ.enQueue(s);
	 * for(int i=0;i < G.vertexCount; i++)
	 * 		dist[i] = -1
	 * dist[s] = 0;
	 * 
	 * while(!minPQ.isEmpty){
	 * 	 v = minPQ.deleteMin();
	 *   for(int w: G.adj(v)){
	 *   	new_dist  = dist[v] + weight[v][w];
	 *   	if(dist[w]==-1){
	 *   		dist[w] = new_dist;
	 *   		minPQ.enqueu(w/d)
	 *   		path[w] = v;
	 *   	}
	 *   else{
	 *   	dist[w] > new_dist{
	 *   	dist[w] = new_dist;
	 *   	update priority queue w to d
	 *   	path[w] = v;
	 *   }
	 *   	
	 *   }
	 * 
	 */
}
