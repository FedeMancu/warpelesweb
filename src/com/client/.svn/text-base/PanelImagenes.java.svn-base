package com.client;

import com.client.handlers.MyHandlerAmpliarImagen;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class PanelImagenes extends DialogBox {
	
	
	private final Button btnCerrar = new Button("Cerrar", new ClickHandler() {
		public void onClick(ClickEvent event) {
			// Cierra el cuadro de diálogo.
			hide();
		}
	});

	@SuppressWarnings("deprecation")
	public PanelImagenes() {
		/*
		 * El primer parámetro en false indica que el diálogo no es autohide. El
		 * segundo parámetro es true para indicar que es modal, o sea que
		 * bloquea el resto de la página si no se cierra.
		 */
		super(false, true);
		// Asigna el texto de la barra de título.
		setText("Asi salimos a la cancha...");
		// Realiza una animación al abrir o cerrar el diálogo.
		setAnimationEnabled(true);
		setGlassEnabled(true);
		setAutoHideEnabled(true);

		
	//	ScrollPanel panel=new ScrollPanel();
		
		final MyHandlerAmpliarImagen handler= new MyHandlerAmpliarImagen();
		
		Image sieteA = new Image("2007A.jpg");	  
		cambiarPuntero(sieteA);
	    sieteA.setSize("180px", "150px");
	    
	    sieteA.addClickListener(new ClickListener() {
			
			public void onClick(Widget sender) {
			    handler.setNombreImagen("2007A.jpg");

			}
		});
	    sieteA.addClickHandler(handler);
	    
	    Image sieteB = new Image("2007B.jpg");	
		cambiarPuntero(sieteB);
	    sieteB.setSize("180px", "150px");
	    
	    sieteB.addClickListener(new ClickListener() {
			
			public void onClick(Widget sender) {
			    handler.setNombreImagen("2007B.jpg");

			}
		});	    
	    sieteB.addClickHandler(handler);
	    
	    Image sieteC = new Image("2007C.jpg");	    
		cambiarPuntero(sieteC);
		sieteC.setSize("180px", "150px");
	    sieteC.addClickListener(new ClickListener() {
			
			public void onClick(Widget sender) {
			    handler.setNombreImagen("2007C.jpg");

			}
		});	 	    
	    sieteC.addClickHandler(handler);
	    
	    Image ocho = new Image("2008.jpg");	    
		cambiarPuntero(ocho);
	    ocho.setSize("180px", "150px");
	    ocho.addClickListener(new ClickListener() {
			
			public void onClick(Widget sender) {
			    handler.setNombreImagen("2008.jpg");

			}
		});	 	   
	    ocho.addClickHandler(handler);
	    
	    Image diez = new Image("2010.jpg");	 
		cambiarPuntero(diez);
	    diez.setSize("180px", "150px");
	    diez.addClickListener(new ClickListener() {
			
			public void onClick(Widget sender) {
			    handler.setNombreImagen("2010.jpg");

			}
		});	 	    
	    diez.addClickHandler(handler);
	    
	    Image onceA = new Image("2011A.JPG");
		cambiarPuntero(onceA);
	    onceA.setSize("180px", "150px");
	    onceA.addClickListener(new ClickListener() {
			
			public void onClick(Widget sender) {
			    handler.setNombreImagen("2011A.JPG");

			}
		});	 	    
	    onceA.addClickHandler(handler);
	    
	    Image onceB = new Image("2011B.jpg");	
		cambiarPuntero(onceB);
	    onceB.setSize("180px", "150px");
	    onceB.addClickListener(new ClickListener() {
			
			public void onClick(Widget sender) {
			    handler.setNombreImagen("2011B.jpg");

			}
		});	 	    
	    onceB.addClickHandler(handler);
	    
	    Image onceC = new Image("2011C.jpg");	
		cambiarPuntero(onceC);
	    onceC.setSize("180px", "150px");
	    onceC.addClickListener(new ClickListener() {
			
			public void onClick(Widget sender) {
			    handler.setNombreImagen("2011C.jpg");

			}
		});	 	    
	    onceC.addClickHandler(handler);
	    
	    Image doce = new Image("2012.jpg");	    
	    doce.setSize("180px", "150px");
		cambiarPuntero(doce);
	    doce.addClickListener(new ClickListener() {
			
			public void onClick(Widget sender) {
			    handler.setNombreImagen("2012.jpg");

			}
		});	 		    
	    doce.addClickHandler(handler);

		
		final FlexTable contenido = new FlexTable();
		
		contenido.setCellSpacing(5);
		contenido.setCellPadding(0);

		contenido.setWidget(1, 1, doce);
		contenido.setWidget(1, 2, onceA);
		contenido.setWidget(1, 3, onceB);
		contenido.setWidget(2, 1, onceC);
		contenido.setWidget(2, 2, diez);
		contenido.setWidget(2, 3, ocho);
		contenido.setWidget(3, 1, sieteA);
		contenido.setWidget(3, 2, sieteB);
		contenido.setWidget(3, 3, sieteC);


//		contenido.setWidget(6, 3, btnCerrar);
		
		final ScrollPanel scroll = new ScrollPanel();
		
		scroll.add(contenido);

	
		// Asigna el contenido.
		setWidget(scroll);
	}

	void cambiarPuntero(final Image imagen) {

		imagen.addMouseOverHandler(new MouseOverHandler() {

			public void onMouseOver(MouseOverEvent event) {
				Element element = imagen.getElement();
				DOM.setStyleAttribute(
						(com.google.gwt.user.client.Element) element, "cursor",
						"pointer");

			}
		});
	}
	
}
