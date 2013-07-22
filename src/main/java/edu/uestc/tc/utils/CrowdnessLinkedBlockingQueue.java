package edu.uestc.tc.utils;

import java.util.concurrent.LinkedBlockingQueue;

import edu.uestc.tc.beans.CrowdnessGrid;

public class CrowdnessLinkedBlockingQueue implements CrowdnessGridQueue {
	private LinkedBlockingQueue<CrowdnessGrid> CrowdnessInfoQueue;

	public void add(CrowdnessGrid info) throws InterruptedException {
		// TODO Auto-generated method stub
		CrowdnessInfoQueue.put(info);
	}

	public CrowdnessGrid poll() throws InterruptedException {
		// TODO Auto-generated method stub
		return CrowdnessInfoQueue.take();
	}

	public void setCrowdnessInfoQueue(
			LinkedBlockingQueue<CrowdnessGrid> crowdnessInfoQueue) {
		CrowdnessInfoQueue = crowdnessInfoQueue;
	}

}
