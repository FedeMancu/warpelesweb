package com.client.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.shared.modelo.EquipoRival;
import com.shared.modelo.Partido;

public interface PartidoServiceAsync {

	void guardar(String golesEnContra,String numeroDeFecha,String anio,
			String nombreCampeonato, List<String> autoresDeGoles, EquipoRival rival,
			AsyncCallback<Boolean> callback);

	void realizarCarga(AsyncCallback<Boolean> asyncCallback);

	void obtenerListadoDePartidos(int numPagina, AsyncCallback<ArrayList<Partido>> asyncCallback);

	void borrarBase(AsyncCallback<Boolean> asyncCallback);
	
	void obtenerCantidadDePartidos(AsyncCallback<Integer> asyncCallback);
}
