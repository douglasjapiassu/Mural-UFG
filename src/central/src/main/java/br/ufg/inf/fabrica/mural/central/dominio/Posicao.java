package br.ufg.inf.fabrica.mural.central.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.ufg.inf.fabrica.mural.central.suporte.GenericEntity;

@Entity
public class Posicao extends GenericEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;*/
	private Double latitude;
	private Double longitude;
	
	public Posicao() {
		
	}
	
	public Posicao(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/*public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}*/
	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
