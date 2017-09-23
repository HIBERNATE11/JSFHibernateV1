package com.mitocode.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;

import com.mitocode.dao.TablagorkaDAO;
import com.mitocode.model.Tablagorka;

@ManagedBean
@SessionScoped
public class TablagorkaBean {

	private Tablagorka tablagorka = new Tablagorka();

	public Tablagorka getTablagorka() {
		return tablagorka;
	}

	public void setTablagorka(Tablagorka tablagorka) {
		this.tablagorka = tablagorka;
	}
	
	public String verificarDatos() throws Exception {
		TablagorkaDAO tablagorkaDAO = new TablagorkaDAO();
		Tablagorka tablagorka;
		String resultado;

		try {
			// Enviando la encriptacion
			//String encript = DigestUtils.md5Hex(this.usuario.getNombre());
			String encript = DigestUtils.sha1Hex(String.valueOf(this.tablagorka.getId()));
			this.tablagorka.setId(Integer.valueOf(encript));

			tablagorka = tablagorkaDAO.verificarDatos(this.tablagorka);
			if (tablagorka != null) {

				FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap().put("tablagorka", tablagorka);

				resultado = "exito"; // recalcar que el faces-redirect=true,
										// olvida la peticion anterior y se
										// dirige a la vista
			} else {
				resultado = "error";
			}
		} catch (Exception e) {
			throw e;
		}

		return resultado;
	}

	public boolean verificarSesion() {
		boolean estado;

		if (FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("usuario") == null) {
			estado = false;
		} else {
			estado = true;
		}

		return estado;
	}

	public String cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "index";
	}
}
