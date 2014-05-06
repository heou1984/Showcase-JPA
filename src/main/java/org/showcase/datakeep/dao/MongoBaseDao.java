package org.showcase.datakeep.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public abstract class MongoBaseDao {
	
	@PersistenceContext(name="mongo", type=PersistenceContextType.EXTENDED)
	private EntityManager _em;
	
	public EntityManager getEntityManager(){
		return _em;
	}
}
