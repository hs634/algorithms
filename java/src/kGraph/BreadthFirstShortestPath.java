package kGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Computes the shortest path between the source vertex <tt>s</tt>
 * and every other vertex in the graph <tt>G</tt>.
 * @param G the graph
 * @param s the source vertex
 */
/*
 * Given a source and the target. If it has path to target, then the path is degree of seperation
 * Also computes the degree of separation
 */

/*
 * 	Can be used in web crawler
 * 	String regexp = "http://(\\w+\\.)+(\\w+)";
 *   Pattern pattern = Pattern.compile(regexp);
 *    Matcher matcher = pattern.matcher(input);
 */
public class BreadthFirstShortestPath {
	
	private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path

    public BreadthFirstShortestPath(GraphList G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);
        //assert check(G, s);
    }
    
    public void bfs(GraphList G, int s){
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    	 for (int v = 0; v < G.V(); v++) distTo[v] = INFINITY;
         distTo[s] = 0;
         marked[s] = true;
         q.add(s);
         
         while(!q.isEmpty()){
        	 int v = q.remove();
        	 for(int w : G.adj(v)){
        		 if(!marked[w]){
        			 edgeTo[w] = v;
        			 distTo[w] =distTo[v] + 1;
        			 marked[w] = true;
        			 q.add(w);
        			 
        		 }
        	 }
         }
         
    }
    
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    
    public int distTo(int v) {
        return distTo[v];
    }
    
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }
    
    
    public static void main(String[] args){
    	
    	GraphList G = new GraphList(4);
    	int s = 0;
    	BreadthFirstShortestPath bfs = new BreadthFirstShortestPath(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                System.out.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
                    if (x == s) 
                    	System.out.print(x);
                    else        
                    	System.out.print("-" + x);
                }
                System.out.println();
            }else{
            	System.out.printf("%d to %d (-):  not connected\n", s, v);
        	}

        }
    }
}
