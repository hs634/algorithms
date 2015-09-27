package kGraph;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GraphMatrix {

	  private int V;
	  private int E;
	  private boolean[][] adj;
	  
    public GraphMatrix(int V) {
        if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        this.adj = new boolean[V][V];
    }
    
    // number of vertices and edges
    public int V() { return V; }
    public int E() { return E; }


    // add undirected edge v-w
    public void addEdge(int v, int w) {
        if (!adj[v][w]) E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }
    
    // does the graph contain the edge v-w?
    public boolean contains(int v, int w) {
        return adj[v][w];
    }
    
    public boolean weight(int v, int w) {
        return adj[v][w];
    }
    
    // return list of neighbors of v
    public Iterable<Integer> adj(int v) {
        return new AdjIterator(v);
    }
    
    
    // support iteration over graph vertices
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        int v, w = 0;
        AdjIterator(int v) { 
        	this.v = v; 
        	}

        public Iterator<Integer> iterator() { 
        	return this; 
        	}

        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w]) return true;
                w++;
            }
            return false;
        }

        public Integer next() {
            if (hasNext()) { 
            	return w++;                         
            }
            else{ 
            	throw new NoSuchElementException(); 
            }
        }

        public void remove()  { throw new UnsupportedOperationException();  }
    }
    
}
