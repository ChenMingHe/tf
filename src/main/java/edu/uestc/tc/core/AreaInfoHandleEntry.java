package edu.uestc.tc.core;

import edu.uestc.tc.beans.CommiteGrid;
import edu.uestc.tc.beans.UnitGrid;
import edu.uestc.tc.core.barrier.GridMannager;
import edu.uestc.tc.core.cpu.CpuHandler;

public class AreaInfoHandleEntry implements Runnable {
	private CpuHandler cpuHandler = null;
	private CommiteGrid vehicleInfoGrid = null;

	public void setCpuHandler(CpuHandler cpuHandler) {
		this.cpuHandler = cpuHandler;
	}

	public void run() {
		if (cpuHandler == null) {
			System.out.println("cpuHandlerŒ¥≥ı ºªØ");
			return;
		}

		while (true) {
			try {
				vehicleInfoGrid = GridMannager.getGridbuff().poll();
				for (UnitGrid areaVehicleInfo : vehicleInfoGrid.getUnitList()) {
					if(areaVehicleInfo != null)
					cpuHandler.handle(areaVehicleInfo,
							vehicleInfoGrid.getCurruntDate());
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}

