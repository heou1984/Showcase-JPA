package org.showcase.datakeep.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface ViewpointDao {
	
	EntityManager getEntityManager();
	EntityManagerFactory getEntityManagerFactory();
	void setEntityManagerFactory(EntityManagerFactory entityManagerFactory);

}
