package W1.Reading_Tasks.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;

/**
 * The Student class inherits the attributes and methods of the
 * Person class.
 */
public class Student extends Person {
    // The Student class can add new attributes and methods
    private String[] courses = new String[0];

    /**
     * To inherit constructors, it is necessary to define a constructor
     * and use the super keyword to call the superclass constructor.
     * @param name the name for the Student object.
     * @param courses the courses the student is enrolled in.
     */
    public Student(String name, String[] courses){
        super(name);
        for(String course : courses){
            addCourse(course);
        }
    }

    /**
     * If the default constructor is required, then it needs to be
     * redefined.
     */
    public Student(){
        super();
    }

    /**
     * The student class can override existing methods and call the superclass method using the super
     * keyword.
     * @return a string prefixed with "Student:" and the student's name.
     */
    @Override
    public String getName(){
        return "Student: " + super.getName();
    }

    /**
     * The student class can also add new methods.
     * @return the courses the student is enrolled in.
     */
    public String[] getCourses(){
        return courses;
    }

    public void addCourse(String course){
        // Add the course to the courses array with some validation
        if(course.isEmpty()) throw new IllegalArgumentException("The course argument cannot be null");

        // Create a list to store each course in the courses array
        List<String> newList = new ArrayList<>();
        // Add the elements in courses to the new list (as long as it is not empty)
        if(courses.length >= 1){
            // Store each element in the array into the list
            for (String val : courses){
                newList.add(val);
            }
        }
        // Add the new course to the end of the list
        newList.add(course);
        // Create a new array
        String[] arr = new String[newList.size()];
        // Store each value from the list into the array
        for (int i = 0; i < newList.size(); i++){
            arr[i] = newList.get(i);
        }
        // Assign arr to the courses attribute
        this.courses = arr;
    }
}
