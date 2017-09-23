package com.mitocode.dao.auto;
// Generated 04-sep-2017 11:44:05 by Hibernate Tools 5.2.3.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.mitocode.model.Tablagorka;

/**
 * Home object for domain model class Tablagorka.
 * @see com.mitocode.model.Tablagorka
 * @author Hibernate Tools
 */
public class TablagorkaHome {

	private static final Log log = LogFactory.getLog(TablagorkaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Tablagorka transientInstance) {
		log.debug("persisting Tablagorka instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tablagorka instance) {
		log.debug("attaching dirty Tablagorka instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tablagorka instance) {
		log.debug("attaching clean Tablagorka instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tablagorka persistentInstance) {
		log.debug("deleting Tablagorka instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tablagorka merge(Tablagorka detachedInstance) {
		log.debug("merging Tablagorka instance");
		try {
			Tablagorka result = (Tablagorka) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tablagorka findById(java.lang.Integer id) {
		log.debug("getting Tablagorka instance with id: " + id);
		try {
			Tablagorka instance = (Tablagorka) sessionFactory.getCurrentSession().get("com.mitocode.model.Tablagorka",
					id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Tablagorka instance) {
		log.debug("finding Tablagorka instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.mitocode.model.Tablagorka")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
