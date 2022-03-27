package nl.milanlangeleryoungtravel;

/**
 * Edges will represent the forms of transportation between cities(Nodes) in the graph
 */
public class Edge{

	// Travel time
	private int time;
	// Destination this trip ends
	private Node destination;
	// Travel method as defined in Graph
	private String method;

	/**
	 * Initialise a new Edge
	 *
	 * @param destination destination Node
	 * @param time        the weight of the Edge
	 * @param method      type of transit;
	 */
	public Edge(Node destination, int time, String method){
		this.destination = destination;
		this.time = time;
		this.method = method;
	}

	/**
	 * destination getter
	 *
	 * @return destination as a String
	 */
	public String getDestinationName(){
		return destination.getName();
	}

	/**
	 * Time getter
	 *
	 * @return time
	 */
	public int getTime(){
		return time;
	}

	/**
	 * Make a readable scentence of how this part of the trip will go and end
	 *
	 * @return tripadvice as String
	 */
	public String toString(){
		return " in de " + method + " voor " + Main.printTime(time) + "naar " + destination.getName();
	}


}
