package com.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GolServiceAsync {

	void guardar(String nombreJugador, AsyncCallback<Boolean> asyncCallback);
}
