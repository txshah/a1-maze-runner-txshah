package ca.mcmaster.se2aa4.mazerunner;


import java.io.IOException;

public interface compass {
    void move(int[][] path, int[]current_point, int[] end_point) throws IOException;

    String output();
    String direction();

    int[] current();


}
