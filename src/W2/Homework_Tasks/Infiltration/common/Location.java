package W2.Homework_Tasks.Infiltration.common;

import java.util.Objects;

/**
 * The location class is used to represent certain locations on the map
 */
public class Location {
    private final int x;
    private final int y;

    /**
     * This constructor is used to instantiate a new Location object.
     * @param x the x position of the location.
     * @param y the y position of the location.
     */
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * This getter returns the x position of this location.
     * @return the x position of this location.
     */
    public int getX(){
        return this.x;
    }

    /**
     * This getter returns the y position of this location.
     * @return the y position of this location.
     */
    public int getY(){
        return this.y;
    }

    /**
     * This returns whether a location is equal to this location.
     * @param obj the object to be compared against.
     * @return A boolean denoting whether the provided object is equal to this location.
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location location = (Location) obj;
        return  x == location.x && y == location.y;
    }

    /**
     * Returns a hashcode of the given location.
     * @return the hashcode of the given location.
     */
    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }

    /**
     * Returns a string representation of this location.
     * @return a String representation of this location.
     */
    @Override
    public String toString(){
        return "Location{" + "x=" + x + ", y=" + y + '}';
    }

    /**
     * This method, given a string, will instantiate a new location object.
     * @param s The string to parse, in the format "x,y"
     * @return the generated location object parsed from the given string.
     */
    public static Location parse(String s){
        String[] parts = s.split(",");
        return new Location(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }
}
