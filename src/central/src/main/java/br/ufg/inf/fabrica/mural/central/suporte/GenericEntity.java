package br.ufg.inf.fabrica.mural.central.suporte;

public abstract class GenericEntity {
	
	private long id;
	
	private Boolean hidden;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean isHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

}
