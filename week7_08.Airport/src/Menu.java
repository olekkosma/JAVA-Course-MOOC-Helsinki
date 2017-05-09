
import java.util.Scanner;

public class Menu {

    private Scanner reader = new Scanner(System.in);

    public void Menu(Planes planes, Flights flights) {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        while (true) {
            System.out.println("Choose operation: ");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            String menu = reader.nextLine();
            if (menu.equals("x")) {
                break;
            }

            if (menu.equals("1")) {
                planes.add(reader);

            }

            if (menu.equals("2")) {
                flights.add(planes,reader);

            }

        }
        System.out.println("Flight service");
        System.out.println("--------------------");
        System.out.println("");
        while (true) {
            System.out.println("Choose operation: ");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            String menu = reader.nextLine();
            if (menu.equals("x")) {
                break;
            }

            if (menu.equals("1")) {
                planes.printPlanes();

            }

            if (menu.equals("2")) {
                flights.printsFlights();

            }
            if (menu.equals("3")) {

                Plane plane = planes.searchPlane(reader);
                System.out.println(plane);
            }

        }

    }
}
