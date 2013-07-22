package edu.uestc.tc.beans;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class CrowdnessArea {
	private int id;
	private double areaCrowdness;
	private CrowdnessGrid crowdnessGrid;
	private Date currentDate;
	private int isHotPot = 0;
	private int normallizedLat;
	private int normallizedLong;

	public double getAreaCrowdness() {
		return areaCrowdness;
	}

	public CrowdnessGrid getCrowdnessGrid() {
		return crowdnessGrid;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public int getId() {
		return id;
	}

	public int getIsHotPot() {
		return isHotPot;
	}

	public int getNormallizedLat() {
		return normallizedLat;
	}

	public int getNormallizedLong() {
		return normallizedLong;
	}

	public void setAreaCrowdness(double areaCrowdness) {
		this.areaCrowdness = areaCrowdness;
	}

	public void setCrowdnessGrid(CrowdnessGrid crowdnessGrid) {
		this.crowdnessGrid = crowdnessGrid;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIsHotPot(int isHotPot) {
		this.isHotPot = isHotPot;
	}

	public void setNormallizedLat(int normallizedLat) {
		this.normallizedLat = normallizedLat;
	}

	public void setNormallizedLong(int normallizedLong) {
		this.normallizedLong = normallizedLong;
	}
}
