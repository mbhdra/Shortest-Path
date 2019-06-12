import java.util.*;

public class Node {
	
	private ArrayList<Node> shortestPath;
	private HashMap<Node, Integer> adjacentNodes;
	private Integer distance;
	private String name;
	private boolean isVisited;

	public Node() {
		// TODO Auto-generated constructor stub
	}

	public Node(ArrayList<Node> shortestPath, HashMap<Node, Integer> adjacentNodes, String name) {
		super();
		this.shortestPath = shortestPath;
		this.adjacentNodes = adjacentNodes;
		this.distance = 999999999;
		this.name = name;
		this.isVisited = false;
	}

	public ArrayList<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(ArrayList<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public HashMap<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(HashMap<Node, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public void addAdjacent(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

}
