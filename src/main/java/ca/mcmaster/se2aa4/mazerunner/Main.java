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
        
        //command line options 
        Options options = new Options();
        options.addOption("i", true, "MAZE_FILE");
        options.addOption("p", true, "PATH_SEQUENCE");

        CommandLineParser parser = new DefaultParser();//parser 

        try {
            
            CommandLine cmd = parser.parse(options, args);
            String MAZE_FILE = cmd.getOptionValue("i");
            String PATH_SEQUENCE = cmd.getOptionValue("p");//will add command for this after 

            logger.info("**** Reading the maze from file " + MAZE_FILE);
            BufferedReader reader = new BufferedReader(new FileReader(MAZE_FILE));
           
            String line;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        logger.info("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        logger.info("PASS ");
                    }
                }
                logger.info(System.lineSeparator());
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
