/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Ukleja
 */
public class Alive {

    int width;
    int height;

    public Alive(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void move(int dungeonWidth, int dungeonHeight, List<Alive> others) {
        Random random = new Random();
        int flag = 0;
        while (flag == 0) {
            int side = random.nextInt(4) + 1;

            if (side == 1 && this.height - 1 >= 0 && !others.contains(new Alive(this.width, this.height - 1))) {
                this.height--;
                flag = 1;
            }

            if (side == 2 && this.width + 1 < dungeonWidth && !others.contains(new Alive(this.width + 1, this.height))) {
                this.width++;
                flag = 1;
            }

            if (side == 3 && this.height + 1 < dungeonHeight && !others.contains(new Alive(this.width, this.height + 1))) {
                this.height++;
                flag = 1;
            }

            if (side == 4 && this.width - 1 >= 0 && !others.contains(new Alive(this.width - 1, this.height))) {
                this.width--;
                flag = 1;
            }

        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Alive)) {
            return false;
        }
        Alive o1 = (Alive) obj;

        return o1.getHeight() == this.getHeight() && o1.getWidth() == this.getWidth();

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.width;
        hash = 17 * hash + this.height;
        return hash;
    }

}
