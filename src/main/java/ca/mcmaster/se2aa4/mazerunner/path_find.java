package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;
import java.util.Arrays;
 


public class path_find{
//need to confirm that tag is -i 
    
    private int[][] path;//use to access variables from other class 
    private int[][] end_point;
    private String output = " "; 

    private int[][] current_point;
    private int col; 
    private int row; 
    
    private String prev = " ";
   

    public path_find(String MAZE_FILE) throws IOException{   
        String maze = MAZE_FILE; 
        Maze current = new Maze(maze); 

        current_point = current.start;
        end_point = current.end;
        path = current.array;//use to access variables from other class 

        row = current_point[0][0];
        col = current_point[0][1];

        while(!(Arrays.equals(current_point[0],end_point[0]))){
            if(((path[row+1][col])==0) && (!(prev.equals("left")))){
                right();
            }else if((path[row][col+1])==0){
                forward();
            }else if((path[row-1][col])==0){
                left();
            }
        }System.out.println("output:" + output);

    }
    public void right(){
        //goes right ("south direction") - need to add RF)
        current_point[0][0] = row+1;//current point = updated 
        row = row + 1;//row updated 
        output += "RF";//string output updated 
        prev = "right";
        System.out.println("RF");

    }
    public void forward(){
        //goes forward ("east direction") - need to add F)
        current_point[0][1] = col +1;//current point = updated 
        col = col+1;//x updated 
        output += "F";//string output updated 
        System.out.println("F");
        prev = "forward";
    }

    public void left(){
        //goes left ("north direction") - need to add LF)
        current_point[0][0] = row-1;//current point = updated 
        row = row-1;//row updated 
        output += "LF";//string output updated 
        System.out.println("LF");
        prev = "left"; //next move is to go straight or left again - can't go back down(aka right) 
        //System.out.println(x + row + current_point[0][0]+ current_point[0][1]);
    }
} 

        //get 2d array inputted 
        //start at [start][0] **check 2d array
        //while coordinates not equal [end][cols] run loop
        //check - can go right
        //if yes go right (+1 down)
        //if not go forward (add +1 to col your in)
        // store path in array 
        //keep repeating this - do this by call right and forward methods 
        //check if destination matches 