package W1.Tutorial_Tasks.src.shapes;

/**
 * This Tetrahedron class provides an implementation for the
 * Tetrahedron object which inherits from Shape.
 */
public class Tetrahedron implements Shape{
    // Define Tetrahedron attributes
    private double edge;

    /**
     * This constructor instantiates a new tetrahedron object.
     * @param edge the side length of the tetrahedron object.
     */
    public Tetrahedron(double edge){
        this.edge = edge;
    }

    /**
     * Calculates the volume of the tetrahedron.
     * @return the volume of the given tetrahedron.
     */
    public double volume(){
        return Math.pow(edge,3)/(6.0*Math.sqrt(2));
    }

    /**
     * Calculates the surface area of the tetrahedron.
     * @return the surface area of the given tetrahedron.
     */
    public double surfaceArea(){
        return Math.sqrt(3) * Math.pow(edge, 2);
    }
}
