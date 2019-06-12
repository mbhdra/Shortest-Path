import java.util.ArrayList;
import java.util.Map.Entry;

public class BellmanFord {

	public BellmanFord() {
		// TODO Auto-generated constructor stub
	}
	
public Graph runBellmanFord(Graph graph) {
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		nodes = graph.getNodes();
		
		for(int i = 0; i < nodes.size(); i++) {
			
			for(int j = 0; j < nodes.size(); j++) {
				
				for (Entry < Node, Integer> adjacencyPair : nodes.get(j).getAdjacentNodes().entrySet()) {
					Node adjacentNode = adjacencyPair.getKey();
					Integer edgeWeight = adjacencyPair.getValue();
	            
					if(adjacentNode.getDistance() > nodes.get(j).getDistance() + edgeWeight) {
						adjacentNode.setDistance(nodes.get(j).getDistance() + edgeWeight);
						ArrayList<Node> shortestPath = new ArrayList<>(nodes.get(j).getShortestPath());
						shortestPath.add(nodes.get(j));
						adjacentNode.setShortestPath(shortestPath);
					}
				}
			}
			
		}
		
		graph.setNodes(nodes);
		return graph;
	}

}
