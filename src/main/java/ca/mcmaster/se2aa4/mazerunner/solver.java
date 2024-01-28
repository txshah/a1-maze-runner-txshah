package ca.mcmaster.se2aa4.mazerunner;
import java.io.IOException;
import java.util.Optional;

public interface solver {
    void setup() throws IOException; 
    
    void solve() throws IOException;
    
    String display(); 
}
