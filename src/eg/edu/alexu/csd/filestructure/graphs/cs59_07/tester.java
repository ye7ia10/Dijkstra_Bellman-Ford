package eg.edu.alexu.csd.filestructure.graphs.cs59_07;

import java.io.File;
import java.io.FileNotFoundException;

public class tester {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("test.txt");
		int [] dis = new int [5];
		Graph g = new Graph();
		g.readGraph(f);
		g.runDijkstra(0, dis);
		System.out.println(dis[3]);
	}

}
