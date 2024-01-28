package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;



public class east implements compass{//implement class 
    //standard global variables 
    String direction = "east"; 
    String output =""; 
    int[] current; 
   

    public void move(int[][] path, int[]current_point, int[] end_point) throws IOException{   
        this.current = current_point; 
        //while east is still the direction and current point is not the end point run the loop 
        while(((current[0]!=end_point[0])|| (current[1]!=end_point[1])) && (direction.equals("east"))){     
            //run checks in each direction to make sure it is possible to move there  
            if(((path[(current[0]+1)][(current[1])])== 0)){
                right();
                
            }else if((path[(current[0])][(current[1]+1)])== 0){
                forward();
                
            }else if((path[(current[0]-1)][current[1]])== 0){
                left();
            }else{
                backwards();//180 turn
            }
        }
    }

    public void right(){
        //goes right ("south direction") - need to add RF)
        current[0] += 1;//current point = updated
         
        output += "RF";//string output updated 
        direction = "south";
    }
    public void forward(){
        //goes forward ("east direction") - need to add F)
        current[1] += 1;//current point = updated 
        
        output+="F";//string output updated 
        direction = "east"; 
        
    }

    public void left(){
        //goes left ("north direction") - need to add LF)
        current[0] -= 1;//current point = updated 
        
        output += "LF";//string output updated 
        direction = "north"; 
    }

    public void backwards(){
        output += "LL";//string output updated 
        direction = "west"; 
        
    }

//return needed variables 
    public String output(){
        return output; 
    }

    public String direction(){
        return direction; 
    }

    public int[] current(){
        return current; 
        
    }

} 
