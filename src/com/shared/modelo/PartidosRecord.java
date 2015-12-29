package com.shared.modelo;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PartidosRecord extends ListGridRecord {  

	public void setNumeroPartido(String numeroPartido) {  
        setAttribute("numeroPartido", numeroPartido);  
    }  
  
    public String getNumeroPartido() {  
        return getAttributeAsString("numeroPartido");  
    }  
    
    public void setTemporada(String temporada) {  
        setAttribute("temporada", temporada);  
    }  
  
    public String getTotal() {  
        return getAttributeAsString("total");  
    }  
    
    public void setCampeonato(String campeonato) {  
        setAttribute("campeonato", campeonato);  
    }  
  
    public String getCampeonato() {  
        return getAttributeAsString("campeonato");  
    }  
    
    public void setFecha(String fecha) {  
        setAttribute("fecha", fecha);  
    }  
  
    public String getFecha() {  
        return getAttributeAsString("fecha");  
    }  
    
    public void setRival(String rival) {  
        setAttribute("rival", rival);  
    }  
  
    public String getRival() {  
        return getAttributeAsString("rival");  
    }  
    
    public void setResultado(String resultado) {  
        setAttribute("resultado", resultado);  
    }  
  
    public String getResultado() {  
        return getAttributeAsString("resultado");  
    }  
    
    public void setgoles(String goles) {  
        setAttribute("goles", goles);  
    }  
  
    public String getGoles() {  
        return getAttributeAsString("goles");  
    }  
    
    public PartidosRecord(String numeroPartido, String temporada, String campeonato, String fecha, String rival, String resultado, String goles){
    	setNumeroPartido(numeroPartido);
    	setTemporada(temporada);
    	setCampeonato(campeonato);
    	setFecha(fecha);
    	setRival(rival);
    	setResultado(resultado);
    	setgoles(goles);
    }
    
}
