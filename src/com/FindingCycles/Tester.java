package com.CycleFinder;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.addVertex("v1");
		g.addVertex("v2");
		g.addVertex("v3");
		g.addVertex("v4");
		g.addVertex("v5");
		g.addVertex("v6");
		g.addVertex("v7");
		g.addEdge("v1", "v5", 1.0);
		g.addEdge("v5", "v7", 1.0);
		g.addEdge("v7", "v4", 1.0);
		g.addEdge("v4", "v2", 1.0);
		g.addEdge("v2", "v1", 1.0);
		g.addEdge("v5", "v2", 1.0);
		g.addEdge("v5", "v3", 1.0);
		g.addEdge("v7", "v6", 1.0);
		g.addEdge("v6", "v3", 1.0);
		g.addEdge("v3", "v1", 1.0);
		for (int i = 1; i < 8; i++) {
			g.setOrigin("v" + i);
			g.printDFSCycles();
		}
	}

}
