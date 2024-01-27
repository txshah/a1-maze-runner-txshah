package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Maze{
    
    public int rows = 0; 
    public int cols = 0; 
    public int[][] array ;

    public int[] start;
    public int[] end;

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


    public int[][] maze_convert(String maze) throws IOException{
        dimensions(maze);//make sure rows and cols are found 

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
        start = new int[2]; 
        for (int i=0; i<rows; i++){
            if (array[i][0]==0){
                start[0] = i; //rows 
                start[1] = 0; //cols 
                //coord_s = i; 
            }
        }
    }

    public void end_point(){
        //check last coloum for end point 
        end = new int[2];
        for (int i=0; i<rows; i++){
            if (array[i][(cols-1)]==0){
                end[0] = i; //rows 
                end[1]= (cols-1); //cols 
                //coord_f = i; 
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

