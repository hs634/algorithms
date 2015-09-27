package kGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class WordLadder {
	static String[] word = {"flirt", "flint", "fling","cling","clink","click","clock","cloak","croak", "creak", "break"};
	static Map<String, ArrayList<String>> hashMap = new HashMap<String,ArrayList<String>>();
	static String from = "flirt";
	static String to = "break";
	
    public static boolean isNeighbor(String a, String b) {
        int differ = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) differ++;
        }
        return (differ == 1);
    }
    
    public static void addEdge(){
    	int N = word.length;
    	
		for(int i =0; i<N; i++){
			for(int j= i+1; j<N; j++){
				if(isNeighbor(word[i], word[j])){
					if(!hashMap.containsKey(word[i]))
						hashMap.put(word[i], new ArrayList<String>());
					hashMap.get(word[i]).add(word[j]);
					if(!hashMap.containsKey(word[j]))
						hashMap.put(word[j], new ArrayList<String>());
					hashMap.get(word[j]).add(word[i]);
				}
			}
		}
    }
    
    public static void bfs() {
    	HashMap<String, String> path  = new HashMap<String, String>();
    	Set<String> traversed  = new HashSet<String>();
    	LinkedList<String> queue = new LinkedList<String>();
    	queue.add(from);
    	
    	while(!queue.isEmpty()){
    		String v = queue.removeFirst();
    		traversed.add(v);
    		if(v.equals(to)) break;
    		for(String w : hashMap.get(v)){
    			if(!traversed.contains(w)){
    				traversed.add(w);
    				queue.add(w);
    				path.put(w, v);
    			}
    		}
    	}
    	
    	if(traversed.contains(to))
    		return;
    	String t = path.get(to);
    	System.out.println(t);
    	while(!t.equals(from)){
    		t = path.get(t);
    		System.out.println(t);
    	}
      
    }

    public static void main(String[] args){
    	addEdge();
    	bfs();
    }
}
/**
	//flirt, flint, *  fling,*  cling, *  clink, *  click, *  clock, *  cloak, *  croak, * , creak, *  break
	public static void main(String[] args) 
	{
		String from = "flirt";
		String to = "break";
	   // return true if two strings differ in exactly one letter
	 
	bfs(G, from);
	       if (hasPathTo(to)) 
	StdOut.println(pathTo(to));
	else                        
	StdOut.println("NOT CONNECTED");

	}

	 public void addEdge(String v, String w) {
	       E++;
	       adj.put(v,adj.get(v).add(w))
	  	adj.put(v,adj.get(w).add(v))
	    }
	    
	public class Graph {
	    private final int V;
	    private int E;
	    private HashMap<String,List<String>> adj;
	}
	 // breadth-first search from multiple sources
	    private void bfs(Graph G, String s) {
	        Queue<String> q = new Queue<String>();
	 marked[s] = true;
	        distTo[s] = 0;
	        q.enqueue(s);
	        while (!q.isEmpty()) {
	            int v = q.dequeue();
	            for (String w : G.adj.get(v)) {
	                if (!marked[w]) {
	                    edgeTo[w] = v;
	                    distTo[w] = distTo[v] + 1;
	                    marked[w] = true;
	                    q.enqueue(w);
	                }
	            }
	        }
	    }
	   public boolean hasPathTo(String v) {
	        return marked[v];
	    }
	   public ArrayList<String> pathTo(String v) {
	        if (!hasPathTo(v)) return null;
	        ArrayList<String> path = new ArrayList<String>();
	        String x;
	        for (x = v; distTo[x] != 0; x = edgeTo[x])
	            path.put(x);
	        path.push(x);
	        return path;
	    }

}*/
