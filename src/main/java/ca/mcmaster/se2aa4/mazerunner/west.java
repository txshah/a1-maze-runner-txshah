package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;


public class west{
    String direction = "west"; 
    String output =""; 
    int[] current; 

    public west(int[][] path, int[]current_point, int[] end_point) throws IOException{   

        this.current = current_point; 

        while(((current_point[0]!=end_point[0])|| (current_point[1]!=end_point[1])) && (direction.equals("west"))){
  
            if(((path[(current[0])-1][(current[1])])== 0)){
                right();
                
            }else if((path[(current[0])][((current[1])-1)])== 0){
                forward();
                
            }else if((path[(current[0]+1)][current[1]]) == 0){
                left();    
            }else{
                backwards();//180 turn
                
            }
        }
    }

    public void right(){
        //goes right ("south direction") - need to add RF)
        int temp = current[0]; 
        current[0] = temp - 1;//current point = updated 
    
        output += "RF";//string output updated 
        direction = "north";
    }
    public void forward(){
        //goes forward ("west direction") - need to add F) 
        int temp = current[1]; 
        current[1] = temp - 1;//current point = updated 
        
        output += "F";//string output updated 
        direction = "west"; 
    }

    public void left(){
        //goes left ("north direction") - need to add LF)
        int temp = current[0]; 
        current[0] = temp + 1;//current point = updated 
        
        output += "LF";//string output updated 
        direction = "south"; 
    }

    public void backwards(){
        output += "LL";//string output updated 
        direction = "east"; 
        
    }


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

