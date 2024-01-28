
package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

public class path_check{
//global variable intialization 
    private int[][] path;
    private int[] end_point;

    public int[] current_point;
    public String direction; 

    public void check(String MAZE_FILE, String input) throws IOException{
        //setup variables to get essential info 
        boolean valid = true; 
        String maze = MAZE_FILE; 
        Maze current = new Maze(maze);

        current_point = current.start;
        end_point = current.end;
        path = current.array;
        direction = "east"; 

        converter convert = new converter( ); //convert string into can format 
        String converted = convert.can(input); 

        for (int i=0; i < converted.length(); i++){//loop throguh length of converted string 
            char choice = (converted.charAt(i)); //index each letter 

            if(choice == 'F'){//only move at F commands based on direction 
                ///moving F means different things based on the direction(which row and col is changed)
                if (direction.equals("east") && path[current_point[0]][current_point[1] + 1] == 0) {
                    current_point[1] += 1;
                } else if (direction.equals("west") && path[current_point[0]][current_point[1] - 1] == 0) {
                    current_point[1] -= 1;
                } else if (direction.equals("north") && path[current_point[0] - 1][current_point[1]] == 0) {
                    current_point[0] -= 1;
                } else if (direction.equals("south") && path[current_point[0] + 1][current_point[1]] == 0) {
                    current_point[0] += 1;
                } else {
                    valid = false;
                    break;
                }
            }else if(choice =='L'){ //left and right commands change your direction, does not change current_point 
                if (direction.equals("east")) {
                    direction = "north";
                } else if (direction.equals("west")) {
                    direction = "south";
                } else if (direction.equals("north")) {
                    direction = "west";
                } else if (direction.equals("south")) {
                    direction = "east";
                }
            }else if(choice=='R'){
                if (direction.equals("east")) {
                    direction = "south";
                } else if (direction.equals("west")) {
                    direction = "north";
                } else if (direction.equals("north")) {
                    direction = "east";
                } else if (direction.equals("south")) {
                    direction = "west";
                }
            }else{
                valid = false;
                break; 
            }
        }//final check to make sure once string is over we are at the exit point 
            if ((current_point[0] != end_point[0]) || (current_point[1] != end_point[1])){
                valid = false; 
            } else {
                valid = true; 
            }

            if(valid ==true){//output based on check 
                System.out.println("correct path");
            }else{
                System.out.println("incorrect path");
            }
            
    }
        
}


    