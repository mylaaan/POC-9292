package nl.milanlangeleryoungtravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.print("Let's do this thing!\n");
        Graph graph = new Graph();
        Node ams = new Node("Amsterdam");
        Node rot = new Node("Rotterdam");
        Node utr = new Node("Utrecht");
        Node bos = new Node("Den Bosch");
        Node ens = new Node("Enschede");

        graph.addEdge(ams, rot, 10, graph.TREIN);
        graph.addEdge(ams, utr, 15, graph.TREIN);
        graph.addEdge(rot, utr, 20, graph.TREIN);
        graph.addEdge(rot, bos, 2, graph.TREIN);
        graph.addEdge(bos, utr, 2, graph.TREIN);

        graph.forEach((k, v) -> {
            if(v.size() > 0 ) {
                System.out.print("\n" + k.getName() + " is de start van een reis naar: ");
                for (Edge edge : v) {
                    System.out.print(edge.getDestination() + ", ");
                }
            }
        });

        HashMap<Integer, String> routes = new HashMap<Integer, String>();
        Node from = new Node("Amsterdam");
        Node to = new Node("Utrecht");
        Navigator navigator = new Navigator(from, to, graph);
        Map<Node, Edge> route = navigator.determineRoute(new HashMap<Node, Edge>());
        navigator.printRoute(route);
    }


}
