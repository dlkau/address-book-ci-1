package W1.Reading_Tasks.models;

public class Person {
    // The name attribute is private, so it cannot be accessed from outside
    // the class.
    private String name;

    /**
     * A default constructor for the Person class.
     */
    public Person(){
    }

    /**
     * This is an overloaded constructor for the person class.
     * @param name the name to be assigned to the Person object.
     */
    public Person(String name){
        setName(name);
    }

    /**
     * This is a getter method which returns the name attribute.
     * @return the name of the attribute.
     */
    public String getName(){
        return name;
    }

    /**
     * This is a setter for the name attribute which includes validation,
     * to ensure the name parameter is not empty.
     * @param name the new name to set the name attribute to.
     */
    public void setName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
}
