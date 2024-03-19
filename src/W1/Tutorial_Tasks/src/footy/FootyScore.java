package W1.Tutorial_Tasks.src.footy;

/**
 * This class provides an implementation for the FootyScore class.
 */
public class FootyScore {
    // Define necessary attributes
    private int behinds;
    private int goals;

    /**
     * Calculates the total score of the given team based on the number
     * of behinds and goals.
     * @return the number of points the Footy team has scored.
     */
    public int getPoints(){
        int POINTS_PER_BEHIND = 6;
        int POINTS_PER_GOAL = 1;
        return (behinds * POINTS_PER_BEHIND) + (goals * POINTS_PER_GOAL);
    }

    /**
     * Increments the goal count by one.
     */
    public void kickGoal(){
        goals++;
    }

    /**
     * Increments the behind count by one.
     */
    public void kickBehind(){
        behinds++;
    }

    /**
     * Returns a string which depicts the format typical of an AFL game.
     * The format is, the number of goals kicked, behinds kicked and points earned.
     * @return a string representing the football score.
     */
    public String sayScore(){
        return Integer.toString(goals) + ", " +
                Integer.toString(behinds) + ", " +
                getPoints();
    }

    /**
     * This determines whether the enemy team is ahead or not.
     * @param otherTeam the enemy team to compare the score against.
     * @return a Boolean representing whether this team is ahead of the enemy team.
     */
    public boolean inFrontOf(FootyScore otherTeam){
        return getPoints() > otherTeam.getPoints();
    }
}
