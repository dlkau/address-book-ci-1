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

        /// Demonstrating polymorphism
        // Equivalently, we can use the constructor method
        Person person2 = new Person("John Doe");
        System.out.println(person2.getName());

        // TESTING CODE FOR THE addCourse METHOD IMPLEMENTATION
        /*
        // Create an array of courses
        String[] myArr = {"Course 1", "Course 2"};
        // Create a student with a name and the courses
        Student per = new Student("bob", myArr);
        // Retrieve and print each course the student is currently enrolled in
        String[] arr = per.getCourses();
        for(String val : arr){
            System.out.println(val);
        }
        // Test the addCourse implementation by adding a new course
        per.addCourse("Course 3 (new)");
        // Return each of the courses to test the implementation
        arr = per.getCourses();
        for(String val : arr){
            System.out.println(val);
        }
        */

        // Demonstrating the concept of polymorphism
        System.out.println("Testing the concept of polymorphism from here:\n");
        Person person3 = new Person("John Doe");
        System.out.println(person3.getName()); // This should print "John Doe"
        Person student = new Student("John Doe", new String[] {"Math", "Science"});
        System.out.println(student.getName()); // This should print "Student: John Doe"
    }
}
