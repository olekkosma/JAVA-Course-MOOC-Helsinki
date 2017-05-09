/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ukleja
 */
public class Dungeon {

    int length;
    int height;
    int vampires;
    int moves;
    boolean vampiraesMove;
    List<Vampire> vampiresList = new ArrayList<Vampire>();
    Hero stefan = new Hero();

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiraesMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiraesMove = vampiraesMove;
        this.stefan = stefan;
    }

    public void generateVampires() {
        int i;
        int flag = 1;
        Random random = new Random();
        for (i = 0; i < vampires; i++) {
            flag = 1;
            while (flag == 1) {
                flag = 0;
                Vampire newOne = new Vampire(random.nextInt(length), random.nextInt(height));

                if (vampiresList.contains(newOne)) {
                    flag = 1;
                }
                if (flag == 0) {
                    vampiresList.add(newOne);
                }
            }

        }

    }

    public void run() {
        generateVampires();
        while (true) {
            if (moves == 0) {
                System.out.println("YOU LOSE");
                return;
            }
            if (vampiresList.size() == 0) {
                System.out.println("YOU WIN ");
                return;
            }
            System.out.println(moves + "\n");
            System.out.println("@ " + stefan.getWidth() + " " + stefan.getHeight());
            for (Vampire other : vampiresList) {

                System.out.println("v " + other.getWidth() + " " + other.getHeight());
            }
            System.out.println("");
            printDungeon();
            System.out.println("");
            blingCycle();

            moves--;
        }
    }

    public void printDungeon() {
        int i, j;
        for (i = 0; i < this.height; i++) {
            for (j = 0; j < this.length; j++) {

                if (vampiresList.contains(new Vampire(j, i))) {
                    System.out.print("V");
                } else if (stefan.getWidth() == j && stefan.getHeight() == i) {
                    System.out.print("@");
                } else {
                    System.out.print(".");
                }

            }
            System.out.println("");

        }

    }

    public void blingCycle() {

        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();
        int i;
        for (i = 0; i < command.length(); i++) {

            stefan.move(length, height, vampiresList, command, i);

            if (vampiraesMove == true) {
                List<Vampire> toRemove = new ArrayList<Vampire>();

                for (Vampire other : vampiresList) {

                    other.move(length, height, vampiresList, stefan, toRemove);

                }
                vampiresList.removeAll(toRemove);
            }
        }
    }

}
