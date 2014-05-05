package org.showcase.datakeep.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.showcase.datakeep.dao.ViewpointDao;


public class ViewpointDaoImpl implements ViewpointDao {
	
	private EntityManagerFactory entityManagerFactory;
	//private EntityManager _entityManager;
	
	public EntityManager getEntityManager(){
		return this.entityManagerFactory.createEntityManager();
	}
	
    public EntityManagerFactory getEntityManagerFactory()
    {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory)
    {
        this.entityManagerFactory = entityManagerFactory;
    }
}
