package nl.milanlangeleryoungtravel;

/**
 * Nodes will be representing the cities in the graph
 */
public class Node {

    private String name;

    /**
     * Initialise a new Node
     * @param name Name of the City
     */
    public Node(String name){
        this.name = name;
    }

    /**
     * Getter of the city name
     * @return city name as String
     */
    public String getName(){
        return name;
    }

    /**
     * Override of the equals() method, The Node doesn't have to be the exact Node.
     * The route will be determined from a request with Strings. We want to be sure those Strings always match the Node.
     * @param other the object to compare to.
     * @return boolean if other node with same city as name it will match and return yes
     */
    @Override
    public boolean equals(Object other) {
        // check for reference equality.
        if (this == other) {
            return true;
        }
        if (other instanceof Node that) {
            // Check for name equality.
            return (name == null && that.name == null)
                    || name.equals(that.name);
        }
        return false;
    }
}
