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
			System.out.println("Antes de la query");
			String hql = "FROM Usuario WHERE nombre = '" + usuario.getNombre() + "' and clave = '" + usuario.getClave() + "'";
			//String hql = "FROM Usuario WHERE nombre = '" + usuario.getNombre() + "'";
			System.out.println("hql: "+ hql);
			Query query = session.createQuery(hql);
			System.out.println("query: "+ query);

			if (!query.list().isEmpty()) {
				System.out.println("Lista no vacia");
				us = (Usuario) query.list().get(0);
				System.out.println("us.getNombre(): "+ us.getNombre());
			}
			//us = new Usuario(1,"Pepe","Perez");

		} catch (Exception e) {
			System.out.println("EXCEPCIONNNN: "+ e);
			throw e;
		}

		return us;
	}
}
