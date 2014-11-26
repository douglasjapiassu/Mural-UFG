package br.ufg.inf.fabrica.mural.central.dominio;

import br.ufg.inf.fabrica.mural.central.suporte.GenericEntity;

public class Usuario extends GenericEntity {
	
	private String login;
	private String senha;
	private Boolean apenasProdutor;
	private Boolean administrador;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Boolean getApenasProdutor() {
		return apenasProdutor;
	}
	
	public void setApenasProdutor(Boolean apenasProdutor) {
		this.apenasProdutor = apenasProdutor;
	}
	
	public Boolean getAdministrador() {
		return administrador;
	}
	
	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}

}