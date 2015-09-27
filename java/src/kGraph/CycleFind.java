package kGraph;

import java.util.Stack;

public class CycleFind {

	private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    
    public CycleFind(GraphList G) {
        if (hasSelfLoop(G)) return;
        if (hasParallelEdges(G)) return;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, -1, v);
    }
    
    // does this graph have a self loop?
    // side effect: initialize cycle to be self loop
    private boolean hasSelfLoop(GraphList G) {
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    cycle = new Stack<Integer>();
                    cycle.push(v);
                    cycle.push(v);
                    return true;
                }
            }
        }
        return false;
    }
    
	// does this graph have two parallel edges?
    // side effect: initialize cycle to be two parallel edges
    private boolean hasParallelEdges(GraphList G) {
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            // check for parallel edges incident to v
            for (int w : G.adj(v)) {
                if (marked[w]) {
                    cycle = new Stack<Integer>();
                    cycle.push(v);
                    cycle.push(w);
                    cycle.push(v);
                    return true;
                }
                marked[w] = true;
            }

            // reset so marked[v] = false for all v
            for (int w : G.adj(v)) {
                marked[w] = false;
            }
        }
        return false;
    }
    
    //dfs of all the vertices connected by an edge from a vertex should not lead to same edge
    private void dfs(GraphList G, int u, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            // short circuit if cycle already found
            if (cycle != null) return;

            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, v, w);
            }

            // check for cycle (but disregard reverse of edge leading to v)
            else if (w != u) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }
    	    
    public boolean hasCycle() {
        return cycle != null;
    }
    
    public Iterable<Integer> cycle() {
        return cycle;
    }
    
    public static void main(String[] args) {
        GraphList G = new GraphList(5);
        CycleFind finder = new CycleFind(G);
        if (finder.hasCycle()) {
            for (int v : finder.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        else {
        	System.out.println("Graph is acyclic");
        }
    }


}
