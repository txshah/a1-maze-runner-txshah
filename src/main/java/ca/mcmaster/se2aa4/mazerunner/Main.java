package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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

        logger.info("** Starting Maze Runner");
        
        try{
            Configuration config = configure(args);
            //System.out.println(config);
            logger.info("**** Computing path");

        }catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.error("PATH NOT COMPUTED");
        }

        logger.info("** End of MazeRunner");
    }

    private static Configuration configure(String[] args) throws ParseException{
        //command line options 
        Options options = new Options();
        options.addOption("i", true, "MAZE_FILE");
        options.addOption("p", true, "PATH_SEQUENCE");
        
        CommandLineParser parser = new DefaultParser();//parser to get values from command line 
        CommandLine cmd = parser.parse(options, args);

        String MAZE_FILE = cmd.getOptionValue("i");
        logger.info("**** Reading the maze from file " + MAZE_FILE);


        String PATH_SEQUENCE = cmd.getOptionValue("p");

        return new Configuration(MAZE_FILE, PATH_SEQUENCE);
    }

    private record Configuration(String MAZE_FILE, String PATH_SEQUENCE) {//use to ensure tags are being used 
        Configuration{
            if (MAZE_FILE ==null){
                throw new IllegalArgumentException("Please input a valid tag (-i) to run program. Remeber to also use tag -p if you would like to test your own path");
            }
        }
    }

}

    /*
code for printing maze 
            BufferedReader reader = new BufferedReader(new FileReader(MAZE_FILE));
            String line; 
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
     */