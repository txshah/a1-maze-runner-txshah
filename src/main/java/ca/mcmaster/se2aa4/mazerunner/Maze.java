package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Maze{
    
    public int rows = 0; 
    public int cols = 0; 
    public int[][] array ;

    public int[][] start;
    public int[][] end;

    public int coord_s;
    public int coord_f;

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
        //check first coloum for entry point 
        start = new int[1][1]; 
        for (int i=0; i<rows; i++){
            if (array[i][0]==0){
                //System.out.print("start "+i);
                start[0][0] = array[i][0]; 
                coord_s = i; 
            }
        }
    }

    public void end_point(){
        //check last coloum for end point 
        for (int i=0; i<rows; i++){
            end = new int[1][1];
            if (array[i][cols-1]==0){
                //System.out.print("end "+i); 
                end[0][0] = array[i][cols-1]; 
                coord_f = i; 
            }
        }
    }

    public Maze(String MAZE_FILE) throws IOException{
        String maze = MAZE_FILE; 
        print_maze(maze);
        maze_convert(maze);
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
