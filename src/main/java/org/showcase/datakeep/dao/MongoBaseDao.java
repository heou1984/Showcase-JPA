package org.showcase.datakeep.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public abstract class MongoBaseDao implements BaseDao{
	
	/*
	private EntityManagerFactory _entityManagerFactory;
	*/
	
	@PersistenceContext(name="mongo", type=PersistenceContextType.EXTENDED)
	private EntityManager _em;
	
	public EntityManager getEntityManager(){
		//return this._entityManagerFactory.createEntityManager();
		return this._em;
	}
	
	public void save(Object entity){
		if(null != entity){
			EntityManager _em = this.getEntityManager();
			_em.persist(entity);
			_em.flush();
			//_em.close();
		}
	}
	
	public void remove(Object entity){
		EntityManager _em = this.getEntityManager();	
		_em.remove(entity);
		_em.clear();
		//_em.close();
	}
	
	public void merge(Object entity){
		EntityManager _em = this.getEntityManager();	
		_em.merge(entity);
		_em.clear();
		//_em.close();
	}
	
	public List<?> findAll(Class<?> clazz){
		EntityManager _em = this.getEntityManager();
		String _queryStr = String.format("Select p from $s p", clazz.getSimpleName());
		List<?> _list = _em.createQuery(_queryStr).getResultList();
		//_em.close();
		return _list;
	}
		
	/*
	public EntityManagerFactory getEntityManagerFactory(){
        return _entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory){
        this._entityManagerFactory = entityManagerFactory;
    }
    */
}
