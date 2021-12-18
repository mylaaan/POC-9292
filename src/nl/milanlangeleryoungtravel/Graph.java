package nl.milanlangeleryoungtravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The class that will represent the graph itself and it structures build from Nodes and Edges.
 * This will also be cleaner than a random list floating around.
 */
public class Graph {

    private HashMap<Node, List<Edge>> graph;
    public static final String BUS = "bus";
    public static final String TREIN = "trein";

    public Graph() {
        graph = new HashMap<Node, List<Edge>>();
    }

    /**
     * Add a new node to the graph and secondly make a list of all the possible connected nodes and edges in between
     * @param node new Node to enter the graph
     */
    public void addNode(Node node){
        List<Edge> edges = new ArrayList<>();
        graph.put(node, edges);
        //System.out.print("added "+node.getName());
    }

    /**
     * Add an edge to the graph. Because an Edge must be connected to an existing source and destination
     * it is cleaner to create the edge here instead of first creating the edge and then pull all the data again.
     * This makes the edits to the graph itself cleaner
     * @param source source Node
     * @param destination destination Node
     * @param time the weight of the Edge
     * @param method type of transit;
     */
    public void addEdge(Node source, Node destination, int time, String method){
        Edge edge = new Edge(source, destination, time, method);
        if( !graph.containsKey(source)){ addNode(source); }
        if( !graph.containsKey(destination)){ addNode(destination); }
        graph.get(source).add(edge);
    }

    /**
     * getter for the Graph itself as a list
     * @return a list of Nodes and Edges.
     */
    public HashMap<Node, List<Edge>> getGraph(){
        return graph;
    }




}
