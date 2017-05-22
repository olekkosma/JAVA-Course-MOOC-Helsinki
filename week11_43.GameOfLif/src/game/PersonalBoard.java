/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author Ukleja
 */
public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double probabilty) {
        Random random = new Random();
        double prop = random.nextDouble();
        boolean[][] board = getBoard();
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                if (prop < probabilty) {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
                prop = random.nextDouble();
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if(x<0 || x>=getWidth() || y<0 || y>=getHeight()){
            return false;
        }
        boolean[][] board = getBoard();
        return board[x][y];
    }

    @Override
    public void turnToLiving(int x, int y) {
        if(x<0 || x>=getWidth() || y<0 || y>=getHeight()){
            return ;
        }

        boolean[][] board = getBoard();
        board[x][y] = true;
    }

    @Override
    public void turnToDead(int x, int y) {
        if(x<0 || x>=getWidth() || y<0 || y>=getHeight()){
            return ;
        }
        boolean[][] board = getBoard();
        board[x][y] = false;

    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {

        boolean[][] board = getBoard();
        int sum = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x+i>=0 && y+j>=0 && x+i<getWidth() && y+j<getHeight()) {
                    if (board[x+i][y+j] && !(x+i==x && y+j==y)) {
                        sum++;
                        System.out.println((x+i)+" "+(y+j));
                    }
                }
            }
        }
        
        return sum;

    }

    @Override
    public void manageCell(int x, int y, int livingFriends) {
        boolean[][] board = getBoard();
        
        if(board[x][y]){
            if(livingFriends<2 || livingFriends>3){
                board[x][y]=false;
            }
            
        }else{
            if(livingFriends==3){
                board[x][y]=true;
            }
        }
        
    }

}
