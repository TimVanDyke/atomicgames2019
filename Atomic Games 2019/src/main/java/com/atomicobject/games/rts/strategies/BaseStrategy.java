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

	int scoutCounter = 0;
	int tankCounter = 0;
	int workerCounter = 0;

	public BaseStrategy(Unit unit, UnitManager unitManager) {
	}

	public AICommand buildCommand(Unit unit) {

		if (scoutCounter < 3) {
			scoutCounter++;
			return AICommand.buildUnitCommand("scout");
		} else if (workerCounter < 12) {
			workerCounter++;
			return AICommand.buildUnitCommand("worker");
		} else if (tankCounter < 4) {
			tankCounter++;
			return AICommand.buildUnitCommand("tank");
		} else {
			return null;
		}
	}

}