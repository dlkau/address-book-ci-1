package W2.Tutorial_Tasks;

public class User {
    // Add necessary attributes
    private String username;
    private String password;

    /**
     * This method instantiates a new user object.
     * @param username the username of the user.
     * @param password the password of the user.
     */
    public User(String username, String password){
        this.password = password;
        this.username = username;
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
}
