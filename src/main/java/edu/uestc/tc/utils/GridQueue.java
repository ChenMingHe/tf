package edu.uestc.tc.utils;

import edu.uestc.tc.beans.CommiteGrid;

public interface GridQueue {
	public void add(CommiteGrid info) throws InterruptedException ;

	public CommiteGrid poll() throws InterruptedException ;
}
