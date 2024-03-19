package W1.Tutorial_Tasks.src.shapes;

/**
 * This Cylinder class provides an implementation for the
 * Cylinder object which inherits from Shape.
 */
public class Cylinder implements Shape{
    // Define Cylinder attributes
    private double height;
    private double radius;

    /**
     * This constructor allows a Cylinder object to be instantiated.
     * @param height the height of the cylinder.
     * @param radius the radius of the cylinder.
     */
    public Cylinder(double height, double radius){
        this.height = height;
        this.radius = radius;
    }

    /**
     * This method calculates the surface area of the cylinder.
     * @return the surface area of the cylinder.
     */
    @Override
    public double surfaceArea(){
        return (2 * Math.PI * radius * height) +
                (2 * Math.PI * Math.pow(radius, 2));
    }

    /**
     * This method calculates the volume of the given cylinder.
     * @return the volume of the cylinder.
     */
    @Override
    public double volume(){
        return (Math.PI * Math.pow(radius, 2) * height);
    }
}