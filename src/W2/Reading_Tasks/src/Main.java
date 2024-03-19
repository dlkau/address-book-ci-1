package W2.Reading_Tasks.src;

public class Main {
    public static void main(String[] args){
        // Test the left-pad method
        System.out.println("Hello, World!");
        System.out.println("Welcome to CAB302!");
        System.out.println("This is our first project!");
        System.out.println("Bob likes triangles!");
        printBox("Bob likes triangles!");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < (4 - i) * 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 4 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        printBox("Alice likes rectangles!");
        for (int i = 0; i < 5; i++) {
            System.out.println("*****************");
        }
    }

    /**
     * Print a string with a box around it, using the box-drawing characters.
     * @param str the string to be printed
     */
    public static void printBox(String str){
        int len = str.length() +4;
        for (int i = 0; i < len; i++){
            if (i==0){
                System.out.print("╔");
            } else if (i == len-1){
                System.out.print("╗");
            } else {
                System.out.print("═");
            }
        }
        System.out.println();
        System.out.println("║ " + str + " ║");
        for (int i =0; i < len; i++){
            if(i==0){
                System.out.print("╚");
            } else if (i == len - 1){
                System.out.print("╝");
            } else {
                System.out.print("═");
            }
        }
        System.out.println();
    }
}