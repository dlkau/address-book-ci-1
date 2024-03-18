package W1.Reading_Tasks.models;

/**
 * The Student class inherits the attributes and methods of the
 * Person class.
 */
public class Student extends Person {
    // The Student class can add new attributes and methods
    private String[] courses;

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
        // Add the course to the courses array with
        // some validation
    }
}
