package W1.Tutorial_Tasks.src.shapes;

/**
 * This Cube class provides an implementation for the
 * Cube object which inherits from Shape.
 */
public class Cube implements Shape {
    // Define Cube attributes
    private double edge;

    /**
     * Define a constructor to instantiate a Cube object.
     * @param edge The cube edge length.
     */
    public Cube(double edge){
        this.edge = edge;
    }

    /**
     * This method calculates the area of the Cube object.
     * @return the surface area of the cube.
     */
    @Override
    public double surfaceArea(){
        return 6 * Math.pow(edge, 2);
    }

    /**
     * This method calculates the volume of the Cube object.
     * @return the volume of the cube.
     */
    @Override
    public double volume(){
        return Math.pow(edge, 3);
    }
}