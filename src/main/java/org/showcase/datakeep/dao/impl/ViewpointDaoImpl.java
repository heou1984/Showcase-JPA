package org.showcase.datakeep.dao.impl;


import java.util.List;

import javax.persistence.Query;

import org.showcase.datakeep.dao.MongoBaseDao;
import org.showcase.datakeep.dao.ViewpointDao;
import org.showcase.datakeep.entities.Viewpoint;


public class ViewpointDaoImpl extends MongoBaseDao implements ViewpointDao {
	
	
	public void save(Viewpoint viewpoint){
		if(null != viewpoint){
			this.getEntityManager().persist(viewpoint);
		}
	}
	
	public void remove(Viewpoint viewpoint){
		this.getEntityManager().remove(viewpoint);
	}
	
	public void merge(Viewpoint viewpoint){
		this.getEntityManager().merge(viewpoint);
	}
	
	@SuppressWarnings("unchecked")
	public List<Viewpoint> findByCity(String city){
		List<Viewpoint> _vpList = null;
		
		if(null != city && city.length() > 0){
			Query _query = this.getEntityManager().createQuery("select p from Viewpoint p where p.city = "+city);
			_vpList = _query.getResultList();
		}
		
		return _vpList;
	}
}
