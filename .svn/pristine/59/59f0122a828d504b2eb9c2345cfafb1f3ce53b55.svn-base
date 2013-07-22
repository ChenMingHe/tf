package springmvc.excute;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.uestc.tc.core.AreaInfoHandleEntry;
import edu.uestc.tc.core.VehicleInfoHandleEntry;
import edu.uestc.tc.core.dao.Convert;
import edu.uestc.tc.core.dao.Storage;

public class Excute implements ApplicationContextAware {
	private ApplicationContext ctx;  
	public void excute() {
		Convert convert = (Convert) ctx.getBean("convert");
		VehicleInfoHandleEntry entry = (VehicleInfoHandleEntry) ctx
				.getBean("vehicleInfoHandleEntry");
		AreaInfoHandleEntry entry1 = (AreaInfoHandleEntry) ctx
				.getBean("areaInfoHandleEntry");
		Storage storage = (Storage) ctx.getBean("storage");
		Thread threadconvert = new Thread(convert);
		Thread threadEntry = new Thread(entry);
		Thread threadEntry1 = new Thread(entry1);
		Thread threadstorage = new Thread(storage);
		threadconvert.start();
		threadEntry.start();
		threadEntry1.start();
		threadstorage.start();

		try {
			threadconvert.join();
			threadEntry.join();
			threadEntry1.join();
			threadstorage.join();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.ctx = applicationContext;
	}
}
