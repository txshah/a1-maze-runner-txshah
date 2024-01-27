
package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

public class path_check{
    //confirm that the tag is -p 

    private int[][] path;//use to access variables from other class 
    private int[] end_point;

    public int[] current_point;
    public String direction; 

    public boolean check(String MAZE_FILE, String input) throws IOException{
        //bring in array of maze 
        //check if insturctions work 
            //go through string
            //based on string commands move through array
            //as long as each place they go is empty string can contine
            //quit if they hit a wall
            //at the end of string make sure current_point and end is the same
            //if yes correct path 
            //if false not correct path 

        boolean valid = true; 
        String maze = MAZE_FILE; 
        Maze current = new Maze(maze);

        current_point = current.start;
        end_point = current.end;
        path = current.array;//use to access variables from other class 
        direction = "east"; 

        
        converter convert = new converter(input,"can"); 
        String converted = convert.can(input); 

        for (int i=0; i< converted.length(); i++){
            char choice = (converted.charAt(i)); 

            if(direction.equals("east")){
                if (((path[current_point[0] + 1][current_point[1]]) == 0) && choice =='R') {
                    //current_point[0] += 1;
                    direction = "south";                     
                }else if (((path[current_point[0]][current_point[1] + 1]) == 0) && choice == 'F') {
                    current_point[1] += 1;
                    direction = "east"; 

                }else if (((path[current_point[0] - 1][current_point[1]]) == 0) && choice =='L') {
                    //current_point[0] -= 1;
                    direction = "north"; 
                }else{
                    valid = false; 
                    break;
                }
            }else if (direction.equals("west")){
                if(((path[(current_point[0])-1][(current_point[1])])== 0)&& choice =='R'){
                    //current_point[0] -= 1;//current_point point = updated    
                    direction = "north";
                }else if(((path[(current_point[0])][((current_point[1])-1)])== 0) && choice == 'F'){
                    current_point[1] -= 1;//current_point point = updated 
                    direction = "west"; 
                }else if(((path[(current_point[0]+1)][current_point[1]]) == 0) && choice =='L'){
                    //current_point[0] += 1;//current_point point = updated 
                    direction = "south"; 

                }else{
                    valid = false;
                    break;   
                }
            }else if (direction.equals("north")){
                if(((path[(current_point[0])][(current_point[1]+1)])== 0)&& choice =='R'){
                    //current_point[1] += 1;//current point = updated 
                    direction = "east";
                    
                }else if(((path[(current_point[0]-1)][(current_point[1])]) == 0) && choice == 'F'){
                    current_point[0] -= 1;//current point = updated 
                    direction = "north";
                    
                }else if(((path[(current_point[0])][current_point[1]-1])== 0) && choice =='L'){
                    //current_point[1] -= 1;//current point = updated 
                    direction = "west"; 
                    
                }else{
                    valid = false;
                    break;    
                }
            }else if (direction.equals("south")){
                if(((path[(current_point[0])][(current_point[1]-1)])== 0)&& choice =='R'){
                    //current_point[1] -= 1;//current point = updated 
                    direction = "west";
                }else if(((path[(current_point[0]+1)][(current_point[1])])== 0) && choice == 'F'){ 
                    current_point[0] += 1;//current point = updated 
                    direction = "south"; 
                    
                }else if(((path[(current_point[0])][current_point[1]+1])== 0) && choice =='L'){
                    //current_point[1] += 1;//current point = updated
                    direction = "east"; 
                }else{
                    valid = false;
                    break;    
                }
            }else{
                valid = false;
                break;  
            }
        }

            if ((current_point[0] != end_point[0]) || (current_point[1] != end_point[1])){
                valid = false; 
            } else {
                valid = true; 
            }
    
            System.out.println(valid);
            return valid; 
    }
        
}

        //for every character in string 
        //if statment based on direciton case 
        //at the end check if final is equal to current_point 
