package W2.Tutorial_Tasks;

import java.util.Scanner;

/**
 * The following class declaration provides the implementation details associated with a
 * ToDoList object.
 */
public class ToDoList {
    private User user;
    private boolean isRunning;

    /**
     * This constructor initialises a ToDoList object.
     * @param user The user of the ToDoList.
     */
    public ToDoList(User user){
        this.user = user;
        this.isRunning = true;
    }

    /**
     * This method displays the main menu options to the user.
     */
    public void showMenu(){
        System.out.println("1. Show all items");
        System.out.println("2. Add an item");
        System.out.println("3. Mark an item as done");
        System.out.println("4 Mark an item as undone");
        System.out.println("5 Delete an item");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    /**
     * Loops the showMenu method base don whether the
     * 'isRunning' flag is still true.
     */
    public void run(){
        while (isRunning){
            showMenu();
        }
    }

    /**
     * This method handles the different choices the user has, associating the menu options
     * with the relevant methods.
     * @param choice the operation the user wishes to perform.
     */
    public void handleMenu(int choice){
        switch (choice){
            case 1:
                onShowAllItems();
                break;
            case 2:
                onAddItem();
                break;
            case 3:
                onMarkAsDone();
                break;
            case 4:
                onMarkAsUndone();
                break;
            case 5:
                onDeleteItem();
                break;
            case 6:
                onExit();
                break;
            default:
                System.out.println("Invalid choice!");
                showMenu();
        }
    }

    /**
     * This method displays all the items that are currently in the list.
     */
    public void onShowAllItems(){
        for(int i = 0; i < user.getToDoItems().size(); i++){
            ToDoItem item = user.getToDoItems().get(i);
            if (item.isDone()){
                System.out.println(i + ". [X] " + item.getDescription());
            } else {
                System.out.println(i + ". [ ] " + item.getDescription());
            }
        }
    }

    /**
     * This allows the user to add a new item description to the list.
     */
    public void onAddItem(){
        System.out.print("Enter the description of the item: ");
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        // TODO Now: Set the isDone field of the item at the specified index to true
        ToDoItem item = new ToDoItem(description);
        this.user.getToDoItems().add(item);
    }

    /**
     * Requests the user for an item number and marks it as done.
     */
    public void onMarkAsDone(){
        onShowAllItems();
        System.out.print("Enter the number of the item to mark as done: ");
        Scanner scanner = new Scanner(System.in);
        int itemNumber = scanner.nextInt();
        // TODO Now: Set the isDone field of the item at the specified index to true
        this.user.getToDoItems().get(itemNumber).setDoneStatus(true);
    }

    /**
     * Requests the user for an item number and marks it as undone.
     */
    public void onMarkAsUndone(){
        onShowAllItems();
        System.out.print("Enter the number of the item you want to mark as undone: ");
        Scanner scanner = new Scanner(System.in);
        int itemNumber = scanner.nextInt();
        // TODO Now: Set the isDone field of the time at the specified index to false
        this.user.getToDoItems().get(itemNumber).setDoneStatus(false);
    }

    /**
     * Requests the user for the index number of the item they would like to remove from
     * the list.
     */
    public void onDeleteItem(){
        onShowAllItems();
        System.out.print("Enter the number of the item to delete: ");
        Scanner scanner = new Scanner(System.in);
        int itemNumber = scanner.nextInt();
        // TODO Now: Remove the item at the specified index from the user's toDo items list
        this.user.getToDoItems().remove(itemNumber);
    }

    /**
     * Exits the application, which sets the 'isRunning' flag to false.
     */
    public void onExit(){
        isRunning = false;
    }
}