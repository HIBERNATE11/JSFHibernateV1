package com.mitocode.dao;

// default package
// Generated 24/01/2014 09:58:50 PM by Hibernate Tools 3.4.0.CR1

import org.hibernate.Query;
import org.hibernate.Session;

import com.mitocode.model.Usuario;
import com.mitocode.util.HibernateUtil;

public class UsuarioDAO {

	private Session session;

	public Usuario verificarDatos(Usuario usuario) throws Exception {
		Usuario us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Usuario WHERE nombre = '" + usuario.getNombre() + "' and clave = '" + usuario.getClave() + "'";
			//String hql = "FROM Usuario WHERE nombre = '" + usuario.getNombre() + "'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Usuario) query.list().get(0);
			}
			//us = new Usuario(1,"Pepe","perez");

		} catch (Exception e) {
			System.out.println("EXCEPCIONNNN: "+ e);
			throw e;
		}

		return us;
	}
}
