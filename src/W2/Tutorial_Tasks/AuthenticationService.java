package W2.Tutorial_Tasks;

import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService{
    private ArrayList<User> users;

    // TODO Now: Add a constructor to initialise the users list with the default user

    // TODO Now: Implement the signUp method to add a new user to the list if the username is not take and return
    // the user; return null otherwise.

    // TODO Now: Implement the logIn method to return the suer if the username and password match, and null otherwise

    /**
     * This constructor, given a userList, instantiates a new AuthenticationService object.
     * @param userList The list of users to be included in the AuthenticationServices object.
     */
    public AuthenticationService(ArrayList<User> userList){
        this.users = userList;
        // Add a default user to the list
        this.users.add(new User("DefaultUserTest", "DefaultUserTest"));
    }

    /**
     * Determines whether the given username is available and will add it to the user list based on the
     * input provided if it is.
     * @param username the username of the prospective user.
     * @param password the password of the prospective user.
     * @return The new user, or null (if the prospective username was already in use).
     */
    @Override
    public User signUp(String username, String password){
        for(User currUser : users){
            if (currUser.getUsername().equals(username)){
                return null;
            }
        }
        // Create a new user
        User newUser = new User(username, password);
        this.users.add(newUser);
        return newUser;
    }

    /***
     * Provides an implementation for accessing a user object based on whether the
     * username and password parameters are correct.
     * @param username the username to be authenticated.
     * @param password the password of the associated username to be authenticated.
     * @return the user if the username and password are correct, otherwise null.
     */
    @Override
    public User logIn(String username, String password){
        // Find the username in the list
        for (User user : users){
            if (user.getUsername().equals(username) &&
            user.getPassword().equals(password)){
                return user;
            }
        }
        System.out.println("Invalid username or password. Please try again.");
        return null;
    }
}
