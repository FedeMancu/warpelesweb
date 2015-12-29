package com;

import java.util.ArrayList;

import com.client.baseEnMemoria.JugadoresEnMemoria;
import com.client.baseEnMemoria.PartidosEnMemoria;
import com.shared.modelo.GolesDetalleBean;
import com.shared.modelo.Jugador;

public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JugadoresEnMemoria algo=new JugadoresEnMemoria();
		
		ArrayList<Jugador> resultado = algo.obtenerJugadoresConSusGoles("2012", "Clausura");
		
		for(Jugador jugador:resultado){
			
			System.out.println("*************************************************");
			System.out.println(jugador.getNombre());
			for(GolesDetalleBean detalle:jugador.getCantidadGolesAUnEquipo())
			
				System.out.println(detalle.toString());
			
			System.out.println("********************** "+ jugador.getCantidadGoles() +" **************************");

		}
	}

}
