package com.client.baseEnMemoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Query;
import com.shared.modelo.Gol;
import com.shared.modelo.GolesDetalleBean;
import com.shared.modelo.Jugador;
import com.shared.modelo.Partido;

/**
 * Es una basura creada por el problema con la base de datos en el servidor
 * @author Federico
 *
 */

public class JugadoresEnMemoria {

	public static ArrayList<Jugador> obtenerJugadores(){
		
		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
		
		StringBuilder jugadores= new StringBuilder();
		
		jugadores.append("Fede-");
		jugadores.append("Nico-");
		jugadores.append("Juan-");
		jugadores.append("Cospel-");
		jugadores.append("Topo-");
		jugadores.append("Cristhian-");
		jugadores.append("Mati Navarro-");
		jugadores.append("Mati Herlein-");
		jugadores.append("Esteban-");
		jugadores.append("Gustavo-");
		jugadores.append("Uriel-");
		jugadores.append("Emi-");
		jugadores.append("Pato-");		
		jugadores.append("Ale Aguerri-");
		jugadores.append("Manuel-");
		jugadores.append("En Contra-");
		jugadores.append("Sin Anotar-");
		jugadores.append("Martin Heit-");
		jugadores.append("Aldo-");
		jugadores.append("Lea Tense-");
		jugadores.append("Lea Aguerri-");
		jugadores.append("Eduardo-");
		jugadores.append("Santi-");
		jugadores.append("Coti");
		
		String[] vectorJugadores = jugadores.toString().split("-");
		
		for(int i=0;i<vectorJugadores.length;i++){
			
			Jugador jugador=new Jugador();
			jugador.setNombre(vectorJugadores[i]);
			jugador.setCantidadGoles(0);
			
			listaJugadores.add(jugador);
			
		}
		
		return listaJugadores;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Jugador> obtenerJugadoresConSusGoles(String temporada, String campeonato) {
		
		if(temporada==null){
			
			temporada="";
		}
		
		if(campeonato==null){
			campeonato="";
		}
		
		ArrayList<Partido> partidos = PartidosEnMemoria.obtenerPartidos();
		
		ArrayList<Jugador> jugadores = obtenerJugadores();
		
		for (Partido partido: partidos) {

			String temporadaPartido=String.valueOf(partido.getAnio());
			String campeonatoPartido=String.valueOf(partido.getCampeonato());
			
			if(((!temporada.equals("") && temporadaPartido.equals(temporada))
					|| temporada.equals(""))
					&& ((!campeonato.equals("") && campeonatoPartido.equals(campeonato))
							|| campeonato.equals("")) ){
				
		//		List<GolesDetalleBean> listaDetalleGoles=new ArrayList<GolesDetalleBean>();

				String goles = partido.getAutoresDeGoles();
				goles = goles.substring(1, goles.length() - 1);

				if (!(goles.length() == 0)) {
					String[] vectorGoles = goles.split(",");
					
					for (int i = 0; i < vectorGoles.length; i++) {

						int index = obtenerPosicionDeJugador(vectorGoles[i]
								.trim(), jugadores);

						jugadores.get(index).setCantidadGoles(
								jugadores.get(index).getCantidadGoles() + 1);
						
						//Nuevo bloque para obtener la cantidad de goles por equipo
						 ArrayList<GolesDetalleBean> listaDetalleGoles = jugadores.get(index).getCantidadGolesAUnEquipo();
						 
						 int indexEquipo=obtenerPosicionDeEquipo(partido.getNombreEquipoRival(), listaDetalleGoles);
						 
						 if(indexEquipo==-1){
							 listaDetalleGoles.add(new GolesDetalleBean(partido.getNombreEquipoRival(),1));
						 }else{
							 listaDetalleGoles.get(indexEquipo).setCantidadGoles(listaDetalleGoles.get(indexEquipo).getCantidadGoles()+1);
						 }
					}

				}
			}		
			
		}
		
		Collections.sort(jugadores, new Comparator(){
			public int compare(Object o1,Object o2){
				Jugador j1=(Jugador) o1;
				Jugador j2=(Jugador) o2;
				if (j1.getCantidadGoles()>j2.getCantidadGoles()){
					return -1;
				}else if (j1.getCantidadGoles()<j2.getCantidadGoles()){
					return 1;
				}else{
					return 0;
				}
			
		}
				
		});
		
		for(Jugador jugador:jugadores){
			
			Collections.sort(jugador.getCantidadGolesAUnEquipo(), new Comparator(){
				public int compare(Object o1,Object o2){
					GolesDetalleBean j1=(GolesDetalleBean) o1;
					GolesDetalleBean j2=(GolesDetalleBean) o2;
					if (j1.getCantidadGoles()>j2.getCantidadGoles()){
						return -1;
					}else if (j1.getCantidadGoles()<j2.getCantidadGoles()){
						return 1;
					}else{
						return 0;
					}
				
			}
					
			});
		}
		
	return jugadores;
}
	
	
	private static int obtenerPosicionDeJugador(String nombreJugador, ArrayList<Jugador> lista){
		
		for(int i=0; i<lista.size();i++){
			
			if(lista.get(i).getNombre().equals(nombreJugador)){
				
				return i;
				
			}
			
		}
		
		return -1;
		
	}
	
	private static int obtenerPosicionDeEquipo(String nombreEquipo, ArrayList<GolesDetalleBean> lista){
		
		for(int i=0; i<lista.size();i++){
			
			if(lista.get(i).getEquipoRival().equals(nombreEquipo)){
				
				return i;
				
			}
			
		}
		
		return -1;
		
	}
}