package com.atomicobject.games.rts.strategies;

import com.atomicobject.games.rts.communication.AICommand;
import com.atomicobject.games.rts.mapping.Pathfinder;
import com.atomicobject.games.rts.state.Map;
import com.atomicobject.games.rts.state.MapDirections;
import com.atomicobject.games.rts.state.MapDirections.Direction;
import com.atomicobject.games.rts.state.Tile;
import com.atomicobject.games.rts.state.Unit;
import com.atomicobject.games.rts.state.UnitManager;
import com.atomicobject.games.rts.updates.Location;

public class WorkerStrategy implements IUnitStrategy {
	Pathfinder finder;

	Map map;

	public WorkerStrategy(Map map, Unit unit, UnitManager unitManager) {
		finder = new Pathfinder(map);
		this.map = map;
	}

	public AICommand buildCommand(Unit unit) {
		// MapDirections.cardinalDirection(unit.getLocation(), ourDestination)
		var direction = MapDirections.randomDirection();

		if (unit.isCarryingResource()) {
			return AICommand.buildMoveCommand(unit,
					MapDirections.cardinalDirection(unit.getLocation(), map.homeBaseLocation()));
		} else {
			boolean resourcesByMe = false;
			var myNeighbors = map.neighbors(unit.getLocation());
			// myNeighbors.
			int x = unit.getLocation().getX();
			int y = unit.getLocation().getY();
			Tile left = map.getTile(new Location(x + 1, y));
			Tile right = map.getTile(new Location(x - 1, y));
			Tile up = map.getTile(new Location(x, y + 1));
			Tile down = map.getTile(new Location(x, y - 1));

//			for (int i = 0; i < myNeighbors.size(); i++) {
//				if (myNeighbors.get(i).hasResource()) {
//					System.out.println("This is our log" + i);
//					resourcesByMe = true;
//				}
//			}

			if (left.hasResource()) {
				System.out.println("This is our log" + 1);
				resourcesByMe = true;
			} else if (right.hasResource()) {
				System.out.println("This is our log" + 3);
				resourcesByMe = true;
			} else if (up.hasResource()) {
				System.out.println("This is our log" + 5);
				resourcesByMe = true;
			} else if (down.hasResource()) {
				System.out.println("This is our log" + 7);
				resourcesByMe = true;
			}

			if (resourcesByMe) {
				return AICommand.buildGatherCommand(unit, map.directionToAdjacentResource(unit.getLocation()));
			} else {
				var resourceTiles = map.resourceLocationsNearest(unit.getLocation());

				var destination = unit.getLocation();
				if (!resourceTiles.isEmpty()) {
					destination = resourceTiles.get(0);
					System.out.println("WE GOT THIS FAR");
					
					System.out.println(finder.findPath(unit.getLocation(), resourceTiles.get(0), 1));

					if (finder.findPath(unit.getLocation(), resourceTiles.get(0), 1) != null) {
						System.out.println(finder.findPath(unit.getLocation(), resourceTiles.get(0), 1).toString());
						direction = MapDirections.cardinalDirection(unit.getLocation(), destination);						
						
					}
				}
			}
		}
		return AICommand.buildMoveCommand(unit, direction);
	}

}