package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//version with all needed libraries for log 
public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        //logger.info("** Starting Maze Runner");
        
        try{
            Configuration config = configure(args);

            if (config.PATH_SEQUENCE() == null){
                //logger.info("**** Computing path");
                right_hand solver= new right_hand();
                
                solver.setup(config.MAZE_FILE());
                solver.solve();
                solver.display();
                
            }else{
                path_check thePath= new path_check();
                thePath.check(config.MAZE_FILE(), config.PATH_SEQUENCE());
            }
        
        }catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.error("PATH NOT COMPUTED");
            //logger.error("Please input a valid tag (-i) to run program. Remember to also use tag -p if you would like to test your own path");
            //e.printStackTrace();
        }

        //logger.info("** End of MazeRunner");
    }

    private static Configuration configure(String[] args) throws ParseException{
        //command line options 
        Options options = new Options();
        options.addOption("i", true, "MAZE_FILE");
        options.addOption("p", true, "PATH_SEQUENCE");
        
        CommandLineParser parser = new DefaultParser();//parser to get values from command line 
        CommandLine cmd = parser.parse(options, args);

        String MAZE_FILE = cmd.getOptionValue("i");
        //logger.info("**** Reading the maze from file " + MAZE_FILE);

        String PATH_SEQUENCE = cmd.getOptionValue("p");

        return new Configuration(MAZE_FILE, PATH_SEQUENCE);
    }

    private record Configuration(String MAZE_FILE, String PATH_SEQUENCE) {//use to ensure tags are being used 
        Configuration{
            if (MAZE_FILE == null){
                throw new IllegalArgumentException("Please input a maze file for the program to read");
            }
        }
    }

}

