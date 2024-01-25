package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;


public class path_find{
//confirm that tag is -i 
//import call Maze class to create array 
//brin in start point 
    public path_find(String MAZE_FILE){
        //System.out.print("flag1");
        //int start = 0;
        //int end = 0;
        //array path - need to store  

        String maze = MAZE_FILE; 
        Maze current;
        try{
            current = new Maze(maze); 
            int[][] path = current.array;//use to access variables from other class 
            int[][] end_point = current.end;
            String output = " "; //make this a public string? and then have it access by left, right and front methods 

            int[][] current_point = current.start;

            int starter = current.coord_s;
            int x =1; 
            //System.out.print("flag2");
//problem - current point does not hold coordinates
            while((current_point[0][0]) != (end_point[0][0])){//can we use current point and index it instead of using starter
                if((path[starter][x])== 0){//starting at col since we know that at first col there is only one entry point 
                    if((path[starter+1][x])==0){
                        //goes right ("south direction") - need to add RF)
                        current_point[0][0] = path[starter+1][x];//current point = updated 
                        starter = starter+1;//starter updated 
                        //output += "RF";//string output updated 
                        System.out.print("RF");
                    }else if((path[starter][x+1])==0){
                        //goes forward ("east direction") - need to add F)
                        current_point[0][0] = path[starter][x+1];//current point = updated 
                        x= x+1;//x updated 
                        //output += "F";//string output updated 
                        System.out.print("F");
                    }else if((path[starter-1][x])==0){
                        //goes left ("north direction") - need to add LF)
                        current_point[0][0] = path[starter-1][x];//current point = updated 
                        starter = starter-1;//starter updated 
                        //output += "LF";//string output updated 
                        System.out.print("LF");
                        //next move is to go straight or left again - can't go back down 
                        //need to add recurssion to keep calling same function whenever they go left 
                    }else{
                        System.out.print("issue");
                    }
                }
            }
            System.out.println(output);

        }catch(IOException e){
            System.out.println("/!\\ An error has occured /!\\");
            System.out.println("PATH NOT COMPUTED");
        }
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