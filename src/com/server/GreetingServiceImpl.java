package com.server;

import com.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.ObjectifyService;
import com.shared.FieldVerifier;
import com.shared.modelo.Gol;
import com.shared.modelo.Jugador;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	static {
		// FIXME
		ObjectifyService.register(Jugador.class);
		ObjectifyService.register(Gol.class);
	}

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

//	@Override
//	public void cargarJugador(String nombre) {
//		Objectify ofy = ObjectifyService.begin();
//
//		// Simple create
//		Jugador jugador = new Jugador("Fede");
//		ofy.put(jugador);
//
//		Gol g = new Gol();
//		g.setJugador(new Key<Jugador>(Jugador.class, jugador.getIdJugador()));
//		
//		ofy.put(g);
//
//	}
}
