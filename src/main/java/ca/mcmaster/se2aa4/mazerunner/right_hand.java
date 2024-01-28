package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;


public class right_hand implements solver{//implments solver interfce 
    
    //global variables - used to access variables from other class 
    private int[][] path;
    private int[] end_point;
    public String output = ""; //used in multiple methods 

    public int[] current_point;
    public String direction; 
   
    public void setup(String MAZE_FILE) throws IOException{//set up variables for this alogrithm 
        String maze = MAZE_FILE; 
        Maze current = new Maze(maze);

        current_point = current.start;//start at east and end at west 
        end_point = current.end;
        path = current.array;//use to access variables from other class 
        direction = "east"; //initial direction set to facing east 
    }

    public void solve() throws IOException{   
        //as long as current and end at not the same the while loop runs 
        while((current_point[0]!=end_point[0])|| (current_point[1]!=end_point[1])){
            //based on direction/where player is facing we have different rules for where a right, left or forward can take you 
            //access specific classes based on direction 
            if(direction.equals("east")){
                compass east = new east(); 
                
                east.move(path, current_point, end_point);
                direction = east.direction();
                current_point = east.current();
                String temp = east.output();

                output+= temp; //add to output string 


            }else if (direction.equals("west")){
                compass west = new west(); 

                west.move(path, current_point, end_point);
                direction = west.direction();
                current_point = west.current();
                String temp = west.output();

                output+= temp; 


            }else if (direction.equals("south")){
                compass south = new south(); 
                
                south.move(path, current_point, end_point);
                direction = south.direction();
                current_point = south.current();
                String temp = south.output();

                output+= temp; 


            }else if (direction.equals("north")){
                compass north = new north(); 
                
                north.move(path, current_point, end_point);
                direction = north.direction();
                current_point = north.current();
                String temp = north.output();

                output+= temp; 

            }else{
                System.out.println("no direction - error");
            }
        }

    }

    public String display(){//display output path 
        converter convert = new converter(); 
        String converted = convert.fac(output); //convert to factorial and output result 
        
        System.out.println(converted);
        return converted; 
    }

    
} 
