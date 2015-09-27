package kGraph;

import java.util.LinkedList;
import java.util.Queue;

public class BellmanFord {
	

	void bellmanFord(AdjancencyMatrix G, int s)
	{
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(s);
		int[] dist = new int[G.V()];
		for(int i=0; i <G.V(); i++)
			dist[i] = Integer.MAX_VALUE;

		dist[s] = 0;
		int[] path = new int[G.V()];
		while(!Q.isEmpty())
		{
			int v = Q.remove();
			for(int w : G.adj(v))
			{
				int new_dist = dist[v] + G.adj[v][w];
				if(new_dist < dist[w])
				{
					dist[w] = new_dist;
					path[w] = v;
					if(!Q.contains(w))
						Q.add(w);
				}
			}
		}
	}

}
