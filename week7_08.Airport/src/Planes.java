import java.util.Scanner;
import java.util.ArrayList;


public class Planes {

    private ArrayList<Plane> planes = new ArrayList<Plane>();
    

    public Planes() {

    }

    public void add(Scanner reader) {

        System.out.println("Give plane ID: ");
        String id = reader.nextLine();
        System.out.println("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        Plane plane = new Plane(id, capacity);

        planes.add(plane);
    }
    public void printPlanes(){
        
        for(Plane plane : planes){
            System.out.println(plane);
        }
    }
    
    public Plane searchPlane(Scanner reader){
        System.out.println("Give plane ID: ");
        String id = reader.nextLine();
        for(Plane plane : planes){
            if(id.equals(plane.getId())){
                return plane;
            }
        }
        
        return null;
    }

}
