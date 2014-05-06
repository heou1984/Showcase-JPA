package org.showcase.datakeep.dao;

import javax.persistence.EntityManager;

public interface BaseDao {
	EntityManager getEntityManager();
}
