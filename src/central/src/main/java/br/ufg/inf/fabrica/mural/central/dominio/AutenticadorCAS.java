package br.ufg.inf.fabrica.mural.central.dominio;

import br.ufg.inf.fabrica.mural.central.persistencia.CAS;

public class AutenticadorCAS {
	
	public Boolean validarCredencial(Usuario usuario) {
		CAS cas = new CAS();
		
		return cas.validarCredencial(usuario);
	}

}
