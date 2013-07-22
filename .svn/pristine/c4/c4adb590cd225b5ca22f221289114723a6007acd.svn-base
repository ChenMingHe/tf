/**
 * 
 */
package edu.uestc.tc.core.barrier.hourglassimpl;

import java.util.Date;

import edu.uestc.tc.beans.VehicleInfo;
import edu.uestc.tc.core.barrier.HourGlass;

/**
 * 返回每个车辆数据的时间标志
 * 
 */
/**
 * @author Administrator
 *
 */
public final class DataBaseHourglass implements HourGlass {
	
	private Date timeLine = new Date(0);
	private long timeRange = 5;
	private Date tempTime = null;
	private long timeDiv = 0;
	static final long PERSECOND = 1000;
	
	static final int TAGDISCARD = 0;
	static final int TAGGRIDONE = 1;
	static final int TAGGRIDTWO = 2;
	static final int TAGGRIDSLIDE = 3;

	public void setTimeRange(int timeRange) {
		this.timeRange = timeRange;
	}

	
	/**
	 * @return 车辆数据的时间范围
	 */
	private long timeDiff( ) {
		Date begin = timeLine;
		long between = (tempTime.getTime() - begin.getTime()) / PERSECOND;
		return between;
	}

	/* (non-Javadoc)
	 * @see edu.uestc.tc.core.barrier.HourGlass#timerInterval(edu.uestc.tc.beans.VehicleInfo)
	 */
	public int timerInterval(VehicleInfo info) {
		if (tempTime == null) {
			tempTime = info.getDtime();
			timeLine = tempTime;
			return TAGGRIDONE;
		}
		tempTime = info.getDtime();
		timeDiv = timeDiff();
		if (timeDiv < 0) {
			return TAGDISCARD;
		}
		if (timeDiv < timeRange) {
			return TAGGRIDONE;
		}
		if (timeDiv < 2 * timeRange) {
			return TAGGRIDTWO;
		}
		if (timeDiv < 3 * timeRange) {
			timeLine = new Date(timeLine.getTime() + timeRange * 1000);
			return TAGGRIDSLIDE;
		}
//		timeLine = new Date(info.getDtime().getTime() - timeRange*1000); 
		timeLine = new Date(timeLine.getTime() + timeRange * 1000);
		return  TAGGRIDSLIDE;
	}
}
