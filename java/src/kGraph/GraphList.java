package kGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphList {

	int V;
	int E;
	List<Integer>[] adj = null;
	
	GraphList(int V){
		this.V = V;
		this.E = 0;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for(int v = 0; v < V; v++){
			 adj[v] = new ArrayList<Integer>();
		}
	}
	
	GraphList(GraphList G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
	
	 public int V() {
	        return V;
	    }
	 
	 public int E() {
	        return E;
	    }
	 
	public void addEdge(int v, int w){
		if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
        E++;
        adj[v].add(w);
        adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v){
		 if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
		 return adj[v];
	}
	
}
