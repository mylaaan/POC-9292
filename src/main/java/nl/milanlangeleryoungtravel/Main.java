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

        graph.addEdge(ams, rot, 9, graph.TREIN);
//        graph.addEdge(ams, ens, 18, graph.TREIN);
        graph.addEdge(ams, utr, 15, graph.TREIN);
        graph.addEdge(rot, bos, 1, graph.TREIN);
        graph.addEdge(rot, utr, 26, graph.TREIN);
        graph.addEdge(bos, utr, 2, graph.TREIN);
        graph.addEdge(utr, ens, 47, graph.TREIN);


        graph.forEach((k, v) -> {
            if(v.size() > 0 ) {
                System.out.print("\n" + k.toString() + " is de start van een reis naar: ");
                for (Edge edge : v) {
                    System.out.print(edge.getDestination() + ", ");
                }
            }
        });
        System.out.println("\n\n");

        Node from = new Node("Amsterdam");
        Node to = new Node("Enschede");
        Navigator navigator = new Navigator(from, to, graph);
        Map<Node, Edge> route = navigator.determineRoute();
        System.out.println("\n\n");
//        navigator.printRoute(route);

//        HashMap<Integer, String> blabla = new HashMap<Integer, String>();
//        blabla.put(1, "hoi");
//        blabla.put(2, "hoii");
//        blabla.put(3, "hoiii");
//        blabla.put(4, "hoiiii");
//        for( Map.Entry<Integer, String> entry : blabla.entrySet()){
//            System.out.println(entry.getKey() + " betekend: " + entry.getValue());
//            if(entry.getKey() == 3){
//                blabla.put(5, "hoiiiii");
//            }
//        }
    }


}
