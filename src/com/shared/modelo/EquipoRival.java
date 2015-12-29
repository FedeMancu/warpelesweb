package com.shared.modelo;

import java.io.Serializable;
import javax.persistence.Id;


public class EquipoRival implements Serializable{

	/**
	 * 
	 */

	@Id
	private Long id;

	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public EquipoRival(String nombre){
		this.nombre=nombre;
	}
	
	public EquipoRival(){
		
	}

}
