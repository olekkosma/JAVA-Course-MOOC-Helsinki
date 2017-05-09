
import java.util.ArrayList;
import java.util.Scanner;

public class Flights {

    private ArrayList<Flight> flights = new ArrayList<Flight>();
    

    public Flights() {
    }

    public void add(Planes planes,Scanner reader) {
        Plane plane2;
       
        plane2 = planes.searchPlane(reader);
        if(plane2==null){
            System.out.println("There is no given ID");
        }
        
        System.out.println("Give departure airport code: ");
        String departure = reader.nextLine();
        System.out.println("Give destination airport code: ");
        String destination = reader.nextLine();
        
        Flight flight = new Flight(plane2,departure,destination);
        
        flights.add(flight);

    }
    
    public void printsFlights(){
        
        for(Flight flight : flights){
            System.out.println(flight);
        }
    }

}
