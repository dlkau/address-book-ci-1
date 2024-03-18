package W1.Reading_Tasks;

// Import a single class
import W1.Reading_Tasks.models.Person;
// Import all classes in the models package
import W1.Reading_Tasks.models.*;

public class Example {
    public static void main(String[] args){
        // Create an empty Person object and use the
        // setter method to set the name.
        Person person = new Person();
        person.setName("John Doe");
        System.out.println(person.getName());

        // Equivalently, we can use the constructor method
        Person person2 = new Person("John Doe");
        System.out.println(person2.getName());
    }
}
