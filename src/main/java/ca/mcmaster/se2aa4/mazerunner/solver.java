package ca.mcmaster.se2aa4.mazerunner;
import java.io.IOException;
import java.util.Optional;

//interface for algorithm's 
//implmentations of this would be for various ways to solve the maze 

public interface solver {
    void setup(String maze) throws IOException; //set up - stores basic varibales and reads maze file 
    
    void solve() throws IOException;//solves based on algo 
    
    String display(); //displays output of correct path 
}
