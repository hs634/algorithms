package kGraph;

public class WarshallFloyd {

	int V = 4;
	void floydWarshell (int[][] graph)
	{
		int[][] dist = new int[V][V];
		int i, j, k;
		
		 for (i = 0; i < V; i++){
			 for (j = 0; j < V; j++){
				 dist[i][j] = graph[i][j];
			 }
		 }
		 
		 for (k = 0; k < V; k++)
		    {
		        // Pick all vertices as source one by one
		        for (i = 0; i < V; i++)
		        {
		            // Pick all vertices as destination for the
		            // above picked source
		            for (j = 0; j < V; j++)
		            {
		                // If vertex k is on the shortest path from
		                // i to j, then update the value of dist[i][j]
		                if (dist[i][k] + dist[k][j] < dist[i][j])
		                    dist[i][j] = dist[i][k] + dist[k][j];
		            }
		        }
		    }
		        
	}
}