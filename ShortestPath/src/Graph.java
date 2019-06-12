import java.util.*;
import java.util.Map.Entry;

public class Graph {
	
	private ArrayList<Node> nodes;
	private int nodeCount;
	private int edgeCount;

	public Graph() {
		// TODO Auto-generated constructor stub
	}

	public Graph(ArrayList<Node> nodes, int nodeCount, int edgeCount) {
		super();
		this.nodes = nodes;
		this.nodeCount = nodeCount;
		this.edgeCount = edgeCount;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}

	public int getEdgeCount() {
		return edgeCount;
	}

	public void setEdgeCount(int edgeCount) {
		this.edgeCount = edgeCount;
	}
	
	public Node getNode(Graph g, int num) {
		for(Node node : g.getNodes()) {
			if(node.getName().equals(Integer.toString(num))) {
				return node;
			}
		}
		return null;
	}
	
	public boolean isAdjacent(Node source, Node dest) {

			if(source.getAdjacentNodes().containsKey(dest))
				return true;
			else
				return false;
		
	}

}
