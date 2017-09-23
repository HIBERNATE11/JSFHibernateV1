package com.mitocode.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.mitocode.model.Tablagorka;
import com.mitocode.util.HibernateUtil;

public class TablagorkaDAO {

	private Session session;
	private Transaction trans;
	private List<Tablagorka> lstEmpleados;

	public void Registrar(Tablagorka emp) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(emp);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void Eliminar(Tablagorka emp) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.delete(emp);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void Modificar(Tablagorka emp) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(emp);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Tablagorka> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Tablagorka.class);
			cri.addOrder(Order.asc("id"));
			lstEmpleados = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return lstEmpleados;
	}
	
	public Tablagorka verificarDatos(Tablagorka tablagorka) throws Exception {
		Tablagorka tg = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM TablaGorka WHERE id = '" + tablagorka.getId() + "'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				tg = (Tablagorka) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		}

		return tg;
	}
}
