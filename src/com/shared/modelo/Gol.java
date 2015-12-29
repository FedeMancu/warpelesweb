package com.shared.modelo;

import java.io.Serializable;

import javax.persistence.Id;

import com.googlecode.objectify.Key;

public class Gol implements Serializable{

	/**
	 * 
	 */

	@Id
	private Long id;

	private Key<Jugador> jugador;
	
	private Key<Partido> partido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Key<Jugador> getJugador() {
		return jugador;
	}

	public void setJugador(Key<Jugador> jugador) {
		this.jugador = jugador;
	}

	public void setPartido(Key<Partido> partido) {
		this.partido = partido;
	}

	public Key<Partido> getPartido() {
		return partido;
	}
}
