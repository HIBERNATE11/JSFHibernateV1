package com.mitocode.dao.auto;
// Generated 04-sep-2017 11:44:05 by Hibernate Tools 5.2.3.Final

import java.sql.SQLException;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.mitocode.model.Empleado;

/**
 * Home object for domain model class Empleado.
 * @see com.mitocode.model.Empleado
 * @author Hibernate Tools
 */
public class EmpleadoHome {

	private static final Log log = LogFactory.getLog(EmpleadoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("MiSesionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Empleado transientInstance) throws SQLException {
		log.debug("persisting Empleado instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
//			Session sesion = sessionFactory.openSession();
//			sesion.beginTransaction();
//			sesion.save(transientInstance);
//			sesion.beginTransaction().commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Empleado instance) {
		log.debug("attaching dirty Empleado instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Empleado instance) {
		log.debug("attaching clean Empleado instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Empleado persistentInstance) {
		log.debug("deleting Empleado instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Empleado merge(Empleado detachedInstance) {
		log.debug("merging Empleado instance");
		try {
			Empleado result = (Empleado) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Empleado findById(java.lang.Integer id) {
		log.debug("getting Empleado instance with id: " + id);
		try {
			Empleado instance = (Empleado) sessionFactory.getCurrentSession().get("com.mitocode.model.Empleado", id);
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

	public List findByExample(Empleado instance) {
		log.debug("finding Empleado instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.mitocode.model.Empleado")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
