
import java.util.Scanner;

public class Menu {

    public void menu() {
        Jumpers jumpers = new Jumpers();
        System.out.println("Kumpula ski jumping week\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        String name = "";
        Scanner reader = new Scanner(System.in);

        System.out.print("  Participant name: ");
        name = reader.nextLine();
        while (true) {
            if (name.isEmpty()) {
                break;
            }
            jumpers.add(name);
            System.out.print("  Participant name: ");
            name = reader.nextLine();

        }
        Jumps jumps = new Jumps(jumpers);
        System.out.println("\n\nThe tournament begins!\n");
        System.out.print("Write \"jump\" to jump; otherwise you quit:");
        String menu = reader.nextLine();
        int i = 0;
        while (menu.equals("jump")) {
            
            i++;
            System.out.println("Round " + i + "\n\n");
            
            jumpers.printJumpers();
            jumps.newSeriesOfJumps();
            System.out.println("\n Results of round " + i);
            jumps.printLastJumps();
            System.out.print("Write \"jump\" to jump; otherwise you quit:");
            menu = reader.nextLine();

        }
        System.out.println("Thanks!\n");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        jumps.printJumpersJumps();
    }
}
