package eg.edu.alexu.csd.filestructure.graphs.test.cs59_07;

import java.io.File;
import java.util.ArrayList;

import eg.edu.alexu.csd.filestructure.graphs.IGraph;

public class Graph implements IGraph{

	private ArrayList<Edge> graph = new ArrayList<>();
	private int nomV = 0;
	private int nomE = 0;
	private java.util.Scanner sc;
	@Override
	public void readGraph(File file) {
		// TODO Auto-generated method stub
		try {
			sc = new java.util.Scanner(file);
			nomV = sc.nextInt();
			nomE = sc.nextInt();
			for (int i = 0; i < nomE; i++) {
				int src = sc.nextInt();
				int dest = sc.nextInt();
				int weight = sc.nextInt();
				graph.add(new Edge(src, dest, weight));
			}
			sc.close();
		} catch (Exception e) {
			
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
		return null;
	}

	@Override
	public ArrayList<Integer> getNeighbors(int v) {
		// TODO Auto-generated method stub
		return null;
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
		return false;
	}

}
