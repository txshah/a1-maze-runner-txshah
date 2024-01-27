
package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

public class path_check{

    private int[][] path;//use to access variables from other class 
    private int[] end_point;

    public int[] current_point;
    public String direction; 

    public boolean check(String MAZE_FILE, String input) throws IOException{
        boolean valid = true; 
        String maze = MAZE_FILE; 
        Maze current = new Maze(maze);

        current_point = current.start;
        end_point = current.end;
        path = current.array;//use to access variables from other class 
        direction = "east"; 

        
        converter convert = new converter(input,"can"); 
        String converted = convert.can(input); 

        for (int i=0; i < converted.length(); i++){
            char choice = (converted.charAt(i)); 

            if(choice == 'F'){
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
            }else if(choice =='L'){
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


    