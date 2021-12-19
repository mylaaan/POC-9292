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
    private int safeStepper = 0;
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

    public Node determineRoute(){
        HashMap<Node, ArrayList<Edge>> queue = new HashMap<>();
        queue.putAll(newQueue);
        newQueue.clear();
        for( Map.Entry<Node, ArrayList<Edge>> entry : queue.entrySet()) {
            safeStepper++;
            if(safeStepper > 27 ){ return new Node("Timboektoe"); }
            if(destinationFound){
                steps++;
                if (steps > 5 ){
                    return finalRoute;
                }
            }
            lookForTravelOptions(entry.getKey(), entry.getValue());
        }
        if( !newQueue.isEmpty() ){
            determineRoute();
        } else if (!destinationFound) {
            return new Node("Timboektoe");
        }
//        System.out.print(finalRoute.getTotalTime());
        return finalRoute;
    }

    private void lookForTravelOptions(Node lastNode, ArrayList<Edge> edges){
        for( Edge edge : edges ) {
            Node tempDestination = new Node(edge.getDestinationName());
            tempDestination.addRoutePart(lastNode, edge);
            if (tempDestination.equals(destination)) {
                if (!destinationFound || (finalRoute.getTotalTime() > tempDestination.getTotalTime())){
                    finalRoute = tempDestination;
                    destinationFound = true;
                }
            }else {
                if(!exploredNodes.contains(tempDestination)) {
                    newQueue.put(tempDestination, graph.get(new Node(tempDestination.getName())));
//                    exploredNodes.add(tempDestination);
                }
            }
        }
    }


    public void printRoute(Map<Node, Edge> printRoute) {
        System.out.println("=================================================================================================================");
        int totalTraveltime = 0;
        for( Map.Entry<Node, Edge> entry : printRoute.entrySet()) {
            System.out.println("vanaf " + entry.getKey().getName() + entry.getValue());
        }
        System.out.println("=================================================================================================================");
    }
}
