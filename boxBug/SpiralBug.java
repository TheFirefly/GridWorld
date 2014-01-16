import info.gridworld.actor.Bug;

public class SpiralBug extends Bug {

	private int sideLength;
	private int steps;

	public SpiralBug(int length) {
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
			turn();
			this.steps = 0;
			this.sideLength++;
		}
	}
}