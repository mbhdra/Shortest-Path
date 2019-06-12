import java.util.*;
import java.util.ArrayList;
import java.util.Map.Entry;

public class Dijkstra {

	public Dijkstra() {
		// TODO Auto-generated constructor stub
	}
	
	public Graph runDijkstra(Graph graph) {
		
		//ArrayList<Node> unvisitedNodes = new ArrayList<Node>();
		ArrayList<Node> visitedNodes = new ArrayList<Node>();
		PriorityQueue<Node> unvisitedNodes = new 
	             PriorityQueue<Node>(5, new NodeComparator());
		
		for(int i = 0; i < graph.getNodes().size(); i++) {
			unvisitedNodes.add(graph.getNodes().get(i));
		}

		while(unvisitedNodes.size() != 0) {
			Node node = unvisitedNodes.remove();
			

			for (Entry < Node, Integer> adjacencyPair : node.getAdjacentNodes().entrySet()) {
				Node adjacentNode = adjacencyPair.getKey();
	            Integer edgeWeight = adjacencyPair.getValue();
	            
	            if(adjacentNode.getDistance() > node.getDistance() + edgeWeight) {
	            	adjacentNode.setDistance(node.getDistance() + edgeWeight);
					ArrayList<Node> shortestPath = new ArrayList<>(node.getShortestPath());
					shortestPath.add(node);
					adjacentNode.setShortestPath(shortestPath);
	            }
			}
			
			visitedNodes.add(node);
			
		}
		graph.setNodes(visitedNodes);
		return graph;
	}
	
	private static Node chooseMinimum(ArrayList<Node> unvisitedNodes) {
		Node returnNode = new Node();
		int min = Integer.MAX_VALUE;
		
		for(Node node : unvisitedNodes) {
			if(node.getDistance() < min) {
				returnNode = node;
			}
		}
		return returnNode;
	}

}
