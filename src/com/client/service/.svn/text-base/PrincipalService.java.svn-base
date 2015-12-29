package com.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.shared.modelo.EstadisticaBean;

@RemoteServiceRelativePath("principal")
public interface PrincipalService extends RemoteService {

	boolean iniciarServicios();

	ArrayList<String> obtenerCampeonatosDeUnaTemporada(String temporada);

	EstadisticaBean obtenerEstadisticas(String temporada, String campeonato);

}
