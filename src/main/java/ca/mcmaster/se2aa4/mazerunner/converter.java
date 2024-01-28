package ca.mcmaster.se2aa4.mazerunner;


public class converter{
//need to confirm that tag is -i 
//A canonical path contains only F, R and L symbols
//A factorized path squashes together similar instructions (i.e., FFF = 3F, LL = 2L).
//Spaces are ignored in the instruction sequence (only for readability: FFLFF = FF L FF) 

    public String fac(String input){//method will convert a canonical path to a factoried path 
        String output = ""; 
        int count = 1; //count's same characters in a row 
        char current = input.charAt(0);//uses built in method to check which character is at that lociation of string 

        for (int i=1; i<input.length(); i++){//loop runs for length of strin 
            //count the number of repeats but dont write a number for only 1 
            if (current == (input.charAt(i))){
                count++; //if index same as current same increase count 
            }else{
                if (count>1){//
                    output += Integer.toString(count)+current; //add to output 
                }else{
                    output += current; //add to output 
                }
                current = input.charAt(i);//update current 
                count = 1;//reset count 
            }
        }

        if (count > 1) {//last count and output not included - make sure it shows up in output 
            output += Integer.toString(count) + current;
        } else {
            output += current;
        }
        //System.out.println(output);
        return output;
        
    }


    public String can(String input){//method will convert a factoried path to a canonical path 
        String output = "";
        for(int i=0; i<input.length(); i++){//run loop for length of list 
            char current = input.charAt(i);//index string to get char 

            if(Character.isDigit(current)){ //check if char is a digit 
                for(int j=0; j<(Integer.parseInt(String.valueOf(current)));j++){//if yes run this loop 
                    //loop runs for the value of the digit and adds that many of the next direction 
                    output+= (input.charAt(i+1));
                }i++; //skip over next char as it has been accounted for 
            }else{
                output += current; //add to output (no number in front of char)
            }
        }
        //System.out.println(output);
        return output;
    }

} 

    /*public converter(String input, String Type){  
        //type is the desired output - so type fac will return a factorize output 
        if (Type.equals("fac")){
            fac(input);
        }else if(Type.equals("can")){
            can(input);
        }else{
            System.out.println("no conversion possible");
        }

    }*/