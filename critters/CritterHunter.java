import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Random;

public class CritterHunter extends Critter {

	private Actor target;
    private Location lastLocation;
    private int iter = 0;
    private int maxIter = 9;
    private int lastDir = 0;
    private int iterInSame = 0;
    private int timesMovedOpp = 0;

	public CritterHunter(Actor target) {
		this.target = target;
        this.lastLocation = getLocation();
	}

    public void processActors(ArrayList<Actor> actors) {
    	if (actors.contains(this.target)) {
    		this.target.removeSelfFromGrid();
            this.target = getNextTarget();
            this.lastLocation = getLocation();
            this.timesMovedOpp = 0;
            this.iterInSame = 0;
            this.iter = 0;
    		return;
    	}
    }

    public Actor getNextTarget() {
        ArrayList<Location> locs = getGrid().getOccupiedLocations();

        for (Location l : locs) {
            if (getGrid().get(l) != null && getGrid().get(l) instanceof Critter && !getGrid().get(l).equals(this)) {
                return getGrid().get(l);
            }
        }

        return null;
    }

    public ArrayList<Location> getMoveLocations() {

    	ArrayList<Location> locs = new ArrayList<Location>();

        if (target == null) {
            return locs;
        }

        int dir = getLocation().getDirectionToward(this.target.getLocation());
        Location l = getLocation().getAdjacentLocation(dir); //Towards target
        boolean isTargetNearPast = getGrid().getValidAdjacentLocations(l).contains(lastLocation);
        boolean ignoreLastLocation = false;

        if (iterInSame > 1) {
            dir += 180;
            isTargetNearPast = false;
            ignoreLastLocation = true;
            timesMovedOpp++;

        }

        //System.out.println(dir);
        
        if (l != null && getGrid().isValid(l) && !getGrid().getOccupiedLocations().contains(l) && !l.equals(this.lastLocation) && !isTargetNearPast) {
        	//can be moved towards
        	locs.add(l);
        } else {
            if (locs.size() == 0) {
                locs.add(getNextLocationAround(ignoreLastLocation));
            } else {
                locs.set(0, getNextLocationAround(ignoreLastLocation));
            }
        }

        return locs;
    }

    public Location getNextLocationAround(boolean ignoreLastLocation) {
        iter++;
        int newDirection = this.lastDir - 45;

        if (newDirection < 0) {
            //reset
            newDirection = 360 - (0 - newDirection);
        }

        Location l = getLocation().getAdjacentLocation(newDirection);

        this.lastDir = newDirection;

        //System.out.println("l: " + l + " lastLoc: " + this.lastLocation + " iter: " + iter);
    
        boolean pastLocCheck = true;
        boolean sameLocCheck = true;
    
        if (ignoreLastLocation) {
            pastLocCheck = true;
            sameLocCheck = true;
        } else {
            sameLocCheck = !l.equals(this.lastLocation);
            pastLocCheck = !getGrid().getValidAdjacentLocations(l).contains(lastLocation);
        }

        if (l != null && getGrid().isValid(l) && !getGrid().getOccupiedLocations().contains(l) && pastLocCheck && (this.lastLocation == null || sameLocCheck)) {
            return l;
        } else {
            if (iter < maxIter) {
                return getNextLocationAround(ignoreLastLocation);
            } else {
                return getLocation();
            }
        }
    }

    public Location selectMoveLocation(ArrayList<Location> locs) {
        if (!locs.isEmpty() && locs.get(0) != null) {
            if (!locs.get(0).equals(getLocation())) {
                this.lastLocation = getLocation();
                if (timesMovedOpp > 1) {
                    timesMovedOpp = 0;
                    iterInSame = 0;
                } else {
                    iterInSame++;
                }
            } else {
                iterInSame++;
            }
            iter = 0;
        	return locs.get(0);
        }

        return getLocation();
    }
}