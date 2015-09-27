package kGraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
	
	final static int N = 5;
	GraphMatrix graph = new GraphMatrix(N);
	int[] indegree = new int[N];
	int counter = 0;
	
	public void sort(){
		
		for(int v=0; v <graph.V(); v++){
			for(int w : graph.adj(v)){
				indegree[w]++;
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> order = new LinkedList<Integer>();
		for(int v=0; v <graph.V(); v++){
			if(indegree[v] == 0){
				queue.add(v);
			}
		}
		
		while(!queue.isEmpty()){
			int v = queue.remove();
			counter++;
			order.add(v);
			for(int w : graph.adj(v)){
				indegree[w]--;
				if(indegree[w] == 0)
					queue.add(w);
			}
		}
		
		if(counter != graph.V()){
			System.out.println("Graph has a cycle");
		}else{
			System.out.println("Topological sorting:");
			Iterator<Integer> it = order.iterator();
			while(it.hasNext()){
				System.out.println(it.next() + "\t");
			}
		}
		
	}
	
	
/*
 *     private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        preorder.enqueue(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        postorder.enqueue(v);
        post[v] = postCounter++;
    }
 */
	
	
	
}
