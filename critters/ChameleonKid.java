import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter {
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = new ArrayList<Actor>();

		Actor a = null;
		Actor b = null;

		Location north = getLocation().getAdjacentLocation(getDirection());
		Location south = getLocation().getAdjacentLocation(getDirection() + 180);

		if (getGrid().isValid(north)) {
			a = getGrid().get(north);
		}

		if (a != null) {
			actors.add(a);
		}

		if (getGrid().isValid(south)) {
			b = getGrid().get(south);
		}
		
		if (b != null) {
			actors.add(b);
		}

        return actors;
    }
}