import info.gridworld.actor.Bug;

public class CircleBug extends Bug {

	private int sideLength;
	private int steps;

	public CircleBug(int length) {
		this.steps = 0;
		this.sideLength = length;
	}

	@Override
	public void act() {
		if (this.steps < this.sideLength) {
			move();
			this.steps++;
		} else {
			turn();
			this.steps = 0;
		}
	}
}