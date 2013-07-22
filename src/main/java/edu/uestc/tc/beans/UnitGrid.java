package edu.uestc.tc.beans;

import java.util.ArrayList;

public class UnitGrid {
	private ArrayList<VehicleInfo> infoList = new ArrayList<VehicleInfo>();
	private int normallizedLat;
	private int normallizedLong;

	public void clear() {
		this.infoList.clear();
		normallizedLat = 0;
		normallizedLong = 0;
	}
	public ArrayList<VehicleInfo> getInfoList() {
		return infoList;
	}

	public int getNormallizedLat() {
		return normallizedLat;
	}

	public int getNormallizedLong() {
		return normallizedLong;
	}

	public void push(VehicleInfo info) {
		this.infoList.add(info);
	}

	public void setInfoList(ArrayList<VehicleInfo> infoList) {
		this.infoList = infoList;
	}

	public void setNormallizedLat(int normallizedLat) {
		this.normallizedLat = normallizedLat;
	}

	public void setNormallizedLong(int normallizedLong) {
		this.normallizedLong = normallizedLong;
	}
}
