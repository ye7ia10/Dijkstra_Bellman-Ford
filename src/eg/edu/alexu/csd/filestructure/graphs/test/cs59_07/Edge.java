package eg.edu.alexu.csd.filestructure.graphs.test.cs59_07;

public class Edge {
	
	
	private int to;
	private int weight;
	
	public Edge() {}
	
	public Edge( int to, int weight) {
		
		this.to = to;
		this.weight = weight;
	}
	
	
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
