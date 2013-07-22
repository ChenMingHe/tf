package edu.uestc.tc.core.barrier.strategyimpl;

import edu.uestc.tc.beans.gridimpl.*;
import edu.uestc.tc.core.barrier.GridMannager;
import edu.uestc.tc.core.barrier.GridStrategy;

/**
 * 丢弃策略，实现获取空对象网格的操作
 * @author xkx
 * 
 * 
 *
 */
public class StrategyDiscard extends GridStrategy {

	/* (non-Javadoc)
	 * @see edu.uestc.tc.core.barrier.GridStrategy#execute()
	 */
	public ArrayGrid execute() {
		return (ArrayGrid) GridMannager.getNullGrid();
	}

}
