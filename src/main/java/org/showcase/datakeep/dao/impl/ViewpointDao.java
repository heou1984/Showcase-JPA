package org.showcase.datakeep.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.showcase.datakeep.dao.MongoBaseDao;

import com.impetus.client.mongodb.MongoDBClient;
import com.impetus.kundera.client.Client;

public class ViewpointDao extends MongoBaseDao{
	
	public List<?> findByLocation(double lat, double lng, int maxDistance){
		Map<String, Client<Query>> clients = (Map<String, Client<Query>>) this.getEntityManager().getDelegate();
        Client client = clients.get("mongo");

        String jScript = "db.system.js.save({ _id: \"echoFunction\",value : function(x) { return x; }})";
        Object result = ((MongoDBClient) client).executeScript(jScript);
		return null;
	}
	

	public List<?> findByCity(String city){
		List<?> _vpList = null;
		
		if(null != city && city.length() > 0){
			Query _query = this.getEntityManager().createQuery("select p from Viewpoint p where p.city = "+city);
			_vpList = _query.getResultList();
		}
		
		return _vpList;
	}
}
