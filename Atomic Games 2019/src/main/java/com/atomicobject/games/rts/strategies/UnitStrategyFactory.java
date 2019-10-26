package com.atomicobject.games.rts.strategies;

import com.atomicobject.games.rts.state.Map;
import com.atomicobject.games.rts.state.Unit;
import com.atomicobject.games.rts.state.UnitManager;

public class UnitStrategyFactory {

    public void assignStrategy(Map map, Unit unit, UnitManager unitManager) {
        if (unit.getStrategy() == null) {
        	if (unit.isWorker()) {
        		unit.setStrategy(buildStrategy(map, unit, unitManager));
        	}
        	else if (unit.isTank()) {
        		unit.setStrategy(buildStrategy(map, unit, unitManager));
        	}
        	else if (unit.isScout()) {
        		unit.setStrategy(buildStrategy(map, unit, unitManager));
        	}
        	else if (unit.isBase()) {
        		unit.setStrategy(buildStrategy(map, unit, unitManager));
        	}
        	else {
        		unit.setStrategy(buildStrategy(map, unit, unitManager));	
        	}
        }
    }

    private IUnitStrategy buildStrategy(Map map, Unit unit, UnitManager unitManager) {
    	if (unit.isWorker()) {
    		return buildWorkerStrategy(map, unit, unitManager);
    	}
    	else if (unit.isTank()) {
    		return buildTankStrategy(map, unit, unitManager);
    	}
    	else if (unit.isScout()) {
    		return buildScoutStrategy(map, unit, unitManager);
    	}
    	else if (unit.isBase()) {
    		return buildBaseStrategy(unit, unitManager);
    	}
    	else {
    		return null;
    	}
//    	if (unit.isMobile()) {
//            return buildExploreStrategy(map, unit, unitManager);
//        }
//        return null;
    }

    private IUnitStrategy buildExploreStrategy(Map map, Unit unit, UnitManager unitManager) {
        return new ExploreStrategy(map, unit, unitManager);
    }
    
    private IUnitStrategy buildWorkerStrategy(Map map, Unit unit, UnitManager unitManager) {
        return new WorkerStrategy(map, unit, unitManager);
    }
    
    private IUnitStrategy buildTankStrategy(Map map, Unit unit, UnitManager unitManager) {
        return new TankStrategy(map, unit, unitManager);
    }
    
    private IUnitStrategy buildScoutStrategy(Map map, Unit unit, UnitManager unitManager) {
        return new ScoutStrategy(map, unit, unitManager);
    }
    
    private IUnitStrategy buildBaseStrategy(Unit unit, UnitManager unitManager) {
        return new BaseStrategy(unit, unitManager);
    }
}
