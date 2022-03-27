package nl.milanlangeleryoungtravel;

import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * Nodes will be representing the cities in the graph
 * Nodes will also be the vectors for the navigator to determine a rout through the graph
 */
public class Node{

	// name of the city
	public String name;
	// To keep track and easily compare travel times to another route the Navigator might have taken
	private int totalTime = 0;
	// Map of Nodes and Edges, This needs to be a LinkedHashmap as we need to keep the sequence intact
	private LinkedHashMap<Node, Edge> route = new LinkedHashMap<>();

	/**
	 * Constructor
	 *
	 * @param name Name of the City
	 */
	public Node(String name){
		this.name = name;
	}

	/**
	 * Override of the equals() method, The Node doesn't have to be the exact Node.
	 * The route will be determined from a request with Strings. We want to be sure those Strings always match the Node.
	 *
	 * @param other the object to compare to.
	 * @return boolean if other node with same city as name it will match and return yes
	 */
	@Override
	public boolean equals(Object other){
		// check if same referenced object
		if(this == other){
			return true;
		}
		// check if same type and be sure it's not null
		if(! (other instanceof Node)){
			return false;
		}
		Node n = (Node) other;
		return ((Node) other).getName().equals(this.name);
	}

	/**
	 * Override of hashcode method as we use a hashmap we need this for comparing Nodes.
	 * It does this by only comparing city names instead of the whole object.
	 *
	 * @return hashcode of the city name
	 */
	@Override
	public int hashCode(){
		return Objects.hash(name);
	}

	/**
	 * Route getter
	 *
	 * @return route
	 */
	public LinkedHashMap<Node, Edge> getRoute(){
		return route;
	}

	/**
	 * TotalTime getter
	 *
	 * @return totalTime
	 */
	public int getTotalTime(){
		return totalTime;
	}

	/**
	 * Name getter
	 *
	 * @return name
	 */
	public String getName(){
		return name;
	}


	/**
	 * For this method the Node will represent the destination Node.
	 * First the route of the connected Node we came from will be inserted
	 * Then it will put in the last Node and the Edge to this Node in.
	 *
	 * @param node
	 * @param edge
	 */
	public void addRoutePart(Node node, Edge edge){
		route.clear();
		route.putAll(node.getRoute());
		route.put(node, edge);
		// update time to come here
		totalTime += edge.getTime() + node.getTotalTime();
	}

}
