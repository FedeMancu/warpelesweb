package com.shared.modelo;

import java.io.Serializable;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

/**
 * Bean utilizado por cada jugador para obtener cuantos goles le convirtio a cada equipo.
 * @author fmancuso
 *
 */
public class GolesDetalleBean implements Serializable{
	
	private String equipoRival;
	private int cantidadGoles;
	
	public String getEquipoRival() {
		return equipoRival;
	}

	public void setEquipoRival(String equipoRival) {
		this.equipoRival = equipoRival;
	}

	public int getCantidadGoles() {
		return cantidadGoles;
	}

	public void setCantidadGoles(int cantidadGoles) {
		this.cantidadGoles = cantidadGoles;
	}

	public GolesDetalleBean(){
		
	}
	
	public GolesDetalleBean(String equipoRival, int cantidadGoles){
		this.equipoRival=equipoRival;
		this.cantidadGoles=cantidadGoles;
	}
	
	public String toString(){
		
		return (equipoRival + ": "+cantidadGoles);
	}
}
