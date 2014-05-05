package org.showcase.datakeep;

import javax.persistence.EntityManager;

import org.showcase.datakeep.dao.ViewpointDao;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MainActivity {
	
	public static final void main(String[] args){
		
		XmlBeanFactory _xbf = new XmlBeanFactory(new ClassPathResource("context-datakeeper.xml"));
		ViewpointDao _vpDao = (ViewpointDao)_xbf.getBean("viewpointDao");

		EntityManager _vm =_vpDao.getEntityManager();
		_vm.close();
		
		
		/*
		EntityManagerFactory _emf = Persistence.createEntityManagerFactory("mongo-pu");
		_emf.createEntityManager();
		*/
	}

}
