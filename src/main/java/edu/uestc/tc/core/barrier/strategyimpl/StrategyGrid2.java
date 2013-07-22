package edu.uestc.tc.core.barrier.strategyimpl;

import edu.uestc.tc.beans.gridimpl.*;
import edu.uestc.tc.core.barrier.GridMannager;
import edu.uestc.tc.core.barrier.GridStrategy;

/**
 * 获取2号网格，实现获取2号网格的策略实现
 * @author xkx
 * 
 * 
 *
 */
public class StrategyGrid2 extends GridStrategy {

	public ArrayGrid execute() {
		// TODO Auto-generated method stub
		return GridMannager.getGrid2();
	}

}
