package nl.milanlangeleryoungtravel;

import java.util.*;

/**
 * Nodes will be representing the cities in the graph
 */
public class Node {

    public String name;
    private LinkedHashMap<Node, Edge> route = new LinkedHashMap<>();
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
        return ((Node) other).getName().equals(this.name);
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


    public void addRoutePart(Node node, Edge edge){
        route.clear();
        route.putAll(node.getRoute());
        route.put(node, edge);
        totalTime += edge.getTime() + node.getTotalTime();
    }

    public String toString() { return name; }

    public String getName() { return name; }

}
