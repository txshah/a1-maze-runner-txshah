package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;
 


public class right_hand{

    private int[][] path;//use to access variables from other class 
    private int[] end_point;
    public String output = ""; 

    public int[] current_point;
    public String direction; 
   
    public void setup(String MAZE_FILE) throws IOException{
        String maze = MAZE_FILE; 
        Maze current = new Maze(maze);

        current_point = current.start;
        end_point = current.end;
        path = current.array;//use to access variables from other class 
        direction = "east"; 
    }

    public void solve() throws IOException{   
        //System.out.println("player class");
        
        while((current_point[0]!=end_point[0])|| (current_point[1]!=end_point[1])){
            
            if(direction.equals("east")){
                compass east = new east(); 
                
                east.move(path, current_point, end_point);
                direction = east.direction();
                current_point = east.current();
                String temp = east.output();

                output+= temp; 


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
        //System.out.println(output);

    }

    public String display(){
        converter convert = new converter(); 
        String converted = convert.fac(output); 
        
        System.out.println(converted);
        return converted; 
    }

    
} 
