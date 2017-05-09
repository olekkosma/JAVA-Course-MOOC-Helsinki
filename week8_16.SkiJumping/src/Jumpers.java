
import java.util.ArrayList;

public class Jumpers {

    ArrayList<Jumper> jumpers;

    public Jumpers() {
        this.jumpers = new ArrayList<Jumper>();
    }

    public void add(String name) {
        Jumper newOne = new Jumper(name);

        jumpers.add(newOne);

    }

    public void printJumpers() {
        System.out.println("Jumping order:");
        int i = 0;
        for (i = 0; i < jumpers.size(); i++) {

            System.out.println("  " + (i + 1) + ". " + jumpers.get(i));
        }
    }

}
