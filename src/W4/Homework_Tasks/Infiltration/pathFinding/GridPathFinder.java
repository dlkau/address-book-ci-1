package W4.Homework_Tasks.Infiltration.pathFinding;

import W4.Homework_Tasks.Infiltration.common.Location;

/**
 * An interface used to represent the different path finding algorithms.
 */
public interface GridPathFinder {

    /**
     * This method returns the path from the start location to the end location.
     * @param startLocation the start location.
     * @param endLocation the end location.
     * @return This method returns the path from the start location to the end location.
     */
    Path findPath(Location startLocation, Location endLocation);

    /**
     * This returns the neighbours which can be traversed to from a given location.
     * @param location the location which the neighbours need to sought from.
     * @return the neighbours of a given location.
     */
    Iterable<Location> getNeighbors(Location location);
}
