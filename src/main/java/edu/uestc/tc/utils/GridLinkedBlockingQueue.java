package edu.uestc.tc.utils;

import java.util.concurrent.LinkedBlockingQueue;

import edu.uestc.tc.beans.CommiteGrid;

public class GridLinkedBlockingQueue implements GridQueue {
private LinkedBlockingQueue<CommiteGrid> gridsQueue = new LinkedBlockingQueue<CommiteGrid>();
	
	
	public void setGridsQueue(
			LinkedBlockingQueue<CommiteGrid> gridsQueue) {
		this.gridsQueue = gridsQueue;
	}
	public void add(CommiteGrid info) throws InterruptedException {
		// TODO Auto-generated method stub
		gridsQueue.put(info);
	}

	public CommiteGrid poll() throws InterruptedException {
		// TODO Auto-generated method stub
		return gridsQueue.take();
	}

}
