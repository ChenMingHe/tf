package edu.uestc.tc.core.barrier;


import edu.uestc.tc.beans.gridimpl.*;
import edu.uestc.tc.beans.VehicleInfo;
import edu.uestc.tc.core.VehicleInfoHandler;

/**
 * 屏障层，用网格来存储一段时间的数据，每个网格中的小网格按区域位置进行划分
 * 
 */
public class Barrier implements VehicleInfoHandler {

	private HourGlass hourGlass = null;
	int rangeTag;
	private GridStrategy[] strategyArray = null;
	private ArrayGrid grid = null;

	public int getRangeTag() {
		return rangeTag;
	}

	public void handle(VehicleInfo info) {
		/*
		 * 将info递交给沙漏进行处理，返回区间标识 调用区间标识对应的处理函数进行处理。
		 */
		assert (strategyArray != null);
		rangeTag = hourGlass.timerInterval(info);
		grid = strategyArray[rangeTag].execute();
		if (grid == null) {
			return;
			
		}
		GridAssembler.assembler(grid, info);
	}

	public ArrayGrid getGrid() {
		return grid;
	}

	public void setHourGlass(HourGlass hourGlass) {
		this.hourGlass = hourGlass;
	}

	public void setStrategyArray(GridStrategy strategyArray[]) {
		this.strategyArray = strategyArray;
	}

}
