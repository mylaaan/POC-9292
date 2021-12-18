package nl.milanlangeleryoungtravel;

import java.util.*;

/**
 * Nodes will be representing the cities in the graph
 */
public class Node {

    public String name;
    private HashMap<Node, Edge> route = new HashMap<>();
    private int totalTime = 0;

    /**
     * Initialise a new Node
     * @param name Name of the City
     */
    public Node(String name){
        this.name = name;
    }

    /**
     * Override of the equals() method, The Node doesn't have to be the exact Node.
     * The route will be determined from a request with Strings. We want to be sure those Strings always match the Node.
     * @param other the object to compare to.
     * @return boolean if other node with same city as name it will match and return yes
     */
    @Override
    public boolean equals(Object other) {
        // check if same referenced object
        if (this == other) {
            return true;
        }
        // check if same type and be sure it's not null
        if (!(other instanceof Node)) {
            return false;
        }
        Node n = (Node) other;
        return ((Node) other).getName() == this.name;
    }

    /**
     * Because used in a Hashmap we also need to override the hascode so it only compares city names
     * @return hashcode of the city name
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public HashMap<Node, Edge> getRoute(){
        return route;
    }

    public int getTotalTime(){
        return totalTime;
    }

    public void setTotalTime(int time){
        totalTime = time;
    }

    public void addRoutePart(Node node, Edge edge){
        Edge edgy = new Edge(edge.getSource(), edge.getDestination(), edge.getTime(), edge.getMethod());
        route = node.getRoute();
        System.out.println(node.getName() +" <=> "+edgy.getDestinationName()+"/"+getName());
        route.put(node, edgy);
        totalTime += edgy.getTime() + node.getTotalTime();
    }

//    public void setShortRoute(HashMap<Node, Edge> route){
//        shortRoute = route;
//        for(Map.Entry<Node, Edge> currentRoute : shortRoute.entrySet() ) {
//            totalTime += currentRoute.getValue().getTime();
//        }
//    }

    public String toString() { return name; }

    public String getName() { return name; }

}
