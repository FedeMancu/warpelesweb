package com.server.service;

import java.util.ArrayList;

import com.client.service.EquipoRivalService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.shared.modelo.EquipoRival;

public class EquipoRivalServiceImpl extends RemoteServiceServlet implements EquipoRivalService{
	
//	private static Logger logger = Logger.getLogger("csv");

	/**
	 * 
	 */
	private static final long serialVersionUID = -159165766152455619L;

	static {
//		ObjectifyService.register(Jugador.class);
//		ObjectifyService.register(Gol.class);
//		ObjectifyService.register(EquipoRival.class);
	}

	public boolean guardar(String nombre) {
		
		boolean resultado=false;
		Objectify ofy = ObjectifyService.begin();
		EquipoRival equipoRival = new EquipoRival(nombre);
		
		//Busca si ya existe el equipo rival
		EquipoRival equipo = ofy.query(EquipoRival.class).filter("nombre = ", nombre).get();
		
		if(equipo==null){
			ofy.put(equipoRival);
			resultado=true;
//			logger.info("Se creo el rival: "+nombre);
		}else{
//			logger.info("El rival: "+nombre+" ya existe.");
		}		
		
		return resultado;
	}
 
	public ArrayList<EquipoRival> obtenerEquiposRivales() {
		ArrayList<EquipoRival> equipos = new ArrayList<EquipoRival>();
		
		Objectify ofy = ObjectifyService.begin();
		Query<EquipoRival> q = ofy.query(EquipoRival.class).order("-nombre");
			for (EquipoRival equipo: q) {
				  equipos.add(equipo);
			}		
		
//		logger.info("Se obtuvieron los equipos: "+equipos.toString());

		return equipos;
	}
	
	public EquipoRival validarEquipoRival(String rival){
		
		Objectify ofy = ObjectifyService.begin();
		
		EquipoRival equipo = ofy.query(EquipoRival.class).filter("nombre = ", rival).get();
		
		if(equipo==null){
//			logger.error("No encontro el equipo");
			
		}
		
		return equipo;
	}
	
	

}