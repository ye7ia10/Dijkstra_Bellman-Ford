package eg.edu.alexu.csd.filestructure.graphs.cs59_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

import javax.management.RuntimeErrorException;

import eg.edu.alexu.csd.filestructure.graphs.IGraph;


public class Graph implements IGraph{
	private int numOfVertices = 0;
	private int numOfEdges = 0;
	private HashSet<Integer> VertecesInGraph = new HashSet<>();
	private Edge []edges;
	private ArrayList<ArrayList <DirectedEdge> > adjecentList = new ArrayList<>();
	private java.util.Scanner sc;
	private ArrayList<Integer> processedOrder = new ArrayList<Integer>();
	@Override
	public void readGraph(File file) {
		// TODO Auto-generated method stub
		try {
			sc = new java.util.Scanner(file);
			if(sc.hasNextInt()) {
				numOfVertices = sc.nextInt();
				for(int i = 0; i < numOfVertices; i++) {
					ArrayList<DirectedEdge> x = new ArrayList<>();
					adjecentList.add(x);
				}
			}
			if(sc.hasNextInt()) {
				numOfEdges = sc.nextInt();
				edges = new Edge[numOfEdges];
			}else {
				throw new RuntimeErrorException(null);
			}
			if(!validNumOfVerticesAndEdges()) {
				throw new RuntimeErrorException(null);
			}
			for(int i = 0; i < numOfEdges; i++) {
				int from,to,weight;
				if(sc.hasNextInt()) {
					from = sc.nextInt();
					VertecesInGraph.add(from);
				}else {
					throw new RuntimeErrorException(null);
				}
				if(sc.hasNextInt()) {
					to = sc.nextInt();
					VertecesInGraph.add(to);
				}else {
					throw new RuntimeErrorException(null);
				}
				if(sc.hasNextInt()) {
					weight = sc.nextInt();
				}else {
					throw new RuntimeErrorException(null);
				}
				if(from >= numOfVertices || to >= numOfVertices || from < 0 || to < 0) {
					throw new RuntimeErrorException(null);
				}
				Edge edge = new Edge(from, to, weight);
				edges[i] = edge;
				
				DirectedEdge directedEdge = new DirectedEdge(to, weight);
				adjecentList.get(from).add(directedEdge);
				
				
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeErrorException(null);
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numOfEdges;
	}

	@Override
	public ArrayList<Integer> getVertices() {
		// TODO Auto-generated method stub
		if (size() == 0)
			return null;
		return new ArrayList<Integer>(VertecesInGraph);
	}

	@Override
	public ArrayList<Integer> getNeighbors(int v) {
		// TODO Auto-generated method stub
		ArrayList <Integer>arr = new ArrayList<Integer>();
		for(DirectedEdge e : adjecentList.get(v)) {
			arr.add(e.getTo());
		}
		return arr;
	}

	
	@Override
	public void runDijkstra(int src, int[] distances) {
		// TODO Auto-generated method stub
		if(src < 0 || src >= distances.length) {
			throw new RuntimeErrorException(null);
		}
		PriorityQueue<Distance> pq = new 
	             PriorityQueue<Distance>(1, new distanceComparator()); 
		boolean visited[] = new boolean [distances.length];
		for(int i = 0; i < distances.length; i++) {
			distances[i] = Integer.MAX_VALUE / 2;
			visited[i] = false;
		}
		
		distances[src] = 0;
		
		Distance source = new Distance(0, src);
		pq.add(source);
		while(!pq.isEmpty()) {
			Distance minDistance = pq.poll();
			
			if(visited[minDistance.vertix])
				continue;
			processedOrder.add(minDistance.vertix);
			visited[minDistance.vertix] = true;
			for(DirectedEdge e : adjecentList.get(minDistance.vertix)) {
				if(e.getWeight() + minDistance.distance < distances[e.getTo()]) {
					distances[e.getTo()] = e.getWeight() + minDistance.distance;
					pq.add(new Distance(distances[e.getTo()], e.getTo()));
				}
			}
		}
		
	}
	
	@Override
	public ArrayList<Integer> getDijkstraProcessedOrder() {
		// TODO Auto-generated method stub
		return processedOrder;
	}

	@Override
	public boolean runBellmanFord(int src, int[] distances) {
		// TODO Auto-generated method stub
		int max = Integer.MAX_VALUE / 2;
		for (int i= 0; i < numOfVertices; i++) {
            distances[i] = max; 
		}
        distances[src] = 0;
        
        for (int i = 1; i < numOfVertices; i++) 
        { 
            for (int j = 0; j < numOfEdges; j++) 
            { 
                int u = edges[j].getFrom(); 
                int v = edges[j].getTo(); 
                int weight = edges[j].getWeight(); 
                if (distances[u]!= max && distances[u]+weight<distances[v]) {
                    distances[v]=distances[u]+weight; 
                }
            } 
        } 
        
        for (int j=0; j<numOfEdges; j++) 
        { 
        	   int u = edges[j].getFrom(); 
               int v = edges[j].getTo(); 
               int weight = edges[j].getWeight(); 
               if (distances[u] != max && distances[u]+weight < distances[v]) {
            	   return false;
              }
        }
		return true;
	}
	boolean validNumOfVerticesAndEdges() {
		if(numOfEdges < 0 || numOfVertices < 0)
			return false;
		if(numOfVertices == 0 && numOfEdges > 0)
			return false;
		
		return true;
	}
	class distanceComparator implements Comparator<Distance>{ 
        

		@Override
		public int compare(Distance o1, Distance o2) {
			// TODO Auto-generated method stub
			if(o1.distance > o2.distance)
				return 1;
			return -1;
		} 
    } 
}
