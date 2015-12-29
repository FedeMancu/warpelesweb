package com.client.baseEnMemoria;

import java.util.ArrayList;
import com.shared.modelo.EstadisticaBean;
import com.shared.modelo.Partido;

/**
 * Es una basura creada por el problema con la base de datos en el servidor
 * @author Federico
 *
 */

public class EstadisticasEnMemoria {

	public static EstadisticaBean obtenerEstadisticas(String temporada, String campeonato) {

		if(temporada==null){
			temporada="";
		}
		
		if(campeonato==null){
			campeonato="";
		}
		
		ArrayList<Partido> partidos = PartidosEnMemoria.obtenerPartidos();
		
		EstadisticaBean bean = new EstadisticaBean();

		int partidosJugados = 0;
		int partidosGanados = 0;
		int partidosEmpatados = 0;
		int partidosPerdidos = 0;
		int golesEnContra = 0;
		int golesAFavor = 0;
		double porcentajeDePuntos=0.0;
		
		String mayorTriunfo="-";
		String mayorDerrota="-";
		String masGolesAFavor="-";
		String masGolesEnContra="-";
		
		int masGoles=0;
		int menosGoles=0;
		int mejorDif=0;
		int peorDif=0;


		for (Partido partido : partidos) {
			
			String temporadaPartido=String.valueOf(partido.getAnio());
			String campeonatoPartido=String.valueOf(partido.getCampeonato());

			
			if(((!temporada.equals("") && temporadaPartido.equals(temporada))
					|| temporada.equals(""))
					&& ((!campeonato.equals("") && campeonatoPartido.equals(campeonato))
							|| campeonato.equals("")) ){
			
				partidosJugados++;
				
				int golesAFavorDelPartido = 0;
				if (!partido.getAutoresDeGoles().equals("[]")) {

					golesAFavorDelPartido = (partido.getAutoresDeGoles().split(",")).length;
				}
				if(golesAFavorDelPartido>masGoles){
					masGoles=golesAFavorDelPartido;
					masGolesAFavor=partido.getNombreEquipoRival()+": "+ golesAFavorDelPartido+"-"+partido.getGolesEnContra();

				}else if(golesAFavorDelPartido==masGoles){
					masGolesAFavor=masGolesAFavor.concat(" ; "+partido.getNombreEquipoRival()+": "+ golesAFavorDelPartido+"-"+partido.getGolesEnContra());
				}
			
				if( partido.getGolesEnContra()>menosGoles){
					menosGoles=partido.getGolesEnContra();
					masGolesEnContra=partido.getNombreEquipoRival()+": "+ golesAFavorDelPartido+"-"+partido.getGolesEnContra();

				}else if(partido.getGolesEnContra()==menosGoles){
					masGolesEnContra=masGolesEnContra.concat(" ; "+partido.getNombreEquipoRival()+": "+ golesAFavorDelPartido+"-"+partido.getGolesEnContra());
				}

				golesAFavor = golesAFavor + golesAFavorDelPartido;

				golesEnContra = golesEnContra + partido.getGolesEnContra();
				
				if (partido.getGolesEnContra() == golesAFavorDelPartido) {

					partidosEmpatados++;

				} else if (partido.getGolesEnContra() < golesAFavorDelPartido) {
					
					if((golesAFavorDelPartido-partido.getGolesEnContra())>mejorDif){
						mejorDif=golesAFavorDelPartido-partido.getGolesEnContra();
						mayorTriunfo=partido.getNombreEquipoRival()+": "+ golesAFavorDelPartido+"-"+partido.getGolesEnContra();
					
					}else if((golesAFavorDelPartido-partido.getGolesEnContra())==mejorDif){
						mayorTriunfo=mayorTriunfo.concat(" ; "+partido.getNombreEquipoRival()+": "+ golesAFavorDelPartido+"-"+partido.getGolesEnContra());

					}
					
					partidosGanados++;

				} else if (partido.getGolesEnContra() > golesAFavorDelPartido) {
					
					if((partido.getGolesEnContra()-golesAFavorDelPartido)>peorDif){
						peorDif=(partido.getGolesEnContra()-golesAFavorDelPartido);
						mayorDerrota=partido.getNombreEquipoRival()+": "+ golesAFavorDelPartido+"-"+partido.getGolesEnContra();
					
					}else if((partido.getGolesEnContra()-golesAFavorDelPartido)==peorDif){
						mayorDerrota=mayorDerrota.concat(" ; "+partido.getNombreEquipoRival()+": "+ golesAFavorDelPartido+"-"+partido.getGolesEnContra());
					}
					
					partidosPerdidos++;
				}

			}

		porcentajeDePuntos = (((float) partidosGanados * 2 + partidosEmpatados)
				/ ((float) partidosJugados * 2) * 100);

		// Reondeo el porcenaje
		porcentajeDePuntos = Math.rint(porcentajeDePuntos * 100) / 100;

		}
		bean.setPartidosJugados(partidosJugados);
		bean.setGolesAFavor(golesAFavor);
		bean.setGolesEnContra(golesEnContra);
		bean.setPartidosGanados(partidosGanados);
		bean.setPartidosEmpatados(partidosEmpatados);
		bean.setPartidosPerdidos(partidosPerdidos);
		bean.setPorcentajeDePuntos(porcentajeDePuntos);
		bean.setMayorTriunfo(mayorTriunfo);
		bean.setMayorDerrota(mayorDerrota);
		bean.setMasGolesAFavor(masGolesAFavor);
		bean.setMasGolesEnContra(masGolesEnContra);


		return bean;

	}
	
	
	public static ArrayList<String>  obtenerCampeonatosDeUnaTemporada(String temporada){
		
		ArrayList<String> resultado= new ArrayList<String>();
		
		ArrayList<Partido> partidos = PartidosEnMemoria.obtenerPartidos();

		for (Partido partido: partidos) {
			
			String temporadaPartido=String.valueOf(partido.getAnio());
			
			if((!resultado.contains(partido.getCampeonato())
					&& temporadaPartido.equals(temporada))){
				
				resultado.add(partido.getCampeonato());
				
			}
			
		}
		
		
		return resultado;
		
	}
}