package W2.Tutorial_Tasks;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    // Add necessary attributes
    private String username;
    private String password;
    private ArrayList<ToDoItem> toDoItems;

    /**
     * This method instantiates a new user object.
     * @param username the username of the user.
     * @param password the password of the user.
     */
    public User(String username, String password){
        this.password = password;
        this.username = username;
        this.toDoItems = new ArrayList<>();
    }

    /**
     * Gets the username of the user.
     * @return the username of the user.
     */
    public String getUsername(){
        return username;
    }

    /**
     * Gets the password of the user.
     * @return the password of the user.
     */
    public String getPassword(){
        return password;
    }

    /**
     * Sets the username of the user.
     * @param username The username set.
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * Sets the password of the user.
     * @param password The password to be set.
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * This method gets the to-do items of the user.
     * @return A reference to the list of to-do items, which can be modified outside the class.
     */
    public ArrayList<ToDoItem> getToDoItems(){
        return toDoItems;
    }
}