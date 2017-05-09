

public class Main {
    public static void main(String[] args) {
       Planes planes = new Planes();
       Flights flights = new Flights();
       Flight flight = new Flight(new Plane("Bd", 22),"ff","ds");
       Menu menu = new Menu();
       menu.Menu(planes,flights);
       
    }
}
