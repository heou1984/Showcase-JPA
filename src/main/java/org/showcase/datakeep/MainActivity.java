package org.showcase.datakeep;

import java.util.List;

import org.showcase.datakeep.dao.impl.ViewpointDao;
import org.showcase.datakeep.entities.Viewpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.impetus.kundera.gis.SurfaceType;
import com.impetus.kundera.gis.geometry.Point;

public class MainActivity {
	
	public static final void main(String[] args) throws InterruptedException{

		ApplicationContext context= new ClassPathXmlApplicationContext("context-datakeeper.xml");
		ViewpointDao _vpDao = (ViewpointDao)context.getBean("viewpointDao");
		Point _center = new Point(1.3083, 103.8836);
		Point _location = new Point(1.31037, 103.50856);
		Viewpoint _vp = new Viewpoint();
		_vp.setCenter(_center);
		_vp.setCity("南洋");
		_vp.setElevation(36.906276788086f);
		_vp.setLevel(5);
		_vp.setLocation(_location);
		_vp.setRate(3490);
		_vp.setSearch("南洋博物馆");
		_vp.setViewpoint("南洋博物馆");
		
		//_vpDao.save(_vp);

		for(int i=0; i<1; i++){
			new Thread(new POCDao(context)).start();
			Thread.currentThread().sleep(10);
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class POCDao implements Runnable{
	ApplicationContext _context;
	
	public POCDao(ApplicationContext context){
		_context = context;
	}
	
	@Override
	public void run() {
		ViewpointDao _vpDao = (ViewpointDao)_context.getBean("viewpointDao");
		List<Viewpoint> _list = _vpDao.findNear(1.3107237, 103.8150856, 1, SurfaceType.FLAT) ;
		List<Viewpoint> _cityList = _vpDao.findByCity("新加坡");
		List<Viewpoint> _searchList = _vpDao.findBySearchKey("南");
		System.out.println(Thread.currentThread().getName()+">>>>>>>>>>>>>>>>");
		Thread.currentThread().interrupt();
	}
	
}


