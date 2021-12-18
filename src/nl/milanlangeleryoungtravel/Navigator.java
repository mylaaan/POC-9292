package nl.milanlangeleryoungtravel;

import java.util.HashMap;
import java.util.Map;

public class Navigator {

    private Node from;
    private Node to;
    private Graph graph;

    private int currentMin = 0;
    private HashMap<Node, Edge> currentShort;


    public Navigator(Node from, Node to, Graph  graph){
        this.from = from;
        this.to = to;
        this.graph = graph;
    }

    public Map<Node, Edge> determineRoute(HashMap<Node, Edge> shortList){




        HashMap<Node, Edge> map = new HashMap<Node, Edge>();
        return map;
    }


    public void printRoute(Map<Node, Edge> route) {
       route.forEach( (n, e) -> System.out.println(n + " : " + e ) );
    }
}
