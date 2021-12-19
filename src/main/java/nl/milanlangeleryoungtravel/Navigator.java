package nl.milanlangeleryoungtravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Navigator class will vector through the graph through all possible routes.
 * This will continue until destination found +X steps
 */
public class Navigator{

	// Source and destination and graph itself
	private Node from;
	private Node destination;
	private Graph graph;

	// Tirggers to stop looking for other travel routes
	private boolean destinationFound = false;
	private int steps = 0;
	private int safeStepper = 0;

	// A list of Nodes that are nex to explore
	private HashMap<Node, ArrayList<Edge>> newQueue = new HashMap<>();
	// The Node that will contain the complete route
	private Node finalRoute = new Node("Timboektoe");

	/**
	 * Constructor
	 *
	 * @param from        Source Node
	 * @param destination Destination Node
	 * @param graph       Graph we'll be looking through
	 */
	public Navigator(Node from, Node destination, Graph graph){
		this.from = from;
		this.destination = destination;
		this.graph = graph;

		//populate the queue
		newQueue.put(from, graph.get(from));
	}

	/**
	 * Recursive method that will keep calling itself until the destination is found and will keep looking
	 * for 3 more steps for the shortest route
	 *
	 * @return Destination Node that holds the shortest Route or "timboektoe Node" to inform that no route was found
	 */
	public Node determineRoute(){
		// Stepper that will count if the Navigator is not overshooting in a loop
		if(++ safeStepper > 25){
			return finalRoute;
		}
		if(destinationFound && ++ steps > 3){
			return finalRoute;
		}
		// Update queue
		HashMap<Node, ArrayList<Edge>> queue = new HashMap<>();
		queue.putAll(newQueue);
		newQueue.clear();
		// Loop through queue of Nodes and look for new Nodes that are connected
		for(Map.Entry<Node, ArrayList<Edge>> entry : queue.entrySet()){
			lookForTravelOptions(entry.getKey(), entry.getValue());
		}
		// if there's something in the queue repeat cycle if not
		if(! newQueue.isEmpty()){
			determineRoute();
		}
		// if queue is empty whether we found the destination, return it
		return finalRoute;
	}

	/**
	 * Loop through connected Nodes. If it doesn't find the destination it will queue the Node
	 *
	 * @param lastNode The Node where branching from
	 * @param edges    All the Edges/Nodes connected tot LastNode
	 */
	private void lookForTravelOptions(Node lastNode, ArrayList<Edge> edges){
		// Loop through all connected Nodes
		for(Edge edge : edges){
			Node tempDestination = new Node(edge.getDestinationName());
			// Add the route "until now" to the destination Node
			tempDestination.addRoutePart(lastNode, edge);
			// If it is the destination don't put it in the queue and look if it's the fastest way
			if(tempDestination.equals(destination)){
				if(! destinationFound || (finalRoute.getTotalTime() > tempDestination.getTotalTime())){
					finalRoute = tempDestination;
					destinationFound = true;
				}
			} else{
				newQueue.put(tempDestination, graph.get(new Node(tempDestination.getName())));
			}
		}
	}


	/**
	 * Print the route that was given in a readable context
	 *
	 * @param printRoute The route to print
	 */
	public void printRoute(LinkedHashMap<Node, Edge> printRoute){
		System.out.println("===================================================================================");
		for(Map.Entry<Node, Edge> entry : printRoute.entrySet()){
			System.out.println("vanaf " + entry.getKey().getName() + entry.getValue());
		}
		System.out.println("===================================================================================");
	}
}
