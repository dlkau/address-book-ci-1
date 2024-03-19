package W2.Homework_Tasks.Infiltration;

// Import necessary libraries
import java.util.ArrayList;
import java.util.HashMap;

public class main {

    /*
     This is the command line argument which was parsed into the processCmdArgs method:
     -start "(0,0)" -target "(0,10)" -g "(0,1)" "(0,2)" "(0,3)" -f "(0,4,0,8)" -s "(0,5,3.5)" -c "(0,6,e)"
     */


    public static void main(String[] args){
        HashMap<String, ArrayList<String>> parsedArgs = processCmdArgs(args);
        System.out.println(parsedArgs);
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
}