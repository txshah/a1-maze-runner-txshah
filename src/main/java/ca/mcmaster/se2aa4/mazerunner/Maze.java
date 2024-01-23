package ca.mcmaster.se2aa4.mazerunner;

import java.util.Scanner;

public class Maze{

    private int[][] maze;
//use buffer array to read input
//have loops storing 2d arrray - simialr to how u did in oop 
//change wall to 1 and pass to 0
//print to array to test 

/*  
        Scanner my_scanner = new Scanner(System.in);
        System.out.print("enter dimension 1 (rows): ");
        int rows = my_scanner.nextInt();
        System.out.print("enter dimension 2 (columns): ");
        int cols = my_scanner.nextInt();

        double array[][]= new double [rows][cols];

        System.out.println("enter your array (space b/w digits in same row and enter b/w rows)");
        for (int i =0; i<rows; i++){
            for (int j=0; j<cols; j++){
                double n = my_scanner.nextDouble();
                array[i][j]=n;
            }
        }*/

        
    public int start_point(){
        //check first coloum for entry point 
        for (int i=0; i<maze.length; i++){
            if (maze[i][0]==0){
                return i; //find way to return full coordinates 
            }
        }return -1;
    }
}