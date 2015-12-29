package com.server.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.client.service.PrincipalService;
import com.client.service.PrincipalServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.shared.modelo.EquipoRival;
import com.shared.modelo.EstadisticaBean;
import com.shared.modelo.Gol;
import com.shared.modelo.Jugador;
import com.shared.modelo.Partido;

public class PrincipalServiceImpl extends RemoteServiceServlet implements PrincipalService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1991646546618299665L;
	
	private PartidoServiceImpl partidoService= new PartidoServiceImpl();
	private GolServiceImpl golService= new GolServiceImpl();

	


	@Override
	public boolean iniciarServicios() {
		
		//TODO cambiar?
		ObjectifyService.register(Jugador.class);
		ObjectifyService.register(Gol.class);
		ObjectifyService.register(Partido.class);
		ObjectifyService.register(EquipoRival.class);
		
		return true;
	}
	
	public ArrayList<String>  obtenerCampeonatosDeUnaTemporada(String temporada){
		
		ArrayList<String> resultado= new ArrayList<String>();
		
		Objectify ofy = ObjectifyService.begin();

		Query<Partido> p = ofy.query(Partido.class).filter("anio = ", Integer.valueOf(temporada));
		for (Partido partido: p) {
			  
			if(!resultado.contains(partido.getCampeonato())){
				
				resultado.add(partido.getCampeonato());
				
			}
			
		}
		
		
		return resultado;
		
	}

	@Override
	public EstadisticaBean obtenerEstadisticas(String temporada,
			String campeonato) {
		
		Objectify ofy = ObjectifyService.begin();

		Query<Partido> p = ofy.query(Partido.class);
		
		if(!(temporada==null) && !(temporada.equals(""))){
			p.filter("anio = ", Integer.valueOf(temporada));
		}
		
		if(!(campeonato==null) && !(campeonato.equals(""))){
			p.filter("campeonato = ", campeonato);
		}
		
		EstadisticaBean bean=new EstadisticaBean();
		
		int partidosJugados=p.count();
		int partidosGanados=0;
		int partidosEmpatados=0;
		int partidosPerdidos=0;
		int golesEnContra=0;
		int golesAFavor=0;


		for (Partido partido: p) {
			
			int golesAFavorDelPartido = golService.obtenerGolesAFavorDeUnPartido(partido.getIdPartido());
			golesAFavor=golesAFavor+golesAFavorDelPartido;
			
			golesEnContra=golesEnContra+partido.getGolesEnContra();
			
			if(partido.getGolesEnContra()==golesAFavorDelPartido){
				
				partidosEmpatados++;
				
			}else if(partido.getGolesEnContra()<golesAFavorDelPartido){
				
				partidosGanados++;
				
			}else if(partido.getGolesEnContra()>golesAFavorDelPartido){
				
				partidosPerdidos++;
			}
			
			
		}
		
		double porcentajeDePuntos = (((float)partidosGanados*2+partidosEmpatados)/((float)partidosJugados*2)*100);
		
		//Reondeo el porcenaje
		porcentajeDePuntos= Math.rint(porcentajeDePuntos*100)/100;
		
		bean.setPartidosJugados(partidosJugados);
		bean.setGolesAFavor(golesAFavor);
		bean.setGolesEnContra(golesEnContra);
		bean.setPartidosGanados(partidosGanados);
		bean.setPartidosEmpatados(partidosEmpatados);
		bean.setPartidosPerdidos(partidosPerdidos);
		bean.setPorcentajeDePuntos(porcentajeDePuntos);

		
		
		
		
		return bean;
	}

}
