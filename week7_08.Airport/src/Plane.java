
public class Plane {
    
    private String id;
    private int capacity;

    public Plane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    
    public String toString() {
        return id + " ("+capacity+" ppl)";
    }
    
    
}
