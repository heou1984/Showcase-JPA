package org.showcase.datakeep.service;

import java.util.List;

import org.showcase.datakeep.dao.impl.ViewpointDao;
import org.showcase.datakeep.entities.Viewpoint;
import org.springframework.stereotype.Service;

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
	
	public List<Viewpoint> findViewpointByLocation(){
		return null;
	}
	
	public void createViewpoint(Viewpoint viewpoint){
		
	}
	
	public void updateViewpoint(Viewpoint viewpoint){
		
	}
	
	public void deleteViewpoint(Viewpoint viewpoint){
		
	}

}
