package org.showcase.datakeep;

import java.util.List;

import org.showcase.datakeep.dao.ViewpointDao;
import org.showcase.datakeep.entities.Center;
import org.showcase.datakeep.entities.Location;
import org.showcase.datakeep.entities.Viewpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainActivity {
	
	public static final void main(String[] args){

		ApplicationContext context= new ClassPathXmlApplicationContext("context-datakeeper.xml");
		ViewpointDao _vpDao = (ViewpointDao)context.getBean("viewpointDao");
		
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
		
		List<Viewpoint> _list = _vpDao.findByCity("南洋");
		Viewpoint _vp2 = _list.get(0);
		//_vp2.setCity("南洋");
		
		//_em.getTransaction().rollback();
		/*
		Query q = _vm.createQuery("select vp from Viewpoint vp");
        List<?> viewpointList = q.getResultList();
        */
	}

}
