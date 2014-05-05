package org.showcase.datakeep;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.showcase.datakeep.dao.ViewpointDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainActivity {
	
	public static final void main(String[] args){

		ApplicationContext context= new ClassPathXmlApplicationContext("context-datakeeper.xml");
		ViewpointDao _vpDao = (ViewpointDao)context.getBean("viewpointDao");

		EntityManager _vm =_vpDao.getEntityManager();
		Query q = _vm.createQuery("select vp from Viewpoint vp");
        List<?> viewpointList = q.getResultList();
        System.out.println(">>>>>>");
		//_vm.close();

	}

}
