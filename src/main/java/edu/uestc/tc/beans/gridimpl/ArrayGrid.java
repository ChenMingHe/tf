package edu.uestc.tc.beans.gridimpl;

import edu.uestc.tc.beans.CommiteGrid;

import edu.uestc.tc.beans.Grid;
import edu.uestc.tc.beans.UnitGrid;

public class ArrayGrid implements Grid {
	private int colunmNum;

	private CommiteGrid commiteGrid;

	private int highestLat = 24000000;

	private int highestLong = 120000000;

	private int lowestLat = 21000000;
	private int lowestLong = 100000000;
	private int normalizedLatPara = 3000;
	private int normalizedLongPara = 20000;
	private int rowNum;
	private UnitGrid[][] unitArray;

	public ArrayGrid() {
		this.colunmNum = calculateColunmNum();
		this.rowNum = calculateRowNum();
		this.unitArray = new UnitGrid[rowNum][colunmNum];
		this.commiteGrid = new CommiteGrid();
	}

	private int calculateColunmNum() {
		// TODO Auto-generated method stub
		return (highestLong - lowestLong) / normalizedLongPara;
	}

	private int calculateRowNum() {
		// TODO Auto-generated method stub
		return (highestLat - lowestLat) / normalizedLatPara;
	}

	public void clear() {
		this.commiteGrid = new CommiteGrid();
		for (int i = 0; i < rowNum; i++)
			for (int j = 0; j < colunmNum; j++) {
				if (unitArray[i][j] != null) {
					unitArray[i][j] = null;
				}
			}
	}

	public int getColunmNum() {
		return colunmNum;
	}

	public CommiteGrid getCommiteGrid() {
		return commiteGrid;
	}

	public int getHighestLat() {
		return highestLat;
	}

	public int getHighestLong() {
		return highestLong;
	}

	public int getLowestLat() {
		return lowestLat;
	}

	public int getLowestLong() {
		return lowestLong;
	}

	public int getNormalizedLatPara() {
		return normalizedLatPara;
	}

	public int getNormalizedLongPara() {
		return normalizedLongPara;
	}

	public int getRowNum() {
		return rowNum;
	}

	public UnitGrid[][] getUnitArray() {
		return unitArray;
	}

	public void push(UnitGrid unitGrid) {
		this.commiteGrid.push(unitGrid);
	}

	public void setCommiteGrid(CommiteGrid commiteGrid) {
		this.commiteGrid = commiteGrid;
	}

	public void setHighestLat(int highestLat) {
		this.highestLat = highestLat;
	}

	public void setHighestLong(int highestLong) {
		this.highestLong = highestLong;
	}

	public void setLowestLat(int lowestLat) {
		this.lowestLat = lowestLat;
	}

	public void setLowestLong(int lowestLong) {
		this.lowestLong = lowestLong;
	}

	public void setNormalizedLatPara(int normalizedLatPara) {
		this.normalizedLatPara = normalizedLatPara;
	}

	public void setNormalizedLongPara(int normalizedLongPara) {
		this.normalizedLongPara = normalizedLongPara;
	}
}
