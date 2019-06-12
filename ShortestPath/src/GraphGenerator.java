import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GraphGenerator {

	Graph graph = new Graph();
	ArrayList<Node> nodes = new ArrayList<Node>();
	
	public GraphGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public Graph generateGraph(String path) {
		
		readFile(path);
		graph.setNodes(nodes);
		return graph;
		
	}
	
	private void readFile(String path) {
		
		try {
            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";

            while ((readLine = b.readLine()) != null) {
            	if(readLine.charAt(0) != 'c') {
            		String[] parts = parseLine(readLine);
            		handleParts(parts);
            	}	
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private static String[] parseLine(String line) {
		
		String[] parts = line.split(" ");
		for(String part : parts) {	
			part = part.trim();
		}
		return parts;
	}
	
	private void handleParts(String[] parts) {
		
		if(parts[0].equals("p")) {
			graph.setNodeCount(Integer.parseInt(parts[2]));
			graph.setEdgeCount(Integer.parseInt(parts[3]));
			createNodes();
		}
		else if(parts[0].equals("a")) {
			Node sourceNode = findNode(nodes, parts[1]);
			Node destinationNode = findNode(nodes, parts[2]);
			if(sourceNode != null && destinationNode != null) {	
				sourceNode.addAdjacent(destinationNode, Integer.parseInt(parts[3]));
			}
		}
	}
	
	private Node findNode(ArrayList<Node> nodes, String name) {

		for(Node node : nodes) {
			if(node.getName().equals(name)) {
				return node;
			}
		}
		return null;
	}
	
	private void createNodes() {
		
		for(int i = 0; i < graph.getNodeCount(); i++) {
			
			Node node  = new Node(new ArrayList<Node>(), new HashMap<Node, Integer>(), Integer.toString(i+1));
			if(i == 0) {
				node.setDistance(0);
			}
			nodes.add(node);
		}
	}
}
