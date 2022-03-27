package nl.milanlangeleryoungtravel;

/**
 * This class solely feeds data to the Graph
 * In the future this could be an instance that would call an API for data
 */
public class Feeder{


	/**
	 * This method populates the Graph
	 *
	 * @param graph
	 */
	public void populate(Graph graph){
		// The cities/Nodes for this graph
		Node groningen = new Node("Groningen");
		Node haren = new Node("Haren");
		Node leeuwarden = new Node("Leeuwarden");
		Node heerenveen = new Node("Heerenveen");
		Node assen = new Node("Assen");
		Node emmen = new Node("Emmen");
		Node zwolle = new Node("Zwolle");
		Node enschede = new Node("Enschede");
		Node lelystad = new Node("Lelystad");
		Node walibi = new Node("Walibi");
		Node utrecht = new Node("Utrecht");
		Node hilversum = new Node("Hilversum");
		Node arnhem = new Node("Arnhem");
		Node doetinchem = new Node("Doetinchem");
		Node amsterdam = new Node("Amsterdam");
		Node haarlem = new Node("Haarlem");
		Node rotterdam = new Node("Rotterdam");
		Node denhaag = new Node("Den Haag");
		Node middelburg = new Node("Middelburg");
		Node vlissingen = new Node("Vlissingen");
		Node denbosch = new Node("Den Bosch");
		Node tilburg = new Node("Tilburg");
		Node roermond = new Node("Roermond");
		Node venlo = new Node("Venlo");

		// All connected Nodes by train
		graph.addEdge(groningen, leeuwarden, 34, graph.TREIN);
		graph.addEdge(leeuwarden, groningen, 34, graph.TREIN);
		graph.addEdge(leeuwarden, heerenveen, 20, graph.TREIN);
		graph.addEdge(heerenveen, leeuwarden, 20, graph.TREIN);
		graph.addEdge(groningen, assen, 17, graph.TREIN);
		graph.addEdge(assen, groningen, 20, graph.TREIN);
		graph.addEdge(emmen, assen, 48, graph.TREIN);
		graph.addEdge(assen, emmen, 64, graph.TREIN);
		graph.addEdge(emmen, zwolle, 52, graph.TREIN);
		graph.addEdge(zwolle, emmen, 60, graph.TREIN);
		graph.addEdge(assen, zwolle, 40, graph.TREIN);
		graph.addEdge(zwolle, assen, 45, graph.TREIN);
		graph.addEdge(enschede, zwolle, 65, graph.TREIN);
		graph.addEdge(zwolle, enschede, 65, graph.TREIN);
		graph.addEdge(enschede, denhaag, 149, graph.TREIN);
		graph.addEdge(denhaag, enschede, 149, graph.TREIN);
		graph.addEdge(denhaag, enschede, 149, graph.TREIN);
		graph.addEdge(arnhem, doetinchem, 30, graph.TREIN);
		graph.addEdge(doetinchem, arnhem, 34, graph.TREIN);
		graph.addEdge(hilversum, utrecht, 18, graph.TREIN);
		graph.addEdge(utrecht, hilversum, 19, graph.TREIN);
		graph.addEdge(rotterdam, utrecht, 37, graph.TREIN);
		graph.addEdge(utrecht, rotterdam, 38, graph.TREIN);
		graph.addEdge(amsterdam, utrecht, 24, graph.TREIN);
		graph.addEdge(utrecht, amsterdam, 24, graph.TREIN);
		graph.addEdge(enschede, utrecht, 97, graph.TREIN);
		graph.addEdge(utrecht, enschede, 97, graph.TREIN);
		graph.addEdge(rotterdam, denhaag, 46, graph.TREIN);
		graph.addEdge(denhaag, rotterdam, 46, graph.TREIN);
		graph.addEdge(rotterdam, middelburg, 100, graph.TREIN);
		graph.addEdge(middelburg, rotterdam, 100, graph.TREIN);
		graph.addEdge(vlissingen, middelburg, 8, graph.TREIN);
		graph.addEdge(middelburg, vlissingen, 8, graph.TREIN);
		graph.addEdge(vlissingen, rotterdam, 108, graph.BUS);
		graph.addEdge(rotterdam, vlissingen, 101, graph.BUS);
		graph.addEdge(amsterdam, rotterdam, 41, graph.TREIN);
		graph.addEdge(rotterdam, amsterdam, 41, graph.TREIN);
		graph.addEdge(amsterdam, denhaag, 51, graph.TREIN);
		graph.addEdge(denhaag, amsterdam, 48, graph.TREIN);
		graph.addEdge(amsterdam, haarlem, 62, graph.TREIN);
		graph.addEdge(haarlem, amsterdam, 62, graph.TREIN);
		graph.addEdge(rotterdam, denbosch, 77, graph.TREIN);
		graph.addEdge(denbosch, amsterdam, 77, graph.TREIN);
		graph.addEdge(utrecht, denbosch, 26, graph.TREIN);
		graph.addEdge(denbosch, utrecht, 28, graph.TREIN);
		graph.addEdge(tilburg, denbosch, 16, graph.TREIN);
		graph.addEdge(denbosch, tilburg, 16, graph.TREIN);
		graph.addEdge(tilburg, arnhem, 73, graph.TREIN);
		graph.addEdge(arnhem, tilburg, 64, graph.TREIN);
		graph.addEdge(venlo, roermond, 24, graph.TREIN);
		graph.addEdge(roermond, venlo, 24, graph.TREIN);

		// All connected Nodes by bus
		graph.addEdge(denhaag, haarlem, 53, graph.BUS);
		graph.addEdge(haarlem, denhaag, 51, graph.BUS);
		graph.addEdge(lelystad, walibi, 140, graph.BUS);
		graph.addEdge(walibi, lelystad, 149, graph.BUS);
		graph.addEdge(lelystad, hilversum, 198, graph.BUS);
		graph.addEdge(hilversum, lelystad, 198, graph.BUS);
		graph.addEdge(lelystad, utrecht, 244, graph.BUS);
		graph.addEdge(utrecht, lelystad, 244, graph.BUS);
		graph.addEdge(assen, emmen, 55, graph.BUS);
		graph.addEdge(enschede, zwolle, 82, graph.BUS);
		graph.addEdge(groningen, haren, 29, graph.BUS);
		graph.addEdge(haren, groningen, 31, graph.BUS);
		graph.addEdge(enschede, doetinchem, 90, graph.BUS);
		graph.addEdge(doetinchem, enschede, 90, graph.BUS);

		// All connected Nodes by subway
		graph.addEdge(rotterdam, denhaag, 36, graph.METRO);
		graph.addEdge(denhaag, rotterdam, 36, graph.METRO);
	}


}
