package com.server.service;

import com.client.service.GolService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.shared.modelo.Gol;
import com.shared.modelo.Jugador;
import com.shared.modelo.Partido;

public class GolServiceImpl extends RemoteServiceServlet implements GolService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5878770458921582972L;

	static {
//		ObjectifyService.register(Jugador.class);
//		ObjectifyService.register(Gol.class); 
//		ObjectifyService.register(EquipoRival.class); 

	}
	
	public boolean guardar(String nombreJugador) {
		
		boolean resultado=true;
//		Objectify ofy = ObjectifyService.begin();
//
//		// Simple create
//	//	Jugador jugador = new Jugador(nombreJugador);
//	//	Key<Jugador> jugador=new Key<Jugador>(Jugador.class, 1);
////		Gol gol=new Gol();
//////		gol.setJugador(new Key<Jugador>(Jugador.class, jugador.getIdJugador()));
////		Jugador jugador = ofy.g
////		gol.setJugador(jugador);
////		ofy.put(gol);
		
		return resultado;
	}
	
	/**
	 * Devuelve la cantidad de goles a favor en un partido. 
	 * @param key
	 * @return
	 */
	public int obtenerGolesAFavorDeUnPartido(Long idPartido){
		
		Objectify ofy = ObjectifyService.begin();

		Query<Gol> g = ofy.query(Gol.class);
					
		//Cambio el id del partido de long a key		
		Key<Partido> keyPartido = (new Key<Partido>(Partido.class, idPartido));

		g.filter("partido = ", (keyPartido));
		
		return g.count();
	}
}
