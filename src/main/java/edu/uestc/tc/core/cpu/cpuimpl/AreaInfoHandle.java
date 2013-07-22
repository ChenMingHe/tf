package edu.uestc.tc.core.cpu.cpuimpl;

import java.util.Date;

import edu.uestc.tc.beans.CrowdnessArea;
import edu.uestc.tc.beans.CrowdnessGrid;
import edu.uestc.tc.beans.UnitGrid;
import edu.uestc.tc.beans.VehicleInfo;
import edu.uestc.tc.core.cpu.CpuHandler;
import edu.uestc.tc.core.dao.Convert;
import edu.uestc.tc.utils.CrowdnessGridQueue;

public class AreaInfoHandle implements CpuHandler {
	private double crowdness;
	private CrowdnessArea crowdnessArea = null;
	private CrowdnessGridQueue crowdnessGridQueue = null;
	private CrowdnessGrid finalGrid1 = new CrowdnessGrid();
	private CrowdnessGrid finalGrid2 = new CrowdnessGrid();
	private double hotPotBond;

	private int normalizedlat;

	private int normalizedlong;
	private double p = 0;
	private double paramA;
	private double temCrowdness = 0;
	public void assemble(CrowdnessGrid grid, Date time) {
		crowdnessArea = new CrowdnessArea();
		crowdness = paramA * temCrowdness + (1 - paramA) * (1 - p);
		if (crowdness >= hotPotBond) {
			crowdnessArea.setIsHotPot(1);
		}
		crowdnessArea.setAreaCrowdness(crowdness);
		crowdnessArea.setNormallizedLat(normalizedlat);
		crowdnessArea.setNormallizedLong(normalizedlong);
		crowdnessArea.setCurrentDate(time);
		grid.getCrowdnessAreaArray()[normalizedlat][normalizedlong] = crowdnessArea;
		grid.setCurrentDate(time);
		temCrowdness = 0;
	}

	public void caculatePara(UnitGrid areaVehicleInfo) {
		int num = 0;
		double averageSpeed = 0;
		for (VehicleInfo info : areaVehicleInfo.getInfoList()) {
			averageSpeed += (double) info.getiSpeed();
		}
		averageSpeed = averageSpeed / areaVehicleInfo.getInfoList().size();
		for (VehicleInfo info : areaVehicleInfo.getInfoList()) {
			if ((double) info.getiSpeed() <= averageSpeed) {
				num++;
			}
		}
		p = (double) num / areaVehicleInfo.getInfoList().size();
	}

	public double getCrowdness() {
		return crowdness;
	}

	public CrowdnessArea getCrowdnessArea() {
		return crowdnessArea;
	}

	public CrowdnessGrid getFinalGrid1() {
		return finalGrid1;
	}

	public CrowdnessGrid getFinalGrid2() {
		return finalGrid2;
	}

	public double getHotPotBond() {
		return hotPotBond;
	}

	public double getP() {
		return p;
	}

	public void handle(UnitGrid areaVehicleInfo, Date time) {
		// TODO ¼ÆËãÇøÓòÓµÈû¶È
		boolean flag1 = finalGrid1.getCurrentDate() != null
				&& finalGrid2.getCurrentDate() != null;
		boolean flag2 = finalGrid2.getCurrentDate() != time;
		if (flag1 == true && flag2 == true) {
			try {
				update(finalGrid1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		caculatePara(areaVehicleInfo);
		normalizedlat = areaVehicleInfo.getNormallizedLat();
		normalizedlong = areaVehicleInfo.getNormallizedLong();
		if (finalGrid1.getCrowdnessAreaArray()[normalizedlat][normalizedlong] != null) {
			temCrowdness = finalGrid1.getCrowdnessAreaArray()[normalizedlat][normalizedlong]
					.getAreaCrowdness();
			assemble(finalGrid2, time);
		} else if (finalGrid2.getCurrentDate() != null | (finalGrid1.getCurrentDate() != null && finalGrid1.getCurrentDate() != time)) {
			assemble(finalGrid2, time);
		} else {
			assemble(finalGrid1, time);
		}
	}

	public void setCrowdnessArea(CrowdnessArea crowdnessArea) {
		this.crowdnessArea = crowdnessArea;
	}

	public void setCrowdnessGridQueue(CrowdnessGridQueue crowdnessGridQueue) {
		this.crowdnessGridQueue = crowdnessGridQueue;
	}

	public void setHotPotBond(double hotPotBond) {
		this.hotPotBond = hotPotBond;
	}

	public void setParamA(double paramA) {
		this.paramA = paramA;
	}

	public void update(CrowdnessGrid grid) throws InterruptedException {
		crowdnessGridQueue.add(grid);		
		finalGrid1 = finalGrid2;
		finalGrid2 = new CrowdnessGrid();
	}

}
