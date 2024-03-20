package W2.Tutorial_Tasks;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Static list of users, acting as a database
    private static ArrayList<User> users = new ArrayList<>();

    private static IAuthenticationService authService = new AuthenticationService(users);

    /* // No longer necessary since AuthenticationServices has been created.
    // Mock authentication service that always returns the first user when logged in, and does
    // nothing when signed up
    private static IAuthenticationService authService = new IAuthenticationService() {
        @Override
        public User signUp(String username, String password) {
            return null;
        }

        @Override
        public User logIn(String username, String password) {
            return users.get(0);
        }
    };
    */

    private static boolean isRunning = true;

    /**
     * This is the entry point of the application.
     * @param args The command-line arguments.
     */
    public static void main(String[] args){
        users.add(new User("test", "test"));
        while (isRunning) {
            showMenu();
        }
    }

    /**
     * Provides the main menu ot the user
     */
    public static void showMenu(){
        System.out.println("Welcome to the To-Do List Application!");
        System.out.println("1. Log in");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");
        // Ask for user choice
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    /**
     * Handle's the user's choice, mapping the menu options to the corresponding methods.
     * @param choice the User's choice.
     */
    public static void handleMenu(int choice){
        switch (choice){
            case 1:
                onLogIn();
                break;
            case 2:
                onSignUp();
                break;
            case 3:
                onExit();
                break;
            default:
                System.out.println("Invalid choice!");
                showMenu();
        }
    }

    /**
     * This method handles the log-in process, and the post-login operations.
     */
    public static void onLogIn(){
        System.out.print("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        User user = authService.logIn(username, password);
        if (user != null){
            System.out.println("Welcome, " + user.getUsername() + "!");
            // TODO Later: Add the to-do list operations
            ToDoList userToDoList = new ToDoList(user);
            userToDoList.run();
        } else {
            System.out.println("Sorry, you have incorrectly input a username or password.");
        }

    }

    /**
     * This method handles the sign-up process.
     */
    public static void onSignUp(){
        System.out.print("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        User user = authService.signUp(username, password);
        //TODO Later: Shows a message based on the result.

        // - If the user is not null, show "User <username> has been created successfully!"
        if (user != null){
            System.out.printf("User %s has been created successfully!\n", username);
        }
        // - If the user is null, show "The username is already taken!"
        else {
            System.out.println("The username is already taken!");
        }
    }

    /**
     * Exits the application by setting the 'isRunning' flag to false.
     */
    public static void onExit(){
        isRunning = false;
    }
}
