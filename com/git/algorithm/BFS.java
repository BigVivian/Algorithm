package com.git.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Breadth First Search<br>
 * 
 * 1.Color: tag the vertex is added into the queue or not.<br>
 * (White -> Gray -> Black) <br>
 * 2.Distance: record the distance from root. <br>
 * 3.Parent: the parent node of this node. <br>
 * 
 * @author Vivian
 * 
 */
public class BFS {
	public void dfsVisit(Graph graph, Vertex root) {
		Queue<Vertex> queue = new LinkedList<Vertex>();

		root.setColor(Color.GRAY);
		root.setDistance(0);
		queue.offer(root);

		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			// print the poll
			System.out.print(current.getName() + "(" + current.getDistance()
					+ ") ");
			Vertex[] adjVertex = graph.getAdjacency().get(current);
			if (adjVertex == null || adjVertex.length == 0) {
				continue;
			}
			for (Vertex tmp : adjVertex) {
				if (tmp.getColor().equals(Color.WHITE)) {
					tmp.setDistance(current.getDistance() + 1);
					tmp.setParent(current);
					tmp.setColor(Color.GRAY);
					queue.add(tmp);
				}
			}
			current.setColor(Color.BLACK);
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		Set<Vertex> vertexSet = graph.getVertexSet();
		Map<Vertex, Vertex[]> edgeMap = graph.getAdjacency();

		Vertex s = new Vertex("s");
		Vertex w = new Vertex("w");
		Vertex r = new Vertex("r");
		Vertex v = new Vertex("v");
		Vertex t = new Vertex("t");
		Vertex u = new Vertex("u");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");

		vertexSet.add(s);
		vertexSet.add(w);
		vertexSet.add(r);
		vertexSet.add(v);
		vertexSet.add(t);
		vertexSet.add(u);
		vertexSet.add(x);
		vertexSet.add(y);

		edgeMap.put(s, new Vertex[] { r, w });
		edgeMap.put(r, new Vertex[] { v });
		edgeMap.put(w, new Vertex[] { s, t, x });
		edgeMap.put(t, new Vertex[] { w, x, u });
		edgeMap.put(x, new Vertex[] { w, t, u, y });
		edgeMap.put(u, new Vertex[] { t, x, y });
		edgeMap.put(y, new Vertex[] { x, u });

		BFS test = new BFS();
		test.dfsVisit(graph, s);
	}

}

enum Color {
	WHITE, GRAY, BLACK
}

/**
 * define the graph, includes the vertex set and the adjacency list.
 */
class Graph {
	// vertex set
	private Set<Vertex> vertexSet = new HashSet<Vertex>();
	// adjacency list
	private Map<Vertex, Vertex[]> adjacency = new HashMap<Vertex, Vertex[]>();

	public Set<Vertex> getVertexSet() {
		return vertexSet;
	}

	public void setVertexSet(Set<Vertex> vertexSet) {
		this.vertexSet = vertexSet;
	}

	public Map<Vertex, Vertex[]> getAdjacency() {
		return adjacency;
	}

	public void setAdjacency(Map<Vertex, Vertex[]> adjacency) {
		this.adjacency = adjacency;
	}

}

/**
 * define the Vertex <br>
 */
class Vertex {
	private String name;
	private Color color;
	private Vertex parent;
	private int distance;

	public Vertex(String name) {
		this.name = name;
		this.color = Color.WHITE;
		this.distance = Integer.MAX_VALUE;
		this.parent = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Vertex getParent() {
		return parent;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}