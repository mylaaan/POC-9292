package nl.milanlangeleryoungtravel;

public class Edge {

    private Node source;
    private Node destination;
    private int time;
    private String method;

    public Edge(Node source, Node destination, int time, String method){
        this.source = source;
        this.destination = destination;
        this.time = time;
        this.method = method;
    }

    public String getDestination(){
        return destination.getName();
    }


}
