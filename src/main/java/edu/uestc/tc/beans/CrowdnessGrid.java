package edu.uestc.tc.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CrowdnessGrid {
	private int id;
	private int colunmNum;
	@OneToMany
	private CrowdnessArea[][] crowdnessAreaArray;
	private Date currentDate;
	private int highestLat = 24000000;
	private int highestLong = 120000000;
	private int lowestLat = 21000000;
	private int lowestLong = 100000000;
	private int normalizedLatPara = 3000;
	private int normalizedLongPara = 20000;
	private int rowNum;

	public CrowdnessGrid() {
		this.colunmNum = calculateColunmNum();
		this.rowNum = calculateRowNum();
		this.crowdnessAreaArray = new CrowdnessArea[rowNum][colunmNum];
	}

	private int calculateColunmNum() {
		return (highestLong - lowestLong) / normalizedLongPara;
	}

	private int calculateRowNum() {
		return (highestLat - lowestLat) / normalizedLatPara;
	}

	public void clear() {
		currentDate = null;
		for (int i = 0; i < rowNum; i++)
			for (int j = 0; j < colunmNum; j++) {
				crowdnessAreaArray[i][j] = null;
			}
	}

	public int getColunmNum() {
		return colunmNum;
	}

	public CrowdnessArea[][] getCrowdnessAreaArray() {
		return crowdnessAreaArray;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public int getHighestLat() {
		return highestLat;
	}

	public int getHighestLong() {
		return highestLong;
	}

	public int getId() {
		return id;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setCrowdnessAreaArray(CrowdnessArea[][] crowdnessAreaArray) {
		this.crowdnessAreaArray = crowdnessAreaArray;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public void setHighestLat(int highestLat) {
		this.highestLat = highestLat;
	}

	public void setHighestLong(int highestLong) {
		this.highestLong = highestLong;
	}

	public void setId(int id) {
		this.id = id;
	}

}
