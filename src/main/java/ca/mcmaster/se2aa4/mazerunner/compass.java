package ca.mcmaster.se2aa4.mazerunner;


import java.io.IOException;

public interface compass {//interface for directions 
    void move(int[][] path, int[]current_point, int[] end_point) throws IOException; //checks if player can move in that direction 

    //return variables used for tracking and display 
    String output(); 
    String direction();

    int[] current();

}
