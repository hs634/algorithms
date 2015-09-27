package kGraph;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import kGraph.ADijskstra.TermCount;

public class APrimKruskal {
	/**
	 * KRUSKAL:
	 * 1. Sort all the edges in non-decreasing order of their weight.
	 * 2. Pick the smallest edge. Check if it forms a cycle with the spanning tree 
	 * formed so far. If cycle is not formed, include this edge. Else, discard it.  
	 * 3. Repeat step#2 until there are (V-1) edges in the spanning tree.
	 */
	
	/**
	 * PRIMS:
	 * 
	 * Same as dijkstras.
	 * Add the min of edges connected to the verteex and not already added to the set
	 * 
	 */
	
	AdjancencyMatrix G;
	int V;
	int[] dist;
	int[] path;
	Queue<TermCount> minPQ;
	boolean[] visited;
	Stack<Integer> st = new Stack<Integer>();
	
	APrimKruskal(int V){
		this.G = new AdjancencyMatrix(V);
		this.V = V;
		dist = new int[V];
		path = new int[V];
		visited = new boolean[V];
	}

	public void prims(int src){
		
		for(int i=0; i <G.V();i++){
			dist[i] = Integer.MAX_VALUE;
		}
		st.add(src);
		int v = src;
		int dist = Integer.MAX_VALUE;
		for(int i=0; i <G.V();i++){
			int vertex = -1;
			for(int w : G.adj(v)){
				if(!visited[w] && dist > G.adj[v][w]){
					dist = G.adj[v][w];
					vertex = w;
				}
			}
			v = vertex;
			st.add(v);
			visited[v] = true;
		}
	}
}
