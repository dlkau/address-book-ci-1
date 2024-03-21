package W4.Homework_Tasks.Infiltration.obstacles;

import W4.Homework_Tasks.Infiltration.common.*;

/**
 * This class is an additional implementation, which can be used to add walls to the map.
 */
public class Wall extends LocatableObstacle{
    // Define necessary attributes
    private Location diagLim;

    /**
     * This constructor is used to instantiate a new Wall object.
     * @param location this is one diagonal direction from which the wall begins.
     * @param diagLim this is the other diagonal position from which the wall ends.
     */
    public Wall(Location location, Location diagLim){
        super(location);
        this.diagLim = diagLim;
    }

    /**
     * This determines whether the given location is obstructed, namely when referring to a location
     * where a Wall may preside.
     * @param x The x coordinate of the location.
     * @param y The y coordinate of the location.
     * @return a Boolean value dictating whether the location is obstructed or not.
     */
    @Override
    public boolean isLocationObstructed(int x, int y){
        // Find the lower and upper bound of x
        int lowerBoundXPos = Math.min(this.diagLim.getX(), this.location.getX());
        int upperBoundXPos = Math.max(this.diagLim.getX(), this.location.getX());
        // Find the lower and upper bound of y
        int lowerBoundYPos = Math.min(this.diagLim.getY(), this.location.getY());
        int upperBoundYPos = Math.max(this.diagLim.getY(), this.location.getY());
        if (x >= lowerBoundXPos && x <= upperBoundXPos){
            // If successful, check to see if y lies between the lower and upperbound.
            return y >= lowerBoundYPos && y <= upperBoundYPos;
        }
        // Return false if the location turns out not to be obstructed.
        return  false;
    }

    /**
     * This is used to get the symbol for the wall object.
     * @return the character symbol  for a wall object.
     */
    @Override
    public char getSymbol(){
        return ObstacleType.WALL.getSymbol();
    }

    /**
     * This static method is used to create a new Wall object from a string argument
     * @param arg The string argument with the required information to create a Wall object
     * @return the wall object with the specified characteristics
     */
    public static Wall parse(String arg){
        // Need to process the string and perform validation
        String[] separatedArgs = arg.split(",");
        if (separatedArgs.length != 4){
            throw new IllegalStateException("The provide argument requires 4 inputs.");
        }
        else {
            // Process the two locations
            int xPos1 = Integer.parseInt(separatedArgs[0]);
            int yPos1 = Integer.parseInt(separatedArgs[1]);
            int xPos2 = Integer.parseInt(separatedArgs[2]);
            int yPos2 = Integer.parseInt(separatedArgs[3]);

            // Create a loc object
            Location wallLoc1 = new Location(xPos1, yPos1);
            Location wallLoc2 = new Location(xPos2, yPos2);
            return new Wall(wallLoc1, wallLoc2);
        }
    }
}