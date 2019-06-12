
public class FloydWarshall {

	public FloydWarshall() {
		// TODO Auto-generated constructor stub
	}
	
	public int[][] runFloydWarshall(Graph graph){
		
		int[][] resultMatrix = new int[graph.getNodeCount()][graph.getNodeCount()];
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < graph.getNodeCount(); i++) {
			for(int j = 0; j < graph.getNodeCount(); j++) {
				Node sourceNode = graph.getNode(graph, (i+1));
				Node destNode = graph.getNode(graph, (j+1));
				
				if(i==j)
					resultMatrix[i][j] = 0;
				else if(graph.isAdjacent(sourceNode, destNode)) 
					resultMatrix[i][j] = sourceNode.getAdjacentNodes().get(destNode);
				else
					resultMatrix[i][j] = 9999;
			}
		}
		
		for(int k = 0; k < graph.getNodeCount(); k++) {
			for(int i = 0; i < graph.getNodeCount(); i++) {
				for(int j = 0; j < graph.getNodeCount(); j++) {
					
					if (resultMatrix[i][k] + resultMatrix[k][j] < resultMatrix[i][j]) 
						resultMatrix[i][j] = resultMatrix[i][k] + resultMatrix[k][j]; 
					
				}
			}
		}
		
		return resultMatrix;
	}

}
