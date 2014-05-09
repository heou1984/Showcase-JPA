package org.showcase.datakeep.service;

import java.util.List;

import org.showcase.datakeep.dao.impl.ViewpointDao;
import org.showcase.datakeep.entities.Viewpoint;
import org.springframework.stereotype.Service;

import com.impetus.kundera.gis.SurfaceType;

@Service
public class ViewpointService {
	
	private ViewpointDao _viewpointDao;
	
	public ViewpointDao getViewpointDao(){
		return this._viewpointDao;
	}
	
	public void setViewpointDao(ViewpointDao viewpointDao){
		this._viewpointDao = viewpointDao;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viewpoint> getAllViewpoints(){
		return (List<Viewpoint>) this._viewpointDao.findAll(Viewpoint.class);
	}
	
	public List<Viewpoint> findNear(double lat, double lng, double maxDistance){
		return this._viewpointDao.findNear(lat, lng, maxDistance, SurfaceType.FLAT);
	}
	
	public List<Viewpoint> findViewpointsByCity(String city){
		return this._viewpointDao.findByCity(city);
	}
	
	public List<Viewpoint> findBySearchKey(String searchKey){
		return this._viewpointDao.findBySearchKey(searchKey);
	}
	
	public void createViewpoint(Viewpoint viewpoint){
		this._viewpointDao.save(viewpoint);
	}
	
	public void updateViewpoint(Viewpoint viewpoint){
		this._viewpointDao.merge(viewpoint);
	}
	
	public void deleteViewpoint(Viewpoint viewpoint){
		this._viewpointDao.remove(viewpoint);
	}

}
