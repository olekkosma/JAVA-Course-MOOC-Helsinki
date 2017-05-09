
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Jumps {

    ArrayList<Jump> jumps = new ArrayList<Jump>();
    Jumpers jumpers;

    public Jumps(Jumpers jumpers) {
        this.jumpers = jumpers;
    }

    public void newSeriesOfJumps() {
        
        for (Jumper jumper : jumpers.jumpers) {
            Jump newJump = new Jump(jumper);
            jumps.add(newJump);
        }

    }

    public void printLastJumps() {
        int i;

        for (i = jumps.size() - jumpers.jumpers.size(); i < jumps.size(); i++) {
            System.out.println(jumps.get(i));

        }

        SortAgaintsPoints againtsPoints = new SortAgaintsPoints();
        Collections.sort(jumpers.jumpers, againtsPoints);
    }

    public void printAllJumps() {
        int i;
        for (i = jumps.size() - 1; i >= 0; i--) {
            System.out.println(jumps.get(i));

        }
    }

    public void printJumpersJumps() {
        SortAgaintsPoints againtsPoints = new SortAgaintsPoints();
        Collections.sort(jumpers.jumpers, againtsPoints);
        Collections.reverse(jumpers.jumpers);
        int i = 0;
        for (Jumper jumper : jumpers.jumpers) {
            i++;
            System.out.println(i + "           " + jumpers.jumpers.get(i - 1).printResults());
            System.out.print("            jump lengths: ");
            for (Jump jump : jumps) {

                if (jumper.getName().equals(jump.jumper.getName())) {
                    System.out.print(jump.jumpLength + "m, ");

                }

            }
            System.out.println("");
        }
    }

}
