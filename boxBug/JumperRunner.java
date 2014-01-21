import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.util.Random;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import java.awt.Color;
import info.gridworld.actor.*;

public class JumperRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
        world.add(alice);
        Rock r = new Rock();
        world.add(r);
        world.show();
    }
}