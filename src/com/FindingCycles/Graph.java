package com.CycleFinder;

import java.util.ArrayList;
/**
 * @author mrc
 *	Lab 10 Finding Cycles
 *	With the given graph use Depth for Search
 *	to detect all possible cycles..
 *	-Linked Form of Graph to achieve this
 */
public class Graph {
	//A graph is a set of vertices + edges 'G = (V,E)'
	private class Vertex 
	{
		//Attributes of Vertex
		private String name;  
		private ArrayList <Edge> neighbors; 
		//Construct Vertex object
		public Vertex (String aName) 
		{
			this.name = aName;
			this.neighbors = new ArrayList<Edge>();
		}
	}
	
	private class Edge 
	{
		//Attributes of Edge 
		private Vertex toVertex;
		private double weight; //Distance between each Vertex
		//Construct Edge object
		public Edge (Vertex aVert, double aWeight) 
		{
			this.toVertex = aVert;
			this.weight = aWeight;
		}
	}
	//Create a starting place 
	private Vertex origin;
	private ArrayList <Vertex> verts;
	public Graph ()
	{
		origin = null;
		verts = new ArrayList <Vertex>();
	}
	
	//Add vertex method
	public void addVertex (String aName)
	{
		if (vertexContained(aName))
			return; //We found it
		Vertex v = new Vertex (aName); //Make a new vert
		verts.add(v); //Add it or assign it to origin 
		if (origin == null)
			origin = v;
	}

	//Helper for addvert 
	private boolean vertexContained(String aName) {
		// TODO Auto-generated method stub
		for (Vertex vert: verts)
			if (vert.name.equals(aName))
				return true;
		return false;
	}
	
	public Vertex getVert (Vertex aVert) {
		for (Vertex vert: verts) {
			if (vert.name.equals(aVert)) 
			{
				return vert;	
			} 
		}
		return null;
	}
		
	//Add edge method 
	public void addEdge (String fromVert, String toVert, double weight)
	{
		Vertex v1 = getVert(fromVert);
		Vertex v2 = getVert(toVert);
		if (v1 == null || v2 == null)
			return;
		v1.neighbors.add(new Edge(v2,weight));
	}
	
	//Helper for addEdge
	private Vertex getVert(String aName) {
		// TODO Auto-generated method stub
		for (Vertex vert:verts)
			if(vert.name.equals(aName))
				return vert;
		return null;
	}
	
	//Method to detect all possible cycles (paths) throughout the graph 
	ArrayList<Vertex> markedList = new ArrayList<Vertex>();
	public void printDFS ()
	{
		markedList.clear();
		printDFS(origin); // 1. Start from an origin 
		
	}
	private void printDFS(Vertex vert)
	{
		if (markedList.contains(vert)) //4. If the vertex is in marked list return to prev 
			return;
		System.out.println(vert.name);
		markedList.add(vert); // 2. Add it to the marked list
		for (Edge edge : vert.neighbors) //3. Traverse an edge to next neighbor
			printDFS(edge.toVertex); // recursively go through steps until there are unvisited vertices
	}
	
	public void printDFSCycles() { //Recursive helper method
		printDFSCycles(origin, "");
	}
	
	public void printDFSCycles(Vertex aVert, String aPath) {
		if (aPath.length() > 3 && aVert == origin) //Path check to see if path is larger than starting point 
		{
			System.out.println(aPath+aVert.name); //Print the path from origin back to origin (a cycle)
			return;
		}
		else if (aPath.contains(aVert.name)) //Another check to see if we already passed through another vertex or else infinite loop
			return;
		aPath+=aVert.name+" "; //Adding the vertex we just explored 
		for (int i=0; i<aVert.neighbors.size(); i++) 
		{
			printDFSCycles(aVert.neighbors.get(i).toVertex, new String (aPath)); //Check all neighbor indices while calling printDFSCycles 
														// to check all available paths and constructing a new string to not pass prev path
		}
	}
	
	public void setOrigin (String aVert) 
	{
		if (getVert(aVert) != null) {
			origin = getVert(aVert);
		}
	}
	

	
	
}
