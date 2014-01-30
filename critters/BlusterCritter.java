import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class BlusterCritter extends Critter {

	private int c;

	public BlusterCritter(int c) {
		this.c = c;
	}

	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = new ArrayList<Actor>();
		Set<Location> set = new HashSet<Location>();
		Set<Location> set2 = new HashSet<Location>();

		set.addAll(getGrid().getValidAdjacentLocations(getLocation())); //Gets all locations around the BlusterCritter

		for (Location l : set) {
			set2.addAll(getGrid().getValidAdjacentLocations(l)); //Gets all locations around the locations that are around the BlusterCritter
		}

		for (Location s : set) {
			if (actors.contains(getGrid().get(s))) {
				continue;
			}
			actors.add(getGrid().get(s));
		}

		for (Location s2 : set2) {
			if (actors.contains(getGrid().get(s2))) {
				continue;
			}
			actors.add(getGrid().get(s2));
		}

		return actors;
	}

	public void processActors(ArrayList<Actor> actors) {
		int critter = -1; //Accounts for the search method including the BlusterCritter itself
        for (Actor a : actors) {
            if (a != null && a instanceof Critter) {
            	System.out.println(a.getLocation());
            	critter++;
            }
        }

        if (critter < this.c) {
        	Color c = getColor();
            int red = (int) Math.min(255, c.getRed() + 15);
            int green = (int) Math.min(255, c.getGreen() + 15);
            int blue = (int) Math.min(255, c.getBlue() + 15);
            setColor(new Color(red, green, blue));
            return;
        } else {
        	Color c = getColor();
            int red = (int) (c.getRed() * (0.95));
            int green = (int) (c.getGreen() * (0.95));
            int blue = (int) (c.getBlue() * (0.95));
            setColor(new Color(red, green, blue));
            return;
        }
    }
}