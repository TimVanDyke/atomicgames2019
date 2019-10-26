package com.atomicobject.games.rts.strategies;

import com.atomicobject.games.rts.communication.AICommand;
import com.atomicobject.games.rts.mapping.Pathfinder;
import com.atomicobject.games.rts.state.Map;
import com.atomicobject.games.rts.state.MapDirections;
import com.atomicobject.games.rts.state.MapDirections.Direction;
import com.atomicobject.games.rts.state.Unit;
import com.atomicobject.games.rts.state.UnitManager;
import com.atomicobject.games.rts.updates.Location;

public class TankStrategy implements IUnitStrategy {

	Map map;
	Pathfinder finder;

	int counter = 0;
	
	public TankStrategy(Map map, Unit unit, UnitManager unitManager) {
		finder = new Pathfinder(map);
		this.map = map;
	}

	public AICommand buildCommand(Unit unit) {

//		if (counter == 0) {
//			counter++;
//			return AICommand.buildMoveCommand(unit, MapDirections.Direction.NORTH);
//		}
		
		if (map.hasEnemies()) {
			var enemies = map.enemyLocationsInRange(unit.getLocation(), 2);
			if (!enemies.isEmpty()) {
				return AICommand.buildShootCommand(unit, enemies.get(0));
			}
		}

		return null;
	}

}