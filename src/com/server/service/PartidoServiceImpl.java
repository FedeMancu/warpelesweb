package com.server.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.client.service.PartidoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.shared.modelo.EquipoRival;
import com.shared.modelo.Gol;
import com.shared.modelo.Jugador;
import com.shared.modelo.Partido;

public class PartidoServiceImpl extends RemoteServiceServlet implements PartidoService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1651881060968005967L;


	static {
		// FIXME
//		ObjectifyService.register(Jugador.class);
//		ObjectifyService.register(Gol.class);
//		ObjectifyService.register(Partido.class);
//		ObjectifyService.register(EquipoRival.class);

	}
	
//	private static Logger logger = Logger.getLogger("csv");


	public boolean guardar(String golesEnContra, String numeroDeFecha,
			String anio, String nombreCampeonato, List<String> autoresDeGoles,
			EquipoRival rival) {

		boolean resultado=false;
		
		
		Objectify ofy = ObjectifyService.begin();
		
		EquipoRival equipo = ofy.query(EquipoRival.class).filter("nombre = ", rival.getNombre()).get();
		
		if(equipo==null){
//			logger.error("No encontro al jugador autor de un gol al persistir el partido");
			return false;
		}
		
		Key<EquipoRival> keyEquipo = (new Key<EquipoRival>(EquipoRival.class, equipo.getId()));
				
		if(keyEquipo==null){
//			logger.error("No encontro el equipo al persistir el partido");
			return false;
		}
		
		int numeroDePartido=obtenerCantidadDePartidos()+1;
		
		Partido partidoNuevo=new Partido();
		partidoNuevo.setNumeroDePartido(numeroDePartido);
		partidoNuevo.setAnio(Integer.valueOf(anio));
		partidoNuevo.setNumeroDeFecha(Integer.valueOf(numeroDeFecha));
		partidoNuevo.setCampeonato(nombreCampeonato);
		partidoNuevo.setGolesEnContra(Integer.valueOf(golesEnContra));
		partidoNuevo.setEquipoRival(keyEquipo);
		
		ofy.put(partidoNuevo);
		
		Key<Partido> keyPartido = new Key<Partido>(Partido.class, partidoNuevo.getIdPartido());
		
		if(keyPartido==null){
//			logger.error("No encontro al partido luego de crearlo!!");
			return false;
		}
		
		for(int i=0;i<autoresDeGoles.size();i++){
			
			Gol gol =new Gol();
						
			Jugador jugadorAux = ofy.query(Jugador.class).filter("nombre = ", autoresDeGoles.get(i)).get();
			
			if(jugadorAux==null){
//				logger.error("No encontro al jugador por el nombre");
				return false;
			}
			
			Key<Jugador> keyJugador = (new Key<Jugador>(Jugador.class, jugadorAux.getIdJugador()));
					
			if(keyJugador==null){
//				logger.error("No encontro al jugador por el ID");
				return false;
			}
			
			gol.setJugador(keyJugador);
			gol.setPartido(keyPartido);
			
			ofy.put(gol);
		}
		
		resultado=true;
		
		return resultado;
	}


	/**
	 * Aclaracion: Primero se cargan todos los equipos y jugadores y despues 
	 * los partidos. En total son 3 archivos.
	 * 
	 * Los partidos tienen el siguiente formato.
	 * TEMPORADA-CAMPEONATO-NUM DE FECHA-RIVAL-GOLES A FAVOR-GOLES EN CONTRA-NOMBRES
	 * DE LOS GOLEADORES
	 * Los goleadores se separan con un '-' (guion)
	 * @author Federico
	 *
	 */
	@Override
	public boolean realizarCarga() throws IOException {
		
		PartidoServiceImpl servicePartido = new PartidoServiceImpl();
		JugadorServiceImpl serviceJugador= new JugadorServiceImpl();
		EquipoRivalServiceImpl serviceEquipo= new EquipoRivalServiceImpl();
		
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
		jugadores.append("Sin Anotar");



		StringTokenizer tokenJugadores = new StringTokenizer(jugadores.toString(), "-");

		while (tokenJugadores.hasMoreElements()) {
			serviceJugador.guardar((String) tokenJugadores.nextElement());
		}
		
		StringBuilder equipos= new StringBuilder();
		
		equipos.append("VLP-");
		equipos.append("Borbotones-");
		equipos.append("Media Maquina-");
		equipos.append("Joga Bonito-");
		equipos.append("Ferneteados-");
		equipos.append("Hidalgo-");
		equipos.append("Somos Seis-");
		equipos.append("Mirinda-");
		equipos.append("Scratch-");
		equipos.append("Futbol Champagne-");
		equipos.append("Ferreteros-");
		equipos.append("Figurita Repetida-");
		equipos.append("La Marina-");
		equipos.append("Sandman-");
		equipos.append("Los Huevos-");
		equipos.append("Jugo De Uva-");
		equipos.append("Cerini-");
		equipos.append("La Kuky-");
		equipos.append("Embrujo-");
		equipos.append("Papagartes-");
		equipos.append("Rica La Pulpa-");
		equipos.append("Chivo-");
		equipos.append("Charly Forever-");
		equipos.append("Embrujo-");
		equipos.append("Rustikos-");
		
		equipos.append("Aserrin-");
		equipos.append("Belgrano-");
		equipos.append("Ben Hur-");
		equipos.append("Deportivo Gambeta-");
		equipos.append("El Ciclon-");
		equipos.append("El Dish-");
		equipos.append("El Rejunte-");
		equipos.append("Florida-");
		equipos.append("Gatoreit-");
		equipos.append("La Macoña-");
		equipos.append("La Nutria-");
		equipos.append("Magia-");
		equipos.append("Muñequito-");
		equipos.append("Piratas-");
		equipos.append("Por La Coca-");
		equipos.append("Primates-");
		equipos.append("Pueblito-");
		equipos.append("Real Mandril-");
		equipos.append("Salchichon-");
		equipos.append("Salseros-");
		equipos.append("Sandwiches Raul-");
		equipos.append("Taiwan-");
		equipos.append("Taladro-");
		equipos.append("Termidor-");
		equipos.append("Tolouse-");
		equipos.append("Venimos De Gira-");
		
		equipos.append("Alacantula-");
		equipos.append("Alkitran-");
		equipos.append("C Men-");
		equipos.append("Ebrad-");
		equipos.append("El Dedo-");
		equipos.append("Faca-");
		equipos.append("Franja De Oro-");
		equipos.append("Halcones-");
		equipos.append("Hay Equipo-");
		equipos.append("Los Mismos De Siempre-");
		equipos.append("Michagar-");
		equipos.append("Olimpiakos-");
		equipos.append("Ottoo-");
		equipos.append("Paso A Paso-");
		equipos.append("Real Coholicos-");
		equipos.append("Resta-");
		equipos.append("Villa Adelina-");
		
		equipos.append("Apo-");
		equipos.append("Cocodrilo-");
		equipos.append("Cosme Fulanito-");
		equipos.append("Deportivo Empate-");
		equipos.append("Franco Canadiense-");
		equipos.append("Internados-");
		equipos.append("Juguemos Los Sabados-");
		equipos.append("Oporto-");
		equipos.append("Pipiolos-");
		equipos.append("Puchi-");
		equipos.append("Quien Ataja-");
		equipos.append("Rusticos Champagne-");
		equipos.append("Sara Goza-");
		equipos.append("Sin Anestesia-");
		equipos.append("Toronja Mecanica-");
		equipos.append("Toscana-");
		equipos.append("Totenham-");

		equipos.append("Trotsky-");
		equipos.append("Imhotep-");
		equipos.append("Veni Que Te Explico-");
		equipos.append("Los Bebus-");
		equipos.append("Desde Abajo-");
		equipos.append("El Tero-");
		equipos.append("Corona FC-");
		equipos.append("Weylon-");
		equipos.append("Son Negocios-");
		equipos.append("Dumbin-");
		equipos.append("Bison Lyon-");
		equipos.append("Orson Blanco-");
		equipos.append("Malwi Futsal-");
		equipos.append("La Calle-");
		equipos.append("Vizcarra-");

		equipos.append("Alfileres Y Bidones-");
		equipos.append("Electrograma-");
		equipos.append("Humildad Y Corazon-");
		equipos.append("La Legua-");
		equipos.append("La Rebelion-");
		equipos.append("Los Del Balcon-");
		equipos.append("Los Vagos-");
		equipos.append("Tu Hermanito");


		
		StringTokenizer tokenEquipos = new StringTokenizer(equipos.toString(), "-");

		while (tokenEquipos.hasMoreElements()) {
			serviceEquipo.guardar((String) tokenEquipos.nextElement());
		}
		
		StringBuilder partidos= new StringBuilder();
		
		partidos.append("2007/Fase clasificatoria/1/VLP/3/7/Cospel-Topo-Nico.");
		partidos.append("2007/Fase clasificatoria/2/Borbotones/3/13/Fede-Fede-Cristhian.");
		partidos.append("2007/Fase clasificatoria/3/Media Maquina/5/1/Cospel-Cospel-Fede-Fede-Nico.");
		partidos.append("2007/Fase clasificatoria/4/Joga Bonito/3/14/Juan-Cospel-Fede.");
		partidos.append("2007/Fase clasificatoria/5/Ferneteados/4/3/Cospel-Cospel-Juan-Juan.");
		partidos.append("2007/Fase clasificatoria/6/Hidalgo/5/11/Juan-Juan-Juan-Nico-Cospel.");
		partidos.append("2007/Fase clasificatoria/7/Somos Seis/4/3/Juan-Juan-Fede-Fede.");
		partidos.append("2007/Apertura/1/Mirinda/3/2/Topo-Cristhian-Cospel.");
		partidos.append("2007/Apertura/2/Somos Seis/3/4/Cospel-Cospel-Cristhian.");
		partidos.append("2007/Apertura/3/Scratch/2/4/Cristhian-Juan.");
		partidos.append("2007/Apertura/4/Futbol Champagne/4/4/Juan-Gustavo-Fede-Cristhian.");
		partidos.append("2007/Apertura/5/Ferreteros/1/9/Cospel.");
		partidos.append("2007/Apertura/6/Figurita Repetida/4/3/Juan-Cospel-Nico-Nico.");
		partidos.append("2007/Apertura/7/La Marina/1/6/Cospel.");
		partidos.append("2007/Reducido/1/Figurita Repetida/7/4/Topo-Nico-Cristhian-Cospel-Cospel-Juan-Juan.");
		partidos.append("2007/Reducido/2/Sandman/3/6/Cospel-Nico-Gustavo.");
		partidos.append("2007/Reducido/3/Los Huevos/5/7/Cospel-Cospel-Juan-Nico-Nico.");
		partidos.append("2007/Copa de invierno/1/Figurita Repetida/2/3/Cristhian-Cospel.");
		partidos.append("2007/Copa de invierno/2/Jugo De Uva/2/0/Cospel-Juan.");
		partidos.append("2007/Copa de invierno/3/Somos Seis/1/7/Nico.");
		partidos.append("2007/Clausura/1/Figurita Repetida/3/6/Cospel-Juan-Cristhian.");
		partidos.append("2007/Clausura/2/Cerini/5/7/Cospel-Cospel-Cospel-Topo-Nico.");
		partidos.append("2007/Clausura/3/Borbotones/3/7/Nico-Juan-Juan.");
		partidos.append("2007/Clausura/4/La Kuky/10/2/Cospel-Cospel-Juan-Juan-Nico-Nico-Nico-Cristhian-Cristhian-Gustavo.");
		partidos.append("2007/Clausura/5/Futbol Champagne/1/5/Cristhian.");
		partidos.append("2007/Clausura/6/Embrujo/8/2/Esteban-Esteban-Esteban-Juan-En Contra-Cospel-Nico-Nico.");
		partidos.append("2007/Clausura/7/Papagartes/8/2/Cospel-Cospel-Cospel-Nico-Nico-Esteban-Fede-En Contra.");
		partidos.append("2007/Clausura/8/Rica La Pulpa/2/3/Juan-Juan.");
		partidos.append("2007/Clausura/9/Ferneteados/3/3/Nico-Nico-Fede.");
		partidos.append("2007/Clausura/10/Chivo/3/11/Cospel-Cristhian-En Contra.");
		partidos.append("2007/Clausura/11/Charly Forever/3/8/Esteban-Cospel-Nico.");
		partidos.append("2007/Promocion Ascenso/1/Embrujo/0/5/.");
		partidos.append("2007/Promocion Ascenso/2/Rustikos/1/3/Juan.");
		partidos.append("2007/Promocion Ascenso/3/Ferneteados/1/2/Nico.");
		
		partidos.append("2008/Apertura/1/Florida/2/9/Juan-Nico.");
		partidos.append("2008/Apertura/2/Pueblito/2/8/Cristhian-Nico.");
		partidos.append("2008/Apertura/3/Figurita Repetida/4/8/Nico-Nico-Nico-Esteban.");
		partidos.append("2008/Apertura/4/Piratas/2/9/Juan-Cristhian.");
		partidos.append("2008/Apertura/5/Ben Hur/0/1/.");
		partidos.append("2008/Apertura/6/Salchichon/2/5/Nico-Fede.");
		partidos.append("2008/Apertura/7/Termidor/3/1/Cospel-Cospel-Juan.");
		partidos.append("2008/Apertura/8/La Marina/8/2/Cospel-Cospel-Esteban-Esteban-Nico-Nico-Juan-En Contra.");
		partidos.append("2008/Apertura/9/Papagartes/6/3/Nico-Nico-Esteban-Esteban-Cristhian-Cristhian.");
		partidos.append("2008/Apertura/10/Magia/1/5/Juan.");
		partidos.append("2008/Apertura/11/Aserrin/8/2/Nico-Nico-Nico-Esteban-Esteban-Esteban-Cristhian-Fede.");
		partidos.append("2008/Apertura/12/Scratch/5/6/Cospel-Cospel-Esteban-Esteban-Juan.");
		partidos.append("2008/Apertura/13/Gatoreit/2/5/Cospel-Esteban.");
		partidos.append("2008/Copa de invierno/1/Sandwiches Raul/3/8/Juan-Esteban-Cristhian.");
		partidos.append("2008/Promocion Descenso/1/La Macoña/1/4/Nico.");
		partidos.append("2008/Promocion Descenso/2/La Marina/2/1/Esteban-Esteban.");
		partidos.append("2008/Promocion Descenso/3/El Dish/3/3/Cospel-Juan-Esteban.");
		partidos.append("2008/Copa de invierno/2/Venimos De Gira/1/1/Topo.");
		partidos.append("2008/Copa de invierno/3/Tolouse/10/3/Nico-Nico-Nico-Esteban-Esteban-Juan-Juan-Cospel-Cospel-Mati Navarro.");
		partidos.append("2008/Copa de invierno/4/Real Mandril/4/3/Juan-Juan-Nico-Esteban.");
		partidos.append("2008/Copa de invierno/5/Figurita Repetida/4/3/Esteban-Esteban-Cospel-Cospel.");
		partidos.append("2008/Copa de invierno/6/Belgrano/2/1/Juan-Nico.");
		partidos.append("2008/Copa de invierno/7/Los Huevos/0/2/.");
		partidos.append("2008/Copa de invierno/8/Salseros/1/5/Cospel.");
		partidos.append("2008/Clausura/1/Primates/2/3/Nico-Cristhian.");
		partidos.append("2008/Clausura/2/Pueblito/3/7/Esteban-Esteban-Juan.");
		partidos.append("2008/Clausura/3/Deportivo Gambeta/4/2/Cospel-Cospel-Esteban-Juan.");
		partidos.append("2008/Clausura/4/Por La Coca/3/7/Cospel-Esteban-Gustavo.");
		partidos.append("2008/Clausura/5/Taiwan/2/10/Cospel-Esteban.");
		partidos.append("2008/Clausura/6/El Ciclon/3/4/Esteban-Cospel-Nico.");
		partidos.append("2008/Clausura/7/Figurita Repetida/5/2/Cristhian-Cospel-Esteban-Nico-Juan.");
		partidos.append("2008/Clausura/8/La Nutria/2/3/Juan-Nico.");
		partidos.append("2008/Clausura/9/Salseros/6/9/Cospel-Cospel-Esteban-Esteban-Juan-Nico.");
		partidos.append("2008/Promocion Descenso/1/Figurita Repetida/2/5/Nico-Nico.");
		partidos.append("2008/Promocion Descenso/2/Taladro/2/7/Cospel-Nico.");
		partidos.append("2008/Promocion Descenso/3/Venimos De Gira/1/3/Nico.");
		partidos.append("2008/Promocion Descenso/4/El Rejunte/3/6/Esteban-Esteban-Juan.");
		partidos.append("2008/Promocion Descenso/5/Muñequito/3/2/Juan-Juan-Esteban.");
		partidos.append("2008/Copa Libertadores/1/Joga Bonito/2/10/Juan-Juan.");
		partidos.append("2008/Copa Libertadores/2/Papagartes/1/3/Esteban.");
		partidos.append("2008/Copa Libertadores/3/Por La Coca/4/1/Cospel-Cospel-Cospel-Cristhian.");

		partidos.append("2009/Apertura/1/Paso A Paso/7/7/Esteban-Esteban-Esteban-Esteban-Juan-Nico-Cristhian.");
		partidos.append("2009/Apertura/2/Futbol Champagne/5/6/Esteban-Esteban-Esteban-Esteban-Nico.");
		partidos.append("2009/Apertura/3/Papagartes/10/2/Esteban-Esteban-Esteban-Esteban-Nico-Nico-Cristhian-Cristhian-Fede-Fede.");
		partidos.append("2009/Apertura/4/Hay Equipo/5/3/Esteban-Esteban-Juan-Juan-Cristhian.");
		partidos.append("2009/Apertura/5/Villa Adelina/5/7/Cospel-Cospel-Juan-Nico-En Contra.");
		partidos.append("2009/Apertura/6/C Men/1/7/Cristhian.");
		partidos.append("2009/Apertura/7/Franja De Oro/0/2/.");
		partidos.append("2009/Apertura/8/Los Mismos De Siempre/4/1/Cospel-Cospel-Esteban-Nico.");
		partidos.append("2009/Apertura/9/Real Coholicos/4/2/Juan-Juan-Cristhian-Nico.");
		partidos.append("2009/Apertura/10/Alkitran/0/10/.");
		partidos.append("2009/Apertura/11/Alacantula/8/2/Nico-Nico-Nico-Juan-Cristhian-Cospel-Gustavo-Esteban.");
		partidos.append("2009/Apertura/12/Halcones/5/2/Cospel-Cospel-Cospel-Cospel-Nico.");
		partidos.append("2009/Promocion Ascenso/1/Gatoreit/1/0/Nico.");
		partidos.append("2009/Promocion Ascenso/2/Los Mismos De Siempre/0/4/.");
		partidos.append("2009/Promocion Ascenso/3/Venimos De Gira/3/0/Esteban-Esteban-Gustavo.");
		partidos.append("2009/Clausura/1/Gatoreit/1/6/Fede.");
		partidos.append("2009/Clausura/2/Taiwan/0/1/.");
		partidos.append("2009/Clausura/3/Villa Adelina/4/5/Nico-Nico-Fede-Fede.");
		partidos.append("2009/Clausura/4/Rustikos/2/5/Nico-Fede.");
		partidos.append("2009/Clausura/5/Ferneteados/4/4/Juan-Juan-Esteban-Esteban.");
		partidos.append("2009/Clausura/6/Michagar/2/7/Esteban-Juan.");
		partidos.append("2009/Clausura/7/El Rejunte/3/7/Nico-Cospel-Cristhian.");
		partidos.append("2009/Clausura/8/Faca/2/3/Sin Anotar-Sin Anotar.");
		partidos.append("2009/Clausura/9/Ottoo/7/5/Esteban-Esteban-Esteban-Cospel-Cospel-Nico-Nico.");
		partidos.append("2009/Clausura/10/Olimpiakos/2/10/Sin Anotar-Sin Anotar.");
		partidos.append("2009/Clausura/11/Los Mismos De Siempre/2/4/Juan-Nico.");
		partidos.append("2009/Clausura/12/Resta/2/3/Nico-Cristhian.");
		partidos.append("2009/Promocion Descenso/1/El Dedo/0/6/.");
		partidos.append("2009/Promocion Descenso/2/Gatoreit/0/2/.");
		partidos.append("2009/Promocion Descenso/3/Ebrad/2/6/Nico-Cospel.");
		
		
		partidos.append("2010/Apertura/1/Gatoreit/8/10/Esteban-Esteban-Esteban-Topo-Topo-Juan-Fede-Cospel.");
		partidos.append("2010/Apertura/2/Internados/3/10/Nico-Nico-En Contra.");
		partidos.append("2010/Apertura/3/Pipiolos/2/5/Esteban-Cospel.");
		partidos.append("2010/Apertura/4/Sin Anestesia/2/7/Esteban-Esteban.");
		partidos.append("2010/Apertura/5/Ottoo/1/5/Cospel.");
		partidos.append("2010/Apertura/6/Franco Canadiense/10/3/Esteban-Esteban-Esteban-Esteban-Esteban-Esteban-Nico-Nico-Mati Herlein-Cristhian.");
		partidos.append("2010/Apertura/7/Oporto/4/2/Juan-Juan-Mati Herlein-Esteban.");
		partidos.append("2010/Apertura/8/Puchi/3/2/Mati Herlein-Nico-Esteban.");
		partidos.append("2010/Apertura/9/Paso A Paso/6/3/Juan-Juan-Nico-Nico-Esteban-Esteban.");
		partidos.append("2010/Apertura/10/Rica La Pulpa/3/6/Juan-Esteban-Mati Herlein.");
		partidos.append("2010/Apertura/11/Cosme Fulanito/3/7/Esteban-Esteban-Fede.");
		partidos.append("2010/Apertura/12/Cocodrilo/5/11/Nico-Nico-Juan-Topo-Mati Herlein.");
		partidos.append("2010/Clausura/1/Quien Ataja/4/5/Mati Herlein-Mati Herlein-Mati Herlein-Esteban.");
		partidos.append("2010/Clausura/2/Deportivo Empate/3/2/Cospel-Mati Herlein-Esteban.");
		partidos.append("2010/Clausura/3/Oporto/6/1/Mati Herlein-Mati Herlein-Mati Herlein-Mati Herlein-Nico-Cospel.");
		partidos.append("2010/Clausura/4/Franco Canadiense/3/4/Mati Herlein-Mati Herlein-Fede.");
		partidos.append("2010/Clausura/5/Rusticos Champagne/5/1/Mati Herlein-Mati Herlein-Mati Herlein-Nico-Esteban.");
		partidos.append("2010/Clausura/6/Apo/3/2/Cospel-Cospel-Mati Herlein.");
		partidos.append("2010/Clausura/7/Totenham/4/2/Mati Herlein-Mati Herlein-Esteban-Juan.");
		partidos.append("2010/Clausura/8/Toronja Mecanica/3/3/Cospel-Cospel-Nico.");
		partidos.append("2010/Clausura/9/Juguemos Los Sabados/2/4/Mati Herlein-Topo.");
		partidos.append("2010/Clausura/10/Sara Goza/2/10/Mati Herlein-Cospel.");
		partidos.append("2010/Reducido/1/Juguemos Los Sabados/5/2/Mati Herlein-Mati Herlein-Mati Herlein-Cospel-Cospel.");
		partidos.append("2010/Reducido/2/Sara Goza/2/6/Mati Herlein-Cospel.");
		partidos.append("2010/Promocion Ascenso/1/Sara Goza/2/2/Mati Herlein-Esteban.");
		partidos.append("2010/Promocion Ascenso/2/Toscana/4/1/Cospel-Cospel-Esteban-Esteban.");
		partidos.append("2010/Promocion Ascenso/3/Rica La Pulpa/7/2/Mati Herlein-Mati Herlein-Mati Herlein-Juan-Juan-Nico-Cospel.");

		partidos.append("2011/Apertura/1/Totenham/6/5/Mati Herlein-Mati Herlein-Esteban-Esteban-Juan-Cospel.");
		partidos.append("2011/Apertura/2/Toscana/2/5/Juan-Esteban.");
		partidos.append("2011/Apertura/3/Deportivo Empate/3/2/Mati Herlein-Mati Herlein-Esteban.");
		partidos.append("2011/Apertura/4/Trotsky/2/2/Cospel-Mati Herlein.");
		partidos.append("2011/Apertura/5/Imhotep/1/3/Esteban.");
		partidos.append("2011/Apertura/6/Veni Que Te Explico/3/6/Esteban-Cospel-Mati Herlein.");
		partidos.append("2011/Apertura/7/Los Bebus/2/5/Esteban-Nico.");
		partidos.append("2011/Apertura/8/Desde Abajo/5/3/Esteban-Esteban-Esteban-Mati Herlein-Mati Herlein.");
		partidos.append("2011/Apertura/9/El Tero/4/5/Nico-Mati Herlein-Cospel-En Contra.");
		partidos.append("2011/Apertura/10/Corona FC/0/5/.");
		partidos.append("2011/Apertura/11/Weylon/6/3/Esteban-Esteban-Esteban-Cospel-Mati Herlein-En Contra.");
		partidos.append("2011/Promocion Descenso/1/Toscana/2/1/Esteban-Mati Herlein.");
		partidos.append("2011/Promocion Descenso/2/Son Negocios/1/2/Mati Herlein.");
		partidos.append("2011/Promocion Descenso/3/Dumbin/1/7/Cospel.");
		partidos.append("2011/Clausura/1/Bison Lyon/1/7/Esteban.");
		partidos.append("2011/Clausura/2/Imhotep/3/4/Nico-Nico-Cospel.");
		partidos.append("2011/Clausura/3/Orson Blanco/1/7/Juan.");
		partidos.append("2011/Clausura/4/Son Negocios/1/3/Nico.");
		partidos.append("2011/Clausura/5/Malwi Futsal/2/5/Esteban-Nico.");
		partidos.append("2011/Clausura/6/La Calle/5/12/Pato-Pato-Pato-Esteban-Esteban.");
		partidos.append("2011/Clausura/7/Toscana/8/4/Esteban-Esteban-Esteban-Esteban-Esteban-Juan-Juan-Nico.");
		partidos.append("2011/Clausura/8/El Rejunte/7/10/Emi-Emi-Emi-Emi-Esteban-Esteban-Nico.");
		partidos.append("2011/Clausura/9/Weylon/4/12/Esteban-Esteban-Mati Herlein-Mati Herlein.");
		partidos.append("2011/Clausura/10/Vizcarra/5/10/Cospel-Cospel-Esteban-Esteban-Emi.");
		
		partidos.append("2012/Apertura/1/Deportivo Gambeta/4/3/Esteban-Esteban-Cospel-Nico.");
		partidos.append("2012/Apertura/2/Humildad Y Corazon/3/7/Cospel-Cospel-Juan.");
		partidos.append("2012/Apertura/3/Electrograma/3/10/Mati Herlein-Mati Herlein-Cospel.");
		partidos.append("2012/Apertura/4/Tu Hermanito/3/4/Cospel-Cospel-Esteban.");
		partidos.append("2012/Apertura/5/La Legua/7/12/Esteban-Esteban-Esteban-Esteban-Nico-Nico-Nico.");
		partidos.append("2012/Apertura/6/Los Vagos/2/0/Mati Herlein-Mati Herlein.");
		partidos.append("2012/Apertura/7/La Nutria/2/13/Topo-Cospel.");
		partidos.append("2012/Apertura/8/Los Del Balcon/3/4/Esteban-Esteban-Fede.");
		partidos.append("2012/Apertura/9/La Rebelion/1/11/Juan.");
		partidos.append("2012/Apertura/10/Alfileres Y Bidones/3/9/Mati Herlein-Cospel-Juan.");

	
		StringTokenizer tokenPartidos = new StringTokenizer(partidos.toString(), ".");

		while (tokenPartidos.hasMoreElements()) {
			
			StringTokenizer tokenPartidosDetalle = new StringTokenizer(tokenPartidos.nextElement().toString(), "/");

			while (tokenPartidosDetalle.hasMoreElements()) {
				
				String temporada = (String) tokenPartidosDetalle.nextElement();
				String campeonato = (String) tokenPartidosDetalle.nextElement();
				String numFecha = (String) tokenPartidosDetalle.nextElement();
				String rival = (String) tokenPartidosDetalle.nextElement();
				String goleasAfavor = (String) tokenPartidosDetalle.nextElement();
				String golesEnContra = (String) tokenPartidosDetalle.nextElement();
				String goleadores="";
				if(tokenPartidosDetalle.hasMoreElements()){
					goleadores = (String) tokenPartidosDetalle.nextElement();
				}
				List<String> listaGoleadores = new ArrayList<String>();
				StringTokenizer tokenGoleadores = new StringTokenizer(goleadores, "-");

				while (tokenGoleadores.hasMoreElements()) {
					listaGoleadores.add((String) tokenGoleadores.nextElement());

				}

				if (listaGoleadores.size() != Integer.valueOf(goleasAfavor)) {
					// TODO loggear
					return false;
				}

				validarGoleadores(listaGoleadores);
				
				EquipoRival equipoRival = validarEquipoRival(rival);

				boolean ejecucionCorrecta = servicePartido.guardar(
						golesEnContra, numFecha, temporada, campeonato,
						listaGoleadores, equipoRival);

				if (!ejecucionCorrecta) {
					// TODO loggear
					return false;
				}
				
			}
			
		}
		
		return true;
	}
	
	
	private boolean validarGoleadores(List<String> listaGoleadores) {

		boolean resultado = true;

		JugadorServiceImpl serviceJugador = new JugadorServiceImpl();

		for (int i = 0; i < listaGoleadores.size(); i++) {

			resultado = serviceJugador.validarJugador(listaGoleadores.get(i));

			if (!resultado) {

				break;

			}

		}
		// TODO loggear
		return resultado;

	}

	private EquipoRival validarEquipoRival(String rival) {
		EquipoRivalServiceImpl serviceEquipo = new EquipoRivalServiceImpl();
		EquipoRival equipoRival = serviceEquipo.validarEquipoRival(rival);

		return equipoRival;
	}


	@Override
	public ArrayList<Partido> obtenerListadoDePartidos(int numPagina) {
		
		int inicio=0;
		int fin=0;
		
		if(numPagina==1){
			inicio=0;
			fin=22;
		}else if(numPagina==2){
			inicio=22;
			fin=44;
		}else if(numPagina==3){
			inicio=44;
			fin=66;
		}else if(numPagina==4){
			inicio=66;
			fin=88;
		}else if(numPagina==5){
			inicio=88;
			fin=110;
		}else if(numPagina==6){
			inicio=110;
			fin=132;
		}else if(numPagina==7){
			inicio=132;
			fin=154;
		}else if(numPagina==8){
			inicio=154;
			fin=176;
		}else if(numPagina==9){
			inicio=176;
			fin=198;
		}else if(numPagina==10){
			inicio=198;
			fin=220;
		}else if(numPagina==11){
			inicio=220;
			fin=242;
		}
		
		ArrayList<Partido> partidos = new ArrayList<Partido>();
		
		Objectify ofy = ObjectifyService.begin();
		Query<Partido> q = ofy.query(Partido.class).order("-numeroDePartido");
		
		List<Partido> lista = q.list();
		int finLista=lista.size();
		
		for (int i=inicio;i<fin && i!=finLista;i++) {
			  partidos.add(lista.get(i));
		}
					
			
		for(int i=0;i<partidos.size();i++){
			
				Partido partidoActual=partidos.get(i);
				
				//Equipo Rival				
				Key<EquipoRival> keyEquipo=partidoActual.getEquipoRival();
				
				Long idEquipo=keyEquipo.getRaw().getId();	
				
				EquipoRival equipo = ofy.query(EquipoRival.class).filter("id = ", idEquipo ).get();
				
				
				if(equipo!=null){
					partidoActual.setNombreEquipoRival(equipo.getNombre());
				}
				
				//Goles
				List<String> autoresDeGoles=new ArrayList<String>();
				
				Key<Partido> keyPartido = (new Key<Partido>(Partido.class, partidoActual.getIdPartido()));
				
				Query<Gol> goles = ofy.query(Gol.class).filter("partido", keyPartido);
				for (Gol gol: goles) {
					
					Key<Jugador> keyJugador=gol.getJugador();
					
					Long idJugador=keyJugador.getRaw().getId();	
					
					Jugador jugador = ofy.query(Jugador.class).filter("idJugador = ", idJugador ).get();
					 
					if(jugador!=null){
						autoresDeGoles.add(jugador.getNombre());
					}
				}
				
				String resultado=autoresDeGoles.size()+" - "+ partidoActual.getGolesEnContra();
				
				partidoActual.setResultado(resultado);
				
				partidoActual.setAutoresDeGoles(autoresDeGoles.toString());
				
				
				
			}
						
		return partidos;	
	}


	@Override
	public boolean borrarBase() {
		
		Objectify ofy = ObjectifyService.begin();
		
		Query<EquipoRival> q = ofy.query(EquipoRival.class);
		for (EquipoRival equipo: q) {
			  ofy.delete(equipo);
		}		
		
		Query<Jugador> j = ofy.query(Jugador.class);
		for (Jugador jugador: j) {
			  ofy.delete(jugador);
		}	
		
		Query<Gol> g = ofy.query(Gol.class);
		for (Gol gol: g) {
			  ofy.delete(gol);
		}	
		
		Query<Partido> p = ofy.query(Partido.class);
		for (Partido partido: p) {
			  ofy.delete(partido);
		}	
	
		return true;
	}
	
	public int obtenerCantidadDePartidos(){
		
		Objectify ofy = ObjectifyService.begin();
		return ofy.query(Partido.class).count();
		
	}

}
