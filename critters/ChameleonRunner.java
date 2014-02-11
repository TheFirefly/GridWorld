/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains chameleon critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class ChameleonRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(1, 3), new Rock());
        world.add(new Location(1, 2), new Rock());
        world.add(new Location(1, 1), new Rock());
        world.add(new Location(2, 1), new Rock());
        world.add(new Location(4, 1), new Rock());
        world.add(new Location(5, 1), new Rock());
        world.add(new Location(7, 1), new Rock());
        world.add(new Location(8, 1), new Rock());
        world.add(new Location(8, 0), new Rock());
        world.add(new Location(2, 3), new Rock());
        world.add(new Location(3, 3), new Rock());
        world.add(new Location(3, 5), new Rock());
        world.add(new Location(5, 3), new Rock());
        world.add(new Location(5, 4), new Rock());
        world.add(new Location(5, 5), new Rock());
        world.add(new Location(4, 3), new Rock());
        world.add(new Location(4, 5), new Rock());
        world.add(new Location(0, 5), new Rock());
        world.add(new Location(1, 5), new Rock());
        world.add(new Location(2, 5), new Rock());
        world.add(new Location(5, 2), new Rock());
        world.add(new Location(7, 7), new Rock());
        world.add(new Location(6, 7), new Rock());
        world.add(new Location(5, 7), new Rock());
        world.add(new Location(3, 7), new Rock());
        world.add(new Location(2, 7), new Rock());
        world.add(new Location(1, 7), new Rock());
        world.add(new Location(3, 8), new Rock());
        world.add(new Location(3, 9), new Rock());
        world.add(new Location(7, 2), new Rock());
        world.add(new Location(7, 3), new Rock());
        world.add(new Location(7, 4), new Rock());
        world.add(new Location(7, 5), new Rock());
        world.add(new Location(7, 6), new Rock());
        world.add(new Location(5, 8), new Rock());
        world.add(new Location(5, 9), new Rock());
        ChameleonCritter c = new ChameleonCritter();
        world.add(new Location(0, 8), c);
        world.add(new Location(4, 4), new CritterHunter(c));
        //world.add(new Location(5, 8), new ChameleonCritter());
        world.show();
    }
}