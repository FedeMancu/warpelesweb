package com.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.shared.modelo.Jugador;

public interface JugadorServiceAsync {

	void guardar(String nombre, AsyncCallback<Boolean> callback);

	void obtenerJugadores( AsyncCallback<ArrayList<Jugador>> callback);

	void obtenerID(String nombreJugador, AsyncCallback<Long> asyncCallback);

//	void obtenerCantidadDeGoles(Long idJugador,
//			AsyncCallback<Integer> asyncCallback);

	void obtenerJugadoresConSusGoles(String temporada, String campeonato, AsyncCallback<ArrayList<Jugador>> asyncCallback);


}
