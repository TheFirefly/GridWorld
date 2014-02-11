import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import java.awt.Color;

import java.util.ArrayList;

public class KingCrab extends CrabCritter {

	public void processActors(ArrayList<Actor> actors) {
        for (Actor a : actors)
        {
            if (a instanceof Rock || a instanceof Flower) {
            	a.removeSelfFromGrid();
            } else {
            	Location away = a.getLocation().getAdjacentLocation(a.getLocation().getDirectionToward(getLocation()) + 180);

            	if (away != null && getGrid().isValid(away) && !getGrid().getOccupiedLocations().contains(away)) {
            		a.moveTo(away);
            	} else {
            		a.removeSelfFromGrid();
            	}
            }
        }
    }
}