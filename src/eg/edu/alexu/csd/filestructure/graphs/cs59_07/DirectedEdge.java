package eg.edu.alexu.csd.filestructure.graphs.cs59_07;

public class DirectedEdge {
	private int to;
	private int weight;
	public DirectedEdge(int to, int weight) {
		this.to= to;
		this.weight = weight;
	}	
	public int getTo() {
		return to;
	}
	public int getWeight() {
		return weight;
	}
}
