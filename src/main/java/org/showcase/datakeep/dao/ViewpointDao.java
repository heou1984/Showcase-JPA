package org.showcase.datakeep.dao;

import java.util.List;

import org.showcase.datakeep.entities.Viewpoint;

public interface ViewpointDao extends BaseDao{
	
	void save(Viewpoint viewpoint);
	void remove(Viewpoint viewpoint);
	void merge(Viewpoint viewpoint);
	List<Viewpoint> findByCity(String city);

}
