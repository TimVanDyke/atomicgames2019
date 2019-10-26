package com.atomicobject.games.rts.strategies;

import com.atomicobject.games.rts.communication.AICommand;
import com.atomicobject.games.rts.mapping.Pathfinder;
import com.atomicobject.games.rts.state.Map;
import com.atomicobject.games.rts.state.MapDirections;
import com.atomicobject.games.rts.state.Tile;
import com.atomicobject.games.rts.state.MapDirections.Direction;
import com.atomicobject.games.rts.state.Unit;
import com.atomicobject.games.rts.state.UnitManager;
import com.atomicobject.games.rts.updates.Location;

public class ScoutStrategy implements IUnitStrategy {
	Pathfinder finder;
	Map map;
    public ScoutStrategy(Map map, Unit unit, UnitManager unitManager) {
    	finder = new Pathfinder(map);
    	this.map = map;
    }

    public AICommand buildCommand(Unit unit) {
    	var direction = MapDirections.randomDirection();

		return AICommand.buildMoveCommand(unit, direction);
    }

}