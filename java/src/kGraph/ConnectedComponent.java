package kGraph;

import java.util.ArrayList;

public class ConnectedComponent {

    private boolean[] marked;   // marked[v] = has vertex v been marked?
    private int[] id;           // id[v] = id of connected component containing v
    private int[] size;         // size[id] = number of vertices in given component
    private int count;          // number of connected components
    
    public ConnectedComponent(GraphList G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        /*run the dfs for every node in the graph which is not already encountered
         * If all vertices are visited in one sweep by dfs then connected,
         * else calculates the number of connected components
         */
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

	private void dfs(GraphList G, int v) {
		  marked[v] = true;
          id[v] = count;
          size[count]++;
          for (int w : G.adj(v)) {
              if (!marked[w]) {                  
            	  dfs(G, w);
              }
          }		
	}
	
	 public int id(int v) {
	        return id[v];
	    }
	 
	 public int size(int v) {
	        return size[id[v]];
	    }
	 
	 public boolean connected(int v, int w) {
	        return id(v) == id(w);
	    }
	 
	 public static void main(String[] args){
		 GraphList G = new GraphList(5);
		 ConnectedComponent cc = new ConnectedComponent(G);
		 int M = cc.count;
		 ArrayList<ArrayList<Integer>> components = new  ArrayList<ArrayList<Integer>> ();
		 for (int i = 0; i < M; i++) {
			 components.add(new ArrayList<Integer>()); 
	     }
        for (int v = 0; v < G.V(); v++) {
        	components.get(cc.id(v)).add(v);
        }
	     // print results
	        for (int i = 0; i < M; i++) {
	            for (int v : components.get(i)) {
	                System.out.print(v + " ");
	            }	            System.out.println();
	        }
	 }
}
