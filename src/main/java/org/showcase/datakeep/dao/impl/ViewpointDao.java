package org.showcase.datakeep.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.showcase.datakeep.dao.MongoBaseDao;
import org.showcase.datakeep.entities.Viewpoint;

public class ViewpointDao extends MongoBaseDao{
	
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