package W1.Reading_Tasks;

/**
 * In this program, we are returning "Hello World" to the terminal.
 * A for loop has also been included to print each of the supplied command
 * line arguments to the terminal.
 */
public class Hello_World {
    public static void main(String[] args){
        System.out.println("Hello World");

        // Print each of the command line arguments to the terminal
        for (String arg : args){
            System.out.println(arg);
        }
    }
}
