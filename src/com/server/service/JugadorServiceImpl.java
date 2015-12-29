package com.server.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.client.service.JugadorService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.shared.modelo.Gol;
import com.shared.modelo.Jugador;
import com.shared.modelo.Partido;

public class JugadorServiceImpl extends RemoteServiceServlet implements JugadorService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7650508376258185728L;

	static {
//		ObjectifyService.register(Jugador.class);
//		ObjectifyService.register(Gol.class);
	}
	
//	private static Logger logger = Logger.getLogger("csv");


	public boolean guardar(String nombre) {
		
		boolean resultado=false;
		Objectify ofy = ObjectifyService.begin();

		Jugador jugador = new Jugador(nombre);
		
		//Busca si ya existe el jugador
		Jugador player = ofy.query(Jugador.class).filter("nombre = ", nombre).get();
		
		if(player==null){
			ofy.put(jugador);
			resultado=true;
//			logger.info("Se creo el jugador: "+nombre);
			}else{
//				logger.info("El jugador: "+nombre+" ya existe.");
			}
		
		return resultado;
	}

	public ArrayList<Jugador> obtenerJugadores() {
		ArrayList<Jugador> personas = new ArrayList<Jugador>();
		
		Objectify ofy = ObjectifyService.begin();
		Query<Jugador> q = ofy.query(Jugador.class);
			for (Jugador jugador: q) {
				  personas.add(jugador);
			}		
		
//		logger.info("Se obtuvieron los equipos: "+personas.toString());
		
		return personas;
	}

	public long obtenerID(String nombreJugador) {
		
		Objectify ofy = ObjectifyService.begin();
		Jugador player = ofy.query(Jugador.class).filter("nombre = ", nombreJugador).get();
		
		if(player!=null){
			return player.getIdJugador();
		}
		else return -1;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Jugador> obtenerJugadoresConSusGoles(String temporada, String campeonato) {
		
		Objectify ofy = ObjectifyService.begin();
		
		ArrayList<Jugador> jugadores = obtenerJugadores();
		
		Query<Partido> p = ofy.query(Partido.class);
		
		if(!(temporada==null) && !(temporada.equals(""))){
			p.filter("anio = ", Integer.valueOf(temporada));
		}
		
		if(!(campeonato==null) && !(campeonato.equals(""))){
			p.filter("campeonato = ", campeonato);
		}
		
		for (int i=0;i<jugadores.size();i++){
			
					
			for (Partido partido: p) {

				Key<Partido> keyPartido = (new Key<Partido>(Partido.class, partido.getIdPartido()));

				Key<Jugador> keyJugador = (new Key<Jugador>(Jugador.class, jugadores.get(i).getIdJugador()));

				Query<Gol> query = ofy.query(Gol.class).filter("jugador", keyJugador);
				query.filter("partido", keyPartido);
				
				int resultado=query.count();
				jugadores.get(i).setCantidadGoles(resultado+jugadores.get(i).getCantidadGoles());
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
		
		return jugadores;
	}

	public boolean validarJugador(String nombreJugador) {
		
		Objectify ofy = ObjectifyService.begin();
		
		Jugador jugador = ofy.query(Jugador.class).filter("nombre = ", nombreJugador).get();
		
		if(jugador==null){
//			logger.error("No encontro al jugador con nombre "+nombreJugador);
			return false;
		}		
		return true;
		
	}

}
