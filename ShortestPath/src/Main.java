import java.util.concurrent.TimeUnit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {

		GraphGenerator generator = new GraphGenerator();
		GraphGenerator generator1 = new GraphGenerator();
		GraphGenerator generator2 = new GraphGenerator();
		
		Dijkstra dijkstra = new Dijkstra();
		BellmanFord bellmanFord = new BellmanFord();
		FloydWarshall floydWarshall = new FloydWarshall();
		
		Graph constantGraph = generator.generateGraph("dense_graphs/output_1000_1000000.gr");
		
		double startTime = System.nanoTime();
		//long startTime = System.currentTimeMillis();
		Graph dijkstraGraph = dijkstra.runDijkstra(constantGraph);
		//long endTime = System.currentTimeMillis();
		double endTime = System.nanoTime();
		double duration = endTime - startTime;
		duration = duration / 1000000;
		
		System.out.println("Runtime of Dijkstra = " + duration + " miliseconds.");
		
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		constantGraph = generator1.generateGraph("dense_graphs/output_1000_1000000.gr");
		
		startTime = System.nanoTime();
		//startTime = System.currentTimeMillis();
		Graph bellmanFordGraph = bellmanFord.runBellmanFord(constantGraph);
		//endTime = System.currentTimeMillis();
		endTime = System.nanoTime();
		duration = endTime - startTime;
		duration = duration/1000000;
		
		System.out.println("Runtime of Bellman-Ford = " + duration + " miliseconds.");
		

		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println();

		constantGraph = generator2.generateGraph("dense_graphs/output_1000_1000000.gr");
		
		startTime = System.nanoTime();
		//startTime = System.currentTimeMillis();
		int[][] floydWarshallMatrix = floydWarshall.runFloydWarshall(constantGraph);
		//endTime = System.currentTimeMillis();
		endTime = System.nanoTime();
		duration = endTime - startTime;
		duration = duration/1000000;
		
		System.out.println("Runtime of Floyd-Warshall = " + duration + " miliseconds.");
		
		
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println();
		
	}

	
}
