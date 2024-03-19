package W2.Reading_Tasks.src;

public class Main {
    public static void main(String[] args){
        // Test the left-pad method
        System.out.println("Hello, World!");
        System.out.println("Welcome to CAB302!");
        System.out.println("This is our first project!");
        System.out.println("Bob likes triangles!");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < (4 - i) * 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 4 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}