package com.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.shared.modelo.EquipoRival;

public interface EquipoRivalServiceAsync {

	void guardar(String nombre, AsyncCallback<Boolean> asyncCallback);

	void obtenerEquiposRivales( AsyncCallback<ArrayList<EquipoRival>> callback);

}

