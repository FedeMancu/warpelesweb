package com.client.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.shared.modelo.EquipoRival;
import com.shared.modelo.Partido;

@RemoteServiceRelativePath("partido")
public interface PartidoService extends RemoteService {

	boolean guardar(String golesEnContra,String numeroDeFecha,String anio,
			String nombreCampeonato, List<String> autoresDeGoles, EquipoRival rival);

	boolean realizarCarga() throws IOException;

	ArrayList<Partido> obtenerListadoDePartidos(int numPagina);

	boolean borrarBase();
	
	int obtenerCantidadDePartidos();
	
}