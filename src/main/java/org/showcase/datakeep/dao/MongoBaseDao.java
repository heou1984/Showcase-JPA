package org.showcase.datakeep.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public abstract class MongoBaseDao implements BaseDao{
	//@PersistenceUnit
	@PersistenceContext(name="mongo", type=PersistenceContextType.EXTENDED)
	private EntityManager _em;
	
	public EntityManager getEntityManager(){
		return _em;
	}
	
	public void save(Object entity){
		if(null != entity){
			this.getEntityManager().persist(entity);
		}
	}
	
	public void remove(Object entity){
		this.getEntityManager().remove(entity);
	}
	
	public void merge(Object entity){
		this.getEntityManager().merge(entity);
	}
	
	public List<?> findAll(Class<?> clazz){
		return this.getEntityManager().createQuery("select p from ".concat(clazz.getSimpleName()).concat(" p")).getResultList();
	}
}
