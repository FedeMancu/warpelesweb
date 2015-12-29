package com.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("gol")
public interface GolService extends RemoteService {

	boolean guardar(String nombreJugador);
}
