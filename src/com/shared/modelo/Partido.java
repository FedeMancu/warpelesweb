package com.shared.modelo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.jdo.annotations.NotPersistent;
import javax.persistence.Id;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Indexed;

public class Partido implements Serializable {

	/**
	 * 
	 */

	@Id @Indexed
	private Long idPartido;
	
	private int numeroDePartido;
	
	private Key<EquipoRival> equipoRival;
	
	@NotPersistent
	private String nombreEquipoRival;
			
	private int golesEnContra;
	
	@NotPersistent
	private String resultado;
	
	@NotPersistent
	private String autoresDeGoles;
	
	private int numeroDeFecha;
	
	private int anio;
	
	private String campeonato;

	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}

	public Long getIdPartido() {
		return idPartido;
	}

	public void setEquipoRival(Key<EquipoRival> equipoRival) {
		this.equipoRival = equipoRival;
	}

	public Key<EquipoRival> getEquipoRival() {
		return equipoRival;
	}

	public void setGolesEnContra(int golesEnContra) {
		this.golesEnContra = golesEnContra;
	}

	public int getGolesEnContra() {
		return golesEnContra;
	}

	public void setNumeroDeFecha(int numeroDeFecha) {
		this.numeroDeFecha = numeroDeFecha;
	}

	public int getNumeroDeFecha() {
		return numeroDeFecha;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getAnio() {
		return anio;
	}

	public void setCampeonato(String campeonato) {
		this.campeonato = campeonato;
	}

	public String getCampeonato() {
		return campeonato;
	}
	
	public Partido(){
		
	}

	public void setNombreEquipoRival(String nombreEquipoRival) {
		this.nombreEquipoRival = nombreEquipoRival;
	}

	public String getNombreEquipoRival() {
		return nombreEquipoRival;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getResultado() {
		return resultado;
	}

	public void setAutoresDeGoles(String autoresDeGoles) {
		this.autoresDeGoles = autoresDeGoles;
	}

	public String getAutoresDeGoles() {
		return autoresDeGoles;
	}

	public void setNumeroDePartido(int numeroDePartido) {
		this.numeroDePartido = numeroDePartido;
	}

	public int getNumeroDePartido() {
		return numeroDePartido;
	}
	
	
}
