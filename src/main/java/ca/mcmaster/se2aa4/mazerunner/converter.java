package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;
import java.util.Arrays;
 


public class converter{
//need to confirm that tag is -i 
//A canonical path contains only F, R and L symbols
//A factorized path squashes together similar instructions (i.e., FFF = 3F, LL = 2L).
//Spaces are ignored in the instruction sequence (only for readability: FFLFF = FF L FF) 

    public converter(String input, String Type){  
        //type is the desired output - so type fac will return a factorize output 
        if (Type.equals("fac")){
            fac(input);
        }else if(Type.equals("can")){
            can(input);
        }else{
            System.out.println("no conversion possible");
        }

    }

    public String fac(String input){
        //FFFRFFL
        String output = ""; 
        int count = 1; 
        char current = input.charAt(0);

        for (int i=1; i<input.length(); i++){
            //count the number of repeats but dont write a number for only 1 
            if (current == (input.charAt(i))){
                count++; 
            }else{
                if (count>1){
                    output += Integer.toString(count)+current; 
                }else{
                    output += current; 
                }
                current = input.charAt(i);
                count = 1;
            }
        }

        if (count > 1) {//last count - try to add in loop but good for now 
            output += Integer.toString(count) + current;
        } else {
            output += current;
        }
        System.out.println(output);
        return output;
    }


    public String can(String input){
        String output = "";

        //check if digit or char
        //char just add
        //digit(1) then input that char(2) x amount of times 
        //then start from the value after the char (3 - i++?) and repeat process 


        return output;
    }

} 
