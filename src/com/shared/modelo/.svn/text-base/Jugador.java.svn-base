package com.shared.modelo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.jdo.annotations.NotPersistent;
import javax.persistence.Id;

public class Jugador implements Serializable{

	/**
	 * 
	 */

	@Id
	private Long idJugador;

	private String nombre;
	
	@NotPersistent
	private int cantidadGoles;
	
	@NotPersistent
	private ArrayList<GolesDetalleBean> cantidadGolesAUnEquipo;

	public Jugador() {
		this(null);
	}

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.cantidadGolesAUnEquipo=new ArrayList<GolesDetalleBean>();
	}

	public ArrayList<GolesDetalleBean> getCantidadGolesAUnEquipo() {
		return cantidadGolesAUnEquipo;
	}

	public void setCantidadGolesAUnEquipo(ArrayList<GolesDetalleBean> cantidadGolesAUnEquipo) {
		this.cantidadGolesAUnEquipo = cantidadGolesAUnEquipo;
	}

	public void setIdJugador(Long idJugador) {
		this.idJugador = idJugador;
	}

	public Long getIdJugador() {
		return idJugador;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setCantidadGoles(int cantidadGoles) {
		this.cantidadGoles = cantidadGoles;
	}

	public int getCantidadGoles() {
		return cantidadGoles;
	}

	
}
