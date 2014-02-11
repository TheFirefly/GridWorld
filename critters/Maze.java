import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.Random;

public class Maze {
	int start, end;
	Random rand = new Random();
	private BoundedGrid<Actor> maze;
	
	Maze(int row, int col) {
		if (row < 3) row = 3;
		if (col < 3) col = 3;
		
		if (row % 2 == 0) row += 1;
		if (col % 2 == 0) col += 1;
		
		maze = new BoundedGrid<Actor>(row, col);
		
		for (int r = 0; r < row; r++)
			for (int c = 0; c < col; c++)
				maze.put(new Location(r, c), new Rock());
		
		maze.remove(new Location(1, 1));
		generate(1, 1);
		
		do {
			start = rand.nextInt(row - 2) + 1;
		} while (maze.get(new Location(start, 1)) instanceof Rock);
		maze.remove(new Location(start, 0));
		
		do {
			end = rand.nextInt(row - 2) + 1;
		} while (maze.get(new Location(end, col - 2)) instanceof Rock);
		maze.remove(new Location(end, col - 1));
		
		System.out.print(toString());
	}
	
	BoundedGrid<Actor> getGrid() { return maze; }

	Location getExit() { return new Location(end,maze.getNumCols() - 1); }
	Location getStart() { return new Location(start,0); }
	
	private int[] swap(int[] array) {
		int to, from, temp;
		
		for (int i = 0; i < 10; i++) {
			to = rand.nextInt(4);
			from = rand.nextInt(4);
			
			temp = array[from];
			array[from] = array[to];
			array[to] = temp;
		}
		
		return array;
	}
	
	private void generate(int row, int col) {
		int[] dirs = swap(new int[] { Location.NORTH, Location.SOUTH, Location.EAST, Location.WEST });
		
		for (int i = 0; i < 4; i++) {
			switch(dirs[i]) {
			case Location.NORTH:
				if (maze.isValid(new Location(row - 2, col)) &&	maze.get(new Location(row - 2, col)) instanceof Rock) {
					maze.remove(new Location(row - 1, col));
					maze.remove(new Location(row - 2, col));
					generate(row - 2, col);
					row -= 2;
				}
				break;
			case Location.SOUTH:
				if (maze.isValid(new Location(row + 2, col)) &&	maze.get(new Location(row + 2, col)) instanceof Rock) {
					maze.remove(new Location(row + 1, col));
					maze.remove(new Location(row + 2, col));
					generate(row + 2, col);
					row += 2;
				}
				break;
			case Location.EAST:
				if (maze.isValid(new Location(row, col + 2)) &&	maze.get(new Location(row, col + 2)) instanceof Rock) {
					maze.remove(new Location(row, col + 1));
					maze.remove(new Location(row, col + 2));
					generate(row, col + 2);
					col += 2;
				}
				break;
			case Location.WEST:
				if (maze.isValid(new Location(row, col - 2)) &&	maze.get(new Location(row, col - 2)) instanceof Rock) {
					maze.remove(new Location(row, col - 1));
					maze.remove(new Location(row, col - 2));
					generate(row, col - 2);
					col -= 2;
				}
				break;
			}
		}
	}
}