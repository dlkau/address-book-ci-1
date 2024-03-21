package W4.Homework_Tasks.Infiltration;

// Import necessary libraries
import W4.Homework_Tasks.Infiltration.common.Location;
import W4.Homework_Tasks.Infiltration.common.Map;
import W4.Homework_Tasks.Infiltration.obstacles.*;
import W4.Homework_Tasks.Infiltration.obstacles.Obstacle;
import W4.Homework_Tasks.Infiltration.obstacles.ObstacleType;
import W4.Homework_Tasks.Infiltration.obstacles.Sensor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class main {

    /*
     This is the command line argument which was parsed into the processCmdArgs method:
     -start "(0,0)" -target "(0,10)" -g "(0,1)" "(0,2)" "(0,3)" -f "(0,4,0,8)" -s "(0,5,3.5)" -c "(0,6,e)"
     -start "(3,2)" -target "(189,8)" -g "(0,1)" "(0,2)" "(0,3)" -f "(0,4,0,8)" -s "(0,5,3.5)" -c "(0,6,e)"
     -start "(3,2)" -target "(6,2)" -g "(0,1)" "(0,2)" "(0,3)" -f "(0,4,0,8)" -s "(0,5,3.5)" -c "(0,6,e)"
     -start "(0,0)" -target "(0,10)" -g "(0,1)" "(0,2)" "(0,3)" -f "(0,4,0,8)" -s "(0,5,3.5)" -c "(0,6,e)"
     // This command line argument will be used to see if the wall implementation worked
     -start (0,7) -target (7,2) -w (2,2,6,8)
     // This command line argument will be used to see if the laser implementation worked
     */

    public static void main(String[] args){
        // Parse the command line arguments into obstacles and create a map with those obstacles
        HashMap<String, ArrayList<String>> parsedArgs = processCmdArgs(args);
        ArrayList<Obstacle> obstacles = parseObstacles(parsedArgs);
        Map map = new Map(obstacles);

        // Parse the start and target locations
        String startArg = stripParentheses(parsedArgs.get("-start").get(0));
        String targetArg = stripParentheses(parsedArgs.get("-target").get(0));
        Location start = Location.parse(startArg);
        Location target = Location.parse(targetArg);

        // Show the map
        System.out.println(map.getSolvedMap(start, target));
        // System.out.println(parsedArgs);
    }

    /**
     * This static method processes command line arguments and converts them into a HashMap.
     * @param cmdArgs the command line arguments to be parsed.
     * @return a HashMap representing each of the arguments
     */
    public static HashMap<String, ArrayList<String>> processCmdArgs(String[] cmdArgs){
        HashMap<String, ArrayList<String>> parsedArgs = new HashMap<String, ArrayList<String>>();
        ArrayList<String> currArgs = null;
        for (String arg : cmdArgs){
            if(arg.startsWith("-")){
                // When starting with a new argument, clear the currArgs array
                currArgs = new ArrayList<String>();
                parsedArgs.put(arg, currArgs);
            } else if(currArgs != null) {
                currArgs.add(arg);
            }
        }
        return parsedArgs;
    }

    /**
     * This method will strip the parentheses from a given argument.
     * @param arg the argument with the parentheses to strip.
     * @return the argument without parentheses.
     */
    public static String stripParentheses(String arg){
        return arg.substring(1,arg.length() -1);
    }

    /**
     * This method parses the arguments which were parsed via the command line arguments.
     * @param parsedArgs the arguments to be parsed.
     * @return A ArrayList of generated obstacles.
     */
    public static ArrayList<Obstacle> parseObstacles(HashMap<String, ArrayList<String>> parsedArgs){
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        for(ObstacleType type : ObstacleType.values()){
            String key = "-" + type.getArgumentName();
            ArrayList<String> args = parsedArgs.get(key);
            if(args==null){
                continue;
            }
            for(String arg : args){
                // Remove the parentheses from the argument
                String cleanedArg = stripParentheses(arg);
                Obstacle obstacle = switch (type){
                    case GUARD -> Guard.parse(cleanedArg);
                    case FENCE -> Fence.parse(cleanedArg);
                    case SENSOR -> Sensor.parse(cleanedArg);
                    case CAMERA -> Camera.parse(cleanedArg);
                    case WALL -> Wall.parse(cleanedArg);
                    case LASER -> Laser.parse(cleanedArg);
                };
                obstacles.add(obstacle);
            }
        }
        return obstacles;
    }
}