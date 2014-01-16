import info.gridworld.actor.Bug;

public class DancingBug extends Bug {

	private int[] turns;
	private int turnIndex = 0;

	public DancingBug(int[] turns) {
		this.turns = turns;

	}

	@Override
	public void act() {
		if (turnIndex < turns.length - 1) {
			turnIndex++;
		} else {
			turnIndex = 0;
		}
		for (int i = 0 ; i < this.turns[this.turnIndex] ; i++) {
			turn();
		}
		super.act();
	}
}