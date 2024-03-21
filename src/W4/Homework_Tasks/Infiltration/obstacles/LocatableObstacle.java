package W4.Homework_Tasks.Infiltration.obstacles;

// Add necessary imports

import W4.Homework_Tasks.Infiltration.common.Location;

/**
 * Provides the base characteristics of an obstacle that can be located on the map.
 */
public abstract class LocatableObstacle implements Obstacle {
    protected final Location location;

    /**
     * This constructor instantiates a new LocatableObject based on the supplied location.
     * @param location the location of the locatable obstacle.
     */
    public LocatableObstacle(Location location){
        this.location = location;
    }

    /**
     * This constructor instantiates a new LocatableObject based on the supplied x and y coordinates.
     * @param x the x coordinate of the LocatableObject.
     * @param y the y coordinate of the LocatableObject.
     */
    public LocatableObstacle(int x, int y){
        this.location = new Location(x, y);
    }

    /**
     * Returns the location of this LocatableObstacle.
     * @return the location of this LocatableObstacle.
     */
    public Location getlocation(){
        return this.location;
    }

    public abstract boolean isLocationObstructed(int x, int y);
    public abstract char getSymbol();
}