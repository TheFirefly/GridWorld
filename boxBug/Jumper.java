import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

public class Jumper extends Actor {

	public Jumper() {
		setColor(Color.RED);
	}

	public Jumper(Color color) {
		setColor(color);
	}

	public void act() {
		if (canMove()) {
			move();
		} else {
			turn();
		}
	}

	public void move() {
		Grid<Actor> gr = getGrid();
        
        if (gr == null) {
            return;
        }

        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection()); //Location 1 space ahead
        if (next == null || !gr.isValid(next)) {
            return;
        }
        Location next2 = next.getAdjacentLocation(getDirection()); //Location 2 spaces ahead
        if (gr.isValid(next2)) { //If 2 spaces in front is valid, then the one directly in front is valid
            moveTo(next2); //Move 2 spaces
        }
        else {
            removeSelfFromGrid();
        }

        if (gr.get(next) instanceof Actor) { //If it jumped an actor, it won't place flowers
        	return;
        }

        //Place flowers otherwise

        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
        Flower flower2 = new Flower(getColor());
        flower2.putSelfInGrid(gr, next);
	}

	public boolean canMove() {
		Grid<Actor> gr = getGrid();
        if (gr == null) {
            return false;
        }

        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location next2 = next.getAdjacentLocation(getDirection());

        //Checks that both locations in front are valid as well as checks that its current destination is not occupied by rocks or other Actors (but not flowers)
        if (!gr.isValid(next) || !gr.isValid(next2) || gr.get(next2) instanceof Rock || (gr.get(next2) instanceof Actor && !(gr.get(next2) instanceof Flower))) {
			return false;	
        }
        Actor neighbor = gr.get(next);
        return true;
	}

    public void turn() {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }
}