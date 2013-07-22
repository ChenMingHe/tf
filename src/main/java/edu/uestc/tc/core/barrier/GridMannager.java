package edu.uestc.tc.core.barrier;

import java.util.Date;
import edu.uestc.tc.beans.CommiteGrid;
import edu.uestc.tc.beans.Grid;
import edu.uestc.tc.beans.gridimpl.ArrayGrid;
import edu.uestc.tc.utils.GridLinkedBlockingQueue;
import edu.uestc.tc.utils.GridQueue;

/**
 * 实现相应的网格管理操作，为策略对象提供相应的接口获取其需要的网格
 * 
 * @author xkx
 * 
 */

public class GridMannager {
	private static ArrayGrid grid1 = new ArrayGrid();
	private static ArrayGrid grid2 = new ArrayGrid();
	private static GridQueue gridbuff = new GridLinkedBlockingQueue();
	private static CommiteGrid gridCommitte = null;
	private static ArrayGrid temGrid;

	public static ArrayGrid getGrid1() {
		return grid1;
	}

	public static ArrayGrid getGrid2() {
		return grid2;
	}

	public static GridQueue getGridbuff() {
		return gridbuff;
	}

	public static CommiteGrid getGridCommitte() {
		return gridCommitte;
	}

	public static Grid getNullGrid() {
		return null;
	}

	/**
	 * @return
	 */
	public static ArrayGrid updateGrid() {
		gridCommitte = grid1.getCommiteGrid();
		if (gridCommitte != null) {
			int lastUnitIndex = gridCommitte.getUnitList().size() - 1;
			int lastInfoIndex = gridCommitte.getUnitList().get(lastUnitIndex)
					.getInfoList().size() - 1;
			Date dateTag = gridCommitte.getUnitList().get(lastUnitIndex)
					.getInfoList().get(lastInfoIndex).getDtime();
			gridCommitte.setCurruntDate(dateTag);
			try {
				gridbuff.add(gridCommitte);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		grid1.clear();
		temGrid = grid1;
		grid1 = grid2;
		grid2 = temGrid;
		return grid2;
	}

}
