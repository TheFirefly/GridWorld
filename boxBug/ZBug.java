import info.gridworld.actor.Bug;

public class ZBug extends Bug {

	private int sideLength;
	private int steps;
	private int lines;

	public ZBug(int length) {
		this.steps = 0;
		this.lines = 1;
		this.sideLength = length;
		setDirection(90);

	}

	@Override
	public void act() {
		if (this.steps < this.sideLength) {
			if (canMove() && lines < 4) {
				move();
				this.steps++;
			} else {
				return;
			}
		} else {
			this.lines++;
			if (this.lines == 3) {
				turn();
				turn();
				turn();
				turn();
				turn();
			} else if (this.lines == 4) {
				return;
			} else if (this.lines < 3) {
				turn();
				turn();
				turn();
			}
			this.steps = 0;
		}
	}
}