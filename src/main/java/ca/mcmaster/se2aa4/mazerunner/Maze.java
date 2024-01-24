package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze{
    
    public int rows = 0; 
    public int cols = 0; 
    public int[][] array ;

    //print maze 
    private void print_maze(String maze) throws IOException{
       BufferedReader reader = new BufferedReader(new FileReader(maze));
        String line; 
        while ((line = reader.readLine()) != null) {
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    System.out.print("WALL ");
                } else if (line.charAt(idx) == ' ') {
                    System.out.print("PASS ");
                }
            }
            System.out.print(System.lineSeparator());
        }
        reader.close();
    }

    private void dimensions(String maze) throws IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader(maze));

        String firstLine = reader.readLine();
        cols = firstLine.length(); 
        
        rows = 1; //start at one since first line has been read to get cols 
        while((reader.readLine()) != null){
            rows++;
        }
        reader.close();
        
    }


    public int[][] maze(String maze) throws IOException{
        dimensions(maze);

        BufferedReader reader = new BufferedReader(new FileReader(maze));

        array = new int[rows][cols];

        for (int i =0; i<rows; i++){
            String line = reader.readLine();
            for (int j=0; j<cols; j++){
                if (line.charAt(j) == '#') {
                    array[i][j]= 1; 
                } else if (line.charAt(j) == ' ') {
                    array[i][j]= 0; 
                }
            }
        }
        for (int i =0; i<rows; i++){
            for (int j=0; j<cols; j++){
                int n = array[i][j];
                System.out.print(n+ " ");
            }System.out.println(" ");
        }
        reader.close();
        return array; 
    }

    public int start_point(){
        //check first coloum for entry point 
        for (int i=0; i<rows; i++){
            if (array[i][0]==0){
                System.out.print("start "+i);
                return i; 
            }
        }return -1;
    }

    public int end_point(){
        //check last coloum for end point 
        for (int i=0; i<rows; i++){
            if (array[i][cols-1]==0){
                System.out.print("end "+i);
                return i; 
                
            }
        }return -1;
    }

    public Maze(String MAZE_FILE) throws IOException{
        String maze = MAZE_FILE; 
        print_maze(maze);
        maze(maze);
        start_point();
        end_point();
    }
}

//use buffer array to read input
//have loops storing 2d arrray - simialr to how u did in oop course last sem 
//change wall to 1 and pass to 0
//print to array to test 
 
        /*Scanner my_scanner = new Scanner(System.in);
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
