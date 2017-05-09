/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ukleja
 */
public class Hero {

    int width;
    int height;

    public Hero() {
        this.width = 0;
        this.height = 0;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void move(int dungeonWidth, int dungeonHeight, List<Vampire> others, String command, int i) {

        Character letter = command.charAt(i);

        if (letter.equals('w') && this.height - 1 >= 0) {
            this.height--;

        }

        if (letter.equals('d') && this.width + 1 < dungeonWidth) {
            this.width++;

        }

        if (letter.equals('s') && this.height + 1 < dungeonHeight) {
            this.height++;

        }

        if (letter.equals('a') && this.width - 1 >= 0) {
            this.width--;

        }

        if (others.contains(new Vampire(this.width, this.height))) {

            others.remove(new Vampire(this.width, this.height));

        }
    }

    }
