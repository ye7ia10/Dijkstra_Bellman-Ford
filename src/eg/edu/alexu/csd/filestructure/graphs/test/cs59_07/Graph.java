package eg.edu.alexu.csd.filestructure.graphs.test.cs59_07;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import eg.edu.alexu.csd.filestructure.graphs.IGraph;

public class Graph implements IGraph{

	private ArrayList<Edge> graph = new ArrayList<>();
	private int nomV = 0;
	private int nomE = 0;
	private java.util.Scanner sc;
	private HashSet<Integer> vertex = new HashSet<>();
	
	@Override
	public void readGraph(File file) {
		// TODO Auto-generated method stub
		try {
			sc = new java.util.Scanner(file);
			nomV = sc.nextInt();
			nomE = sc.nextInt();
			for (int i = 0; i < nomE; i++) {
				int src = sc.nextInt();
				vertex.add(src);
				int dest = sc.nextInt();
				vertex.add(dest);
				int weight = sc.nextInt();
				graph.add(new Edge(src, dest, weight));
			}
			sc.close();
		} catch (Exception e) {
			return;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return nomE;
	}

	@Override
	public ArrayList<Integer> getVertices() {
		// TODO Auto-generated method stub
		if (size() == 0)
			return null;
		ArrayList<Integer> res = new ArrayList<Integer>(vertex);
		return res;
	}

	@Override
	public ArrayList<Integer> getNeighbors(int v) {
		// TODO Auto-generated method stub
		HashSet<Integer> res = new HashSet<>();
		for (int i = 0; i < graph.size(); i++) {
			if (graph.get(i).getFrom() == v) {
				res.add(graph.get(i).getTo());
			}
		}
		if (res.size() == 0)
			return null;
		ArrayList<Integer> nei = new ArrayList<>(res);
		return nei;
	}

	@Override
	public void runDijkstra(int src, int[] distances) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Integer> getDijkstraProcessedOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean runBellmanFord(int src, int[] distances) {
		// TODO Auto-generated method stub
		int max = Integer.MAX_VALUE / 2;
		for (int i= 0; i < nomV; i++) {
            distances[i] = max; 
		}
        distances[src] = 0;
        
        for (int i=1; i<nomV; i++) 
        { 
            for (int j=0; j<nomE; j++) 
            { 
                int u = graph.get(j).getFrom(); 
                int v = graph.get(j).getTo(); 
                int weight = graph.get(j).getWeight(); 
                if (distances[u]!= max && distances[u]+weight<distances[v]) {
                    distances[v]=distances[u]+weight; 
                }
            } 
        } 
        
        for (int j=0; j<nomE; j++) 
        { 
        	   int u = graph.get(j).getFrom(); 
               int v = graph.get(j).getTo(); 
               int weight = graph.get(j).getWeight(); 
               if (distances[u] != max && distances[u]+weight < distances[v]) {
            	   return false;
              }
        }
		return true;
	}

}
