package nl.milanlangeleryoungtravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Navigator {

    private Node from;
    private Node destination;
    private Graph graph;

    private boolean destinationFound = false;
    private int steps = 0;
    private ArrayList<Node> exploredNodes = new ArrayList<>();
    private HashMap<Node, ArrayList<Edge>> newQueue = new HashMap<>();
    private Node finalRoute = new Node("Timboektoe");


    public Navigator(Node from, Node destination, Graph  graph){
        this.from = from;
        this.destination = destination;
        this.graph = graph;

        //populate the queue
        newQueue.put(from ,graph.get(from));
//        exploredNodes.add(from);
    }

    public Map<Node, Edge> determineRoute(){
        HashMap<Node, ArrayList<Edge>> queue = new HashMap<>();
        queue.putAll(newQueue);
        newQueue.clear();
        System.out.print("\n"+"==============new queue==================");  //==============================
        for( Map.Entry<Node, ArrayList<Edge>> entry : queue.entrySet()) {
//            if(destinationFound){
//                steps++;
//                if( steps > 5 ){
//                    return finalRoute.getRoute();
//                }
//            }
            System.out.print("\n ----routes vanaf "+entry.getKey().getName()); //==============================

            lookForTravelOptions(entry.getKey(), entry.getValue());
        }
        if( !newQueue.isEmpty() ){
//            printRoute(finalRoute.getRoute());
            determineRoute();
        } else if (!destinationFound) {
            return new HashMap<Node, Edge>();
        }
        System.out.print(finalRoute.getTotalTime());
        return finalRoute.getRoute();
    }

    private void lookForTravelOptions(Node lastNode, ArrayList<Edge> edges){
        for( Edge edge : edges ) {
            System.out.println("==== next edge");
            Node tempDestination = new Node(edge.getDestinationName());
            System.out.println("\n totale huidige reistijd naar " + tempDestination.getName() + " is: " + (tempDestination.getTotalTime() + edge.getTime() + lastNode.getTotalTime()) + " minuten");
            tempDestination.addRoutePart(lastNode, edge);
            System.out.print("\n leid naar " + tempDestination.getName() + ". Je bent er dan na " + tempDestination.getTotalTime() + " minuten."); //==============================
            printRoute(tempDestination.getRoute());

            if (tempDestination.equals(destination)) {
                if (!destinationFound || (finalRoute.getTotalTime() > tempDestination.getTotalTime())){
                    System.out.print("\n eindpunt " + destination.getName() +" gevonden vanaf station:" + lastNode.getName()); //==============================
                    System.out.print("\n je doet er " + tempDestination.getTotalTime() + " over ipv " + finalRoute.getTotalTime() + " (0 is oneindig)"); //==============================
                    finalRoute = tempDestination;
                    destinationFound = true;
                } else {
                    System.out.print("\n deze route vanaf " + lastNode.getName() + " is niet goed want je doet er anders " + tempDestination.getTotalTime() + " over ipv " + finalRoute.getTotalTime() );
                }
            }else {
                if(!exploredNodes.contains(tempDestination)) {
                    System.out.print(tempDestination.getName() +" added to queue");
                    newQueue.put(tempDestination, graph.get(tempDestination));
//                    exploredNodes.add(tempDestination);
                }
            }
        }
    }


    public void printRoute(Map<Node, Edge> printRoute) {
        System.out.println("\n=================================================================================================================");
        int totalTraveltime = 0;
        for( Map.Entry<Node, Edge> entry : printRoute.entrySet()) {
            System.out.println(entry.getKey().getName() + " => " + entry.getValue());
        }
        System.out.println("=================================================================================================================");
    }
}
