package nl.milanlangeleryoungtravel;

/**
 * Edges will represent the forms of transportation between cities(Nodes) in the graph
 */
public class Edge {

    private Node source;
    private Node destination;
    private int time;
    private String method;

    /**
     * Initialise a new Edge
     * @param source source Node
     * @param destination destination Node
     * @param time the weight of the Edge
     * @param method type of transit;
     */
    public Edge(Node source, Node destination, int time, String method){
        this.source = source;
        this.destination = destination;
        this.time = time;
        this.method = method;
    }

    /**
     * destination getter
     * @return destination as a String
     */
    public String getDestinationName(){
        return destination.getName();
    }

    public Node getDestination() { return destination; }

    public Node getSource(){ return source; }

    public int getTime(){ return time; }

    public String getMethod(){ return method; }

    public String toString(){ return " in de " + method + " voor " + Main.printTime(time ) + "naar " + destination.getName();}


}
