import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Random;

public class Hunter extends Critter {

	private Actor target;
	private ArrayList<Location> moves;

	public Hunter(Actor target) {
		this.target = target;
		this.moves = new ArrayList<Location>();
	}

	public void processActors(ArrayList<Actor> actors) {
    	if (actors.contains(this.target)) {
    		this.target.removeSelfFromGrid();
            this.moves = new ArrayList<Location>();
    		return;
    	}
    }

    public ArrayList<Location> getMoveLocations() {

    	ArrayList<Location> locs = new ArrayList<Location>();

    	locs.add(getLocation());

    	if (target == null) {
    		return locs;
    	}

    	int dir = getLocation().getDirectionToward(this.target.getLocation());
    	Location l = getLocation().getAdjacentLocation(dir);

    	if (l.isValid() && getGrid().getEmptyAdjacentLocations().contains(l)) {
    		
    	}
    }
}