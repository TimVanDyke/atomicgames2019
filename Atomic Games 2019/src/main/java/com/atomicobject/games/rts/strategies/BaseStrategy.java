package com.atomicobject.games.rts.strategies;

import com.atomicobject.games.rts.communication.AICommand;
import com.atomicobject.games.rts.mapping.Pathfinder;
import com.atomicobject.games.rts.state.GameStateManager;
import com.atomicobject.games.rts.state.Map;
import com.atomicobject.games.rts.state.MapDirections;
import com.atomicobject.games.rts.state.MapDirections.Direction;
import com.atomicobject.games.rts.state.Unit;
import com.atomicobject.games.rts.state.UnitManager;
import com.atomicobject.games.rts.updates.Location;

public class BaseStrategy implements IUnitStrategy {
	Pathfinder finder;
    public BaseStrategy(Unit unit, UnitManager unitManager) {
    }

    public AICommand buildCommand(Unit unit) {
        int resourceCount = unit.getAvailableResources();
        
        
        return null;
//        if (resourceCount > 0) { 
//            return AICommand.buildUnitCommand("tank");
//        }
//        else {
//        	return null;
//        }
    }

}