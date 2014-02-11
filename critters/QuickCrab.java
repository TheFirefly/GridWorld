import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import java.awt.Color;

import java.util.ArrayList;

public class QuickCrab extends CrabCritter {

	public ArrayList<Location> getMoveLocations() {
        ArrayList<Location> locs = new ArrayList<Location>();
        int leftDir = getDirection() - 90;
        int rightDir = getDirection() + 90;
        Location left = getLocation().getAdjacentLocation(leftDir);
        Location right = getLocation().getAdjacentLocation(rightDir);

        if (left != null && getGrid().isValid(left)) {
        	Location fLeft = left.getAdjacentLocation(leftDir);

        	if (fLeft != null && getGrid().isValid(fLeft)) {
        		locs.add(fLeft);
        	}
        }

        if (right != null && getGrid().isValid(right)) {
        	Location fRight = right.getAdjacentLocation(rightDir);

        	if (fRight != null && getGrid().isValid(fRight)) {
        		locs.add(fRight);
        	}
        }

        return locs;
    }

    public void makeMove(Location loc) {
    	Location inter = loc.getAdjacentLocation(loc.getDirectionToward(getLocation())); //Gets the space in between the move location and the Crab
    	Grid g = getGrid();

		if (g.getOccupiedLocations().contains(loc) || g.getOccupiedLocations().contains(inter)) {
			//One of the 2 spaces are occupied
			super.makeMove(getLocation());
		} else {
			moveTo(loc);
		}
    }
}