package kGraph;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjancencyMatrix {

	  private int V;
	  private int E;
	  public Integer[][] adj;
	  
    public AdjancencyMatrix(int V) {
        if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        this.adj = new Integer[V][V];
    }
    
    // number of vertices and edges
    public int V() { return V; }
    public int E() { return E; }


    // add undirected edge v-w
    public void addEdge(int v, int w, int wt) {
        if (adj[v][w] == -1) E++;
        adj[v][w] = wt;
    }
    
    // does the graph contain the edge v-w?
    public boolean contains(int v, int w) {
        return adj[v][w]!=-1;
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
                if (adj[v][w]!=-1) return true;
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
    

