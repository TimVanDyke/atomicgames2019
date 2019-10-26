package com.atomicobject.games.rts.strategies;

import com.atomicobject.games.rts.communication.AICommand;
import com.atomicobject.games.rts.mapping.Pathfinder;
import com.atomicobject.games.rts.state.Map;
import com.atomicobject.games.rts.state.MapDirections;
import com.atomicobject.games.rts.state.MapDirections.Direction;
import com.atomicobject.games.rts.state.Unit;
import com.atomicobject.games.rts.state.UnitManager;
import com.atomicobject.games.rts.updates.Location;

public class ExploreWholeMapStrategy implements IUnitStrategy {
	Pathfinder finder;
    public ExploreWholeMapStrategy(Map map, Unit unit, UnitManager unitManager) {
    	finder = new Pathfinder(map);
    }

    public AICommand buildCommand(Unit unit) {
        var locationList = finder.findPath(unit.getLocation(), new Location(0, -1), 0);
        
        System.out.println(locationList.toString());
        
        Location ourDestination = unit.getLocation();
        if (!locationList.isEmpty()) {
        	ourDestination = locationList.get(0);
        }
        
        var direction = MapDirections.cardinalDirection(unit.getLocation(), ourDestination);
        
        return AICommand.buildMoveCommand(unit, direction);
    }

}