package com.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.shared.modelo.EstadisticaBean;

public interface PrincipalServiceAsync {

	void iniciarServicios(AsyncCallback<Boolean> asyncCallback);
	
	void obtenerCampeonatosDeUnaTemporada(String temporada,
			AsyncCallback<ArrayList<String>> asyncCallback);

	void obtenerEstadisticas(String temporada, String campeonato, AsyncCallback<EstadisticaBean> asyncCallback);

}
