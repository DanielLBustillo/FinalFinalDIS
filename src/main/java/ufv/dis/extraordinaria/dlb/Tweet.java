package ufv.dis.extraordinaria.dlb;

import java.util.Date;

import org.ocpsoft.prettytime.PrettyTime;

public class Tweet {
	
	private String nombre; 
	private String mensaje; 
	private Date fecha; 
	private int tamMaximo = 140; 
	private int tamano; 
	
	public Tweet(String nombre, String mensaje) {
		super();
		this.nombre = nombre;
		this.mensaje = mensaje;
		//this.fecha = fecha; 
		//this.tamMaximo = tamMaximo; 
		//this.tam = tam; 
		
	}
	
	public Tweet() {
		Tweet t = new Tweet(); 
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getTamMaximo() {
		return tamMaximo;
	}
	
	
	public int getTam() {
		return tamano;
	}

	public void setTam(int tam) {
		this.tamano = tam;
	}

	public String getFechaCorrecta() {
		PrettyTime p = new PrettyTime(); 
		return(p.format(new Date())); 
	}
	

	
}
