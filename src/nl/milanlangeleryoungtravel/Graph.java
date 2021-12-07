package nl.milanlangeleryoungtravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private HashMap<Node, List<Edge>> graph;
    public static final String BUS = "bus";
    public static final String TREIN = "trein";

    public Graph() {
        graph = new HashMap<Node, List<Edge>>();
    }

    public void addNode(Node node){
        List<Edge> edges = new ArrayList<>();
        graph.put(node, edges);
        //System.out.print("added "+node.getName());
    }

    public void addEdge(Node source, Node destination, int time, String method){
        Edge edge = new Edge(source, destination, time, method);
        if( !graph.containsKey(source)){ addNode(source); }
        if( !graph.containsKey(destination)){ addNode(destination); }
        graph.get(source).add(edge);
    }

    public HashMap<Node, List<Edge>> getGraph(){
        return graph;
    }




}
