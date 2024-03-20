package W2.Tutorial_Tasks;

/**
 * This class provides the attribute and method definitions for a ToDoItem object.
 */
public class ToDoItem {
    private String description;
    private boolean isDone;

    // TODO Now:
    // Add a constructor to initialise the item with a description, amd isDone as false, with a single parameter for the
    // description
    // Add the getters and setters for each field

    /**
     * This constructor is used to instantiate a new ToDoItem object.
     * @param description The description attached ot the toDoItem.
     */
    public ToDoItem(String description){
        this.description = description;
        this.isDone = false;
    }

    /**
     * This getter is used ot retrieve the description ascribed to the ToDoItem object.
     * @return the object's "toDoItem" description.
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * This setter is used to update the the description of the ToDoItem object.
     * @param val The value which will replace the item's description.
     */
    public void setDescription(String val){
        this.description = val;
    }

    /**
     * This getter is used to retrieve the completion status for the ToDoItem.
     * @return a Boolean value indicating whether the item has been completed.
     */
    public boolean isDone(){
        return this.isDone;
    }

    /**
     * This setter is used to update the done status of this ToDoItem.
     * @param val the value to update the status with.
     */
    public void setDoneStatus(boolean val){
        this.isDone = val;
    }
}