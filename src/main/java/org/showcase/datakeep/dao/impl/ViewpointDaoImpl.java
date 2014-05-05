package org.showcase.datakeep.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.showcase.datakeep.dao.ViewpointDao;


public class ViewpointDaoImpl implements ViewpointDao {
	
	@PersistenceContext(unitName = "mongo", type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	public EntityManager getEntityManager(){
		return em;
	}
	
}
