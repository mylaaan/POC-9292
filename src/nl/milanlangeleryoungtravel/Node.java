package nl.milanlangeleryoungtravel;

public class Node {

    private String name;

    public Node(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


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
