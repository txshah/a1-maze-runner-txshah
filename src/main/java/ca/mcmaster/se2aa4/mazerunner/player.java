package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;
import java.util.Arrays;
 


public class player{
//need to confirm that tag is -i 
    
    private int[][] path;//use to access variables from other class 
    private int[] end_point;
    public String output = " "; 

    public int[] current_point;
    //private int col; 
    //private int row; 
    public String direction; 
   

    public player(String MAZE_FILE) throws IOException{   
        //System.out.println("player class");
        String maze = MAZE_FILE; 
        Maze current = new Maze(maze);

        current_point = current.start;
        end_point = current.end;
        path = current.array;//use to access variables from other class 
        direction = "east"; 
        

        while((current_point[0]!=end_point[0])|| (current_point[1]!=end_point[1])){
            
            if(direction.equals("east")){
                System.out.println("east");
                east east_direction = new east(path, current_point, end_point); 
                direction = east_direction.direction();
                current_point = east_direction.current();
                String temp = east_direction.output();

                output+= temp; 


            }else if (direction.equals("west")){
                System.out.println("west");
                west west_direction = new west(path, current_point, end_point); 
                direction = west_direction.direction();
                current_point = west_direction.current();
                String temp = west_direction.output();

                output+= temp; 


            }else if (direction.equals("south")){
                System.out.println("south");
                south south_direction = new south(path, current_point, end_point); 
                direction = south_direction.direction();
                current_point = south_direction.current();
                String temp = south_direction.output();

                output+= temp; 


            }else if (direction.equals("north")){
                System.out.println("north");
                north north_direction = new north(path, current_point, end_point); 
                direction = north_direction.direction();
                current_point = north_direction.current();
                String temp = north_direction.output();

                output+= temp; 

            }else{
                System.out.println("no direction - error");
            }
        }System.out.println(output);

    }
} 
