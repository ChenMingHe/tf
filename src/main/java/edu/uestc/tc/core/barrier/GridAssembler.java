package edu.uestc.tc.core.barrier;

import edu.uestc.tc.beans.gridimpl.*;
import edu.uestc.tc.beans.UnitGrid;
import edu.uestc.tc.beans.VehicleInfo;
import edu.uestc.tc.beans.gridimpl.ArrayGrid;


/**
 * 装配器，实现车辆移动数据到网格的装配操作
 * @author MingHe
 * 
 */
public final class GridAssembler {
	/**
	 * 
	 * @param grid 
	 * @param info
	 */
	public static void assembler(ArrayGrid grid, VehicleInfo info) {
		int normalizedLong = (info.getiLong() - grid.getLowestLong())
				/ grid.getNormalizedLongPara();
		int normalizedLat = (info.getiLat() - grid.getLowestLat())
				/ grid.getNormalizedLatPara();
		if (grid.getUnitArray()[normalizedLat][normalizedLong] == null) {
			UnitGrid unitGrid = new UnitGrid();
			unitGrid.setNormallizedLat(normalizedLat);
			unitGrid.setNormallizedLong(normalizedLong);	
			unitGrid.push(info);
			grid.getUnitArray()[normalizedLat][normalizedLong] = unitGrid;
			grid.push(unitGrid);
		} else {
			grid.getUnitArray()[normalizedLat][normalizedLong].push(info);
		}
	}
}
