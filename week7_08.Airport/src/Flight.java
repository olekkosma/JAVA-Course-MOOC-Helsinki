import java.util.ArrayList;
public class Flight {
    private  Plane plane;
    private String departure;
    private String destination;

    public Flight(Plane plane, String departure, String destination) {
        this.plane = plane;
        this.departure = departure;
        this.destination = destination;
    }

   
    public String toString() {
        return plane.toString()+" ("+departure+"-"+destination+")";
    }

   
    
    
}
