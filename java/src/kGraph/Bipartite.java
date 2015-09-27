package kGraph;

import java.util.Stack;

public class Bipartite {

    private boolean isBipartite;   // is the graph bipartite?
    private boolean[] color;       // color[v] gives vertices on one side of bipartition
    private boolean[] marked;      // marked[v] = true if v has been visited in DFS
    private int[] edgeTo;          // edgeTo[v] = last edge on path to v
    private Stack<Integer> cycle;  // odd-length cycle
    
    public Bipartite(GraphList G) {
        isBipartite = true;
        color  = new boolean[G.V()];
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
        assert check(G);
    }
    
    private void dfs(GraphList G, int v) { 
        marked[v] = true;
        for (int w : G.adj(v)) {
            // short circuit if odd-length cycle found
            if (cycle != null) return;

            // found uncolored vertex, so recur
            if (!marked[w]) {
                edgeTo[w] = v;
                color[w] = !color[v];
                dfs(G, w);
            } 
            // if v-w create an odd-length cycle, find it
            else if (color[w] == color[v]) {
                isBipartite = false;
                cycle = new Stack<Integer>();
                cycle.push(w);  // don't need this unless you want to include start vertex twice
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
            }
        }
    }
    
    public boolean isBipartite() {
        return isBipartite;
    }
    
    public boolean color(int v) {
        if (!isBipartite)
            throw new UnsupportedOperationException("Graph is not bipartite");
        return color[v];
    }
    public Iterable<Integer> oddCycle() {
        return cycle; 
    }

    private boolean check(GraphList G) {
        // graph is bipartite
        if (isBipartite) {
            for (int v = 0; v < G.V(); v++) {
                for (int w : G.adj(v)) {
                    if (color[v] == color[w]) {
                        System.err.printf("edge %d-%d with %d and %d in same side of bipartition\n", v, w, v, w);
                        return false;
                    }
                }
            }
        }

        // graph has an odd-length cycle
        else {
            // verify cycle
            int first = -1, last = -1;
            for (int v : oddCycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
    	GraphList G = new GraphList(4);
    	Bipartite b = new Bipartite(G);
        if (b.isBipartite()) {
            System.out.println("Graph is bipartite");
            for (int v = 0; v < G.V(); v++) {
                System.out.println(v + ": " + b.color(v));
            }
        }
        else {
            System.out.print("Graph has an odd-length cycle: ");
            for (int x : b.oddCycle()) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
