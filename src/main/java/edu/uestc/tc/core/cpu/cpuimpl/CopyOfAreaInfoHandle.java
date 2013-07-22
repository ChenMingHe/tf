package edu.uestc.tc.core.cpu.cpuimpl;

import java.util.Date;

import edu.uestc.tc.beans.CrowdnessArea;
import edu.uestc.tc.beans.CrowdnessGrid;
import edu.uestc.tc.beans.UnitGrid;
import edu.uestc.tc.beans.VehicleInfo;
import edu.uestc.tc.core.cpu.CpuHandler;
import edu.uestc.tc.core.dao.Convert;
import edu.uestc.tc.utils.CrowdnessGridQueue;

public class CopyOfAreaInfoHandle implements CpuHandler {
	private double crowdness;
	private CrowdnessArea crowdnessArea = null;
	private CrowdnessGridQueue crowdnessGridQueue = null;
	private CrowdnessGrid finalGrid1 = new CrowdnessGrid();
	private CrowdnessGrid finalGrid2 = new CrowdnessGrid();
	private CrowdnessGrid temgGrid;
	private double hotPotBond;
	private int normalizedlat;

	private int normalizedlong;

	private double p = 0;
	private double paramA;
	private double temCrowdness = 0;
	public void assemble(Date time) {
		crowdnessArea = new CrowdnessArea();		
		if (crowdness >= hotPotBond) {
			crowdnessArea.setIsHotPot(1);
		}
		crowdnessArea.setAreaCrowdness(crowdness);
		crowdnessArea.setNormallizedLong(normalizedlong);
		crowdnessArea.setNormallizedLat(normalizedlat);
		crowdnessArea.setCurrentDate(time);
		finalGrid2.getCrowdnessAreaArray()[normalizedlat][normalizedlong] = crowdnessArea;
		finalGrid2.setCurrentDate(time);
	}

	public void caculatePara(UnitGrid areaVehicleInfo) {
		int num = 0;
		double averageSpeed = 0.0;
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
		if (finalGrid1.getCrowdnessAreaArray()[normalizedlat][normalizedlong] != null) {
			temCrowdness = finalGrid1.getCrowdnessAreaArray()[normalizedlat][normalizedlong]
					.getAreaCrowdness();
		}
		crowdness = paramA * temCrowdness + (1 - paramA) * (1 - p);
		temCrowdness = 0;
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
		caculatePara(areaVehicleInfo);
		normalizedlat = areaVehicleInfo.getNormallizedLat();
		normalizedlong = areaVehicleInfo.getNormallizedLong();
		if (finalGrid2.getCurrentDate() != time
				&& finalGrid2.getCurrentDate() != null) {
			try {
				update();
			} catch (InterruptedException e) {
				System.out.println("interrupt");
			}
		}
		assemble(time);
//		System.out.println(finalGrid1.getCurrentDate());
//		System.out.println(finalGrid2.getCurrentDate());
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

	public void update() throws InterruptedException {
		if (finalGrid1.getCurrentDate() != null) {
			crowdnessGridQueue.add(finalGrid1);
			System.out.println("update" + finalGrid1.getCurrentDate());
		}
//		temgGrid = finalGrid1;
//		temgGrid.clear();
//		System.out.println("clear" + finalGrid1.getCurrentDate());
		finalGrid1 = finalGrid2;
		finalGrid2 = new CrowdnessGrid();
//		finalGrid2 = temgGrid;
	}
}
