package com.shared.modelo;

import java.util.ArrayList;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class GoleadoresRecord extends ListGridRecord {  
	
	private ArrayList<GolesDetalleBean> detalle;
	
	public void setWarpel(String warpel) {  
        setAttribute("warpel", warpel);  
    }  
  
    public String getWarpel() {  
        return getAttributeAsString("warpel");  
    }  
    
    public void setTotal(String total) {  
        setAttribute("total", total);  
    }  
  
    public String getTotal() {  
        return getAttributeAsString("total");  
    }  
    
    public void setEquipo(String equipo) {  
        setAttribute("equipo", equipo);  
    }  
  
    public String getEquipo() {  
        return getAttributeAsString("equipo");  
    }  
    
    public void setTotalDetalle(String totalDetalle) {  
        setAttribute("totalDetalle", totalDetalle);  
    }  
  
    public String getTotalDetalle() {  
        return getAttributeAsString("totalDetalle");  
    }  
    
    public void setDetalle( ArrayList<GolesDetalleBean> bean) {  
        detalle=bean;  
    }  
  
    public ArrayList<GolesDetalleBean> getDetalleBean() {  
        return detalle;  
    } 
    
    public GoleadoresRecord(String warpel, String total, ArrayList<GolesDetalleBean> bean){
    	setWarpel(warpel);
    	setTotal(total);
    	setDetalle(bean);
    }
    
    public GoleadoresRecord(String equipo, String totalDetalle){
    	setEquipo(equipo);
    	setTotalDetalle(totalDetalle);
    }
    
}
