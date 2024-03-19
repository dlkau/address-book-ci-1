package W1.Tutorial_Tasks.src.shapes;

public class ShapeHandler {

    /**
     * Returns the sum of the surface areas for the given shapes.
     * @param shapes the shapes to have their surface area summed.
     * @return the total surface area of the shapes.
     */
    public static double surfaceAreaSum(Shape[] shapes){
        double sum = 0;
        for (Shape shape : shapes){
            sum += shape.surfaceArea();
        }
        return sum;
    }

    /**
     * Returns the sum of the volume for the given shapes.
     * @param shapes the shapes to have their volume summed.
     * @return the total volume area of the shapes.
     */
    public static double volumeSum(Shape[] shapes){
        double sum = 0;
        for (Shape shape : shapes){
            sum += shape.volume();
        }
        return sum;
    }

    public static void main(String[] args){
        // Define some shapes
        Shape[] shapeArr = {new Cube(5), new Tetrahedron(10)};
        // Print the total surface area sum
        System.out.println("The surface area sum of the shape array is: " + surfaceAreaSum(shapeArr));
        // Print the total volume sum
        System.out.println("The volume sum of the shape array is: " + volumeSum(shapeArr));
    }
}