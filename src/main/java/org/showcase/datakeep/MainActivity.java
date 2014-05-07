package org.showcase.datakeep;

import org.showcase.datakeep.dao.impl.ViewpointDao;
import org.showcase.datakeep.entities.Center;
import org.showcase.datakeep.entities.Location;
import org.showcase.datakeep.entities.Viewpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainActivity {
	
	public static final void main(String[] args) throws InterruptedException{

		ApplicationContext context= new ClassPathXmlApplicationContext("context-datakeeper.xml");
		
		Center _center = new Center();
		_center.setLat(1.352083f);
		_center.setLng(103.819836f);
		Location _location = new Location();
		_location.setLat(1.3107237f);
		_location.setLng(103.8150856f);
		Viewpoint _vp = new Viewpoint();
		_vp.setCenter(_center);
		_vp.setCity("新加坡");
		_vp.setElevation(36.90627670288086f);
		_vp.setLevel(5);
		_vp.setLocation(_location);
		_vp.setRate(3490);
		_vp.setSearch("新加坡植物园");
		_vp.setViewpoint("新加坡植物园");
		
		//_vpDao.save(_vp);

		for(int i=0; i<500; i++){
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
		Viewpoint _vp = (Viewpoint)_vpDao.findAll(Viewpoint.class).get(0);
		if("新加坡".equals(_vp.getCity())){
			_vp.setCity("南洋");
		}else{
			_vp.setCity("新加坡");
		}
		_vpDao.merge(_vp);
		System.out.println(Thread.currentThread().getName()+">>>>>>>>>>>>>>>>"+_vp.getCity());
		Thread.currentThread().interrupt();
	}
	
}


