package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Maze{
    //global variables 
    public int rows = 0; 
    public int cols = 0; 
    public int[][] array ;

    public int[] start;
    public int[] end;
//code to print maze - currently not being used 
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
//produce dimensions of maze
    private void dimensions(String maze) throws IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader(maze));//read maze 

        String firstLine = reader.readLine();//read first line 
        cols = firstLine.length(); //count characters in first line for number of cols 
        
        rows = 1; //start at one since first line has been read to get cols 
        while((reader.readLine()) != null){//read all lines and count how many 
            rows++;
        }
        reader.close();
        
    }

//convert maze into arrray of 0/1s 
    public int[][] maze_convert(String maze) throws IOException{
        dimensions(maze);//make sure rows and cols are found 

        BufferedReader reader = new BufferedReader(new FileReader(maze));

        array = new int[rows][cols];//create array based on dimentions 

        for (int i =0; i<rows; i++){//loop through rows 
            String line = reader.readLine();
            for (int j=0; j<cols; j++){//loop through each element of array 
                if (line.charAt(j) == '#') {//if spot full(can't pass) output 1 
                    array[i][j]= 1; 
                } else if (line.charAt(j) == ' ') {//if able to pass - array has 0
                    array[i][j]= 0; 
                }
            }
        }
        //tester code to print array of 0/1s
        /*for (int i =0; i<rows; i++){
            for (int j=0; j<cols; j++){
                int n = array[i][j];
                System.out.print(n+ " ");
            }System.out.println(" ");
        }*/
        reader.close();
        return array; 
    }

    public void start_point(){
        //check first coloum for entry point (rowsxcols)
        start = new int[2]; //store row and col in array 
        for (int i=0; i<rows; i++){
            if (array[i][0]==0){//check when in the first col the row is 0 
                start[0] = i; //rows 
                start[1] = 0; //cols 
            }
        }
    }

    public void end_point(){
        //check last coloum for end point 
        end = new int[2];
        for (int i=0; i<rows; i++){
            if (array[i][(cols-1)]==0){//check when in the last col the row is 0 
                end[0] = i; //rows 
                end[1]= (cols-1); //cols 
            }
        }
    }

    public Maze(String MAZE_FILE) throws IOException{
        String maze = MAZE_FILE; 
        //print_maze(maze);
        maze_convert(maze);
        start_point();
        end_point();
    }
}

