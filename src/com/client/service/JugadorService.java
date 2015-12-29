package com.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.shared.modelo.Jugador;
@RemoteServiceRelativePath("jugador")
public interface JugadorService extends RemoteService {

	public boolean guardar(String nombre);

	public ArrayList<Jugador> obtenerJugadores();

	long obtenerID(String nombreJugador);

//	int obtenerCantidadDeGoles(Long idJugador);

	ArrayList<Jugador> obtenerJugadoresConSusGoles(String temporada, String campeonato);
	
}
