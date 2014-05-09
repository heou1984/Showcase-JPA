package org.showcase.datakeep.dao.impl;

import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.Query;

import org.showcase.datakeep.dao.MongoBaseDao;
import org.showcase.datakeep.entities.Viewpoint;

import com.impetus.kundera.gis.SurfaceType;
import com.impetus.kundera.gis.geometry.Point;

public class ViewpointDao extends MongoBaseDao{

	@SuppressWarnings("unchecked")
	public List<Viewpoint> findNear(double lat, double lng, double maxDistance, SurfaceType surfaceType){
		Point _point = new Point(lat, lng);
		_point.setSurfaceType(surfaceType);
		Query _query = this.getEntityManager().createQuery("Select p from Viewpoint p where p.location > :point AND p.location < :maxDistance");
		_query.setParameter("point", _point);
		_query.setParameter("maxDistance", maxDistance);
		List<Viewpoint> _list = _query.getResultList();
		
		return _list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viewpoint> findByCity(String city){
		List<Viewpoint> _vpList = null;
		
		if(null != city && city.length() > 0){
			Query _query = this.getEntityManager().createQuery("Select p from Viewpoint p where p.city = :city");
			_query.setParameter("city", city);
			_vpList = _query.getResultList();
		}
	
		return _vpList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viewpoint> findBySearchKey(String key){
		List<Viewpoint> _vpList = null;
		
		if(null != key && key.length() > 0){
			Query _query = this.getEntityManager().createQuery("Select p from Viewpoint p where p.search like :search");
			_query.setParameter("search", Pattern.compile(key));
	
			_vpList = _query.getResultList();
		}
		
		return _vpList;
	}
}
