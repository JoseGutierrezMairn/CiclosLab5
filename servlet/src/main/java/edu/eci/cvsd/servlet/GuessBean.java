package edu.eci.cvsd.servlet;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.*;
import javax.faces.bean.ManagedBean;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;

@ManagedBean(name = "GuessBean")
@SessionScoped
public class GuessBean {
	
	private int intentos;
	private int numero;
	private int premio;
	private String estado;
	private String fallidos;
	private int numeroUsuario;
		
		
	public GuessBean() {
		restart();
			
	}
		
	public String getFallidos() {
		return fallidos;
	}

	public void setFallidos(String fallidos) {
		this.fallidos = fallidos;
	}

	public int getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(int numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public void guess(int numeroUsuario){
	    
	    if(premio > 0 && estado!="gano" && numeroUsuario>=0 && numeroUsuario<=20){
	    	if(numeroUsuario == numero){
	    		intentos++;
	            estado="gano";
	        }else{
	        	premio-=10000;
	        	intentos++;
	        	estado="fallo";
	        	          
	            fallidos += " " + String.valueOf(numeroUsuario)+",";
	        }
	        }else{
	        	
	            if(estado!="gano" && numeroUsuario>=0 && numeroUsuario<=20 ){
	            	
	                estado="Perdio y no tiene mas intentos.";
	            }
	        }
	 }
	
	public void guess(String numeroUsuario){
        try{
            this.numeroUsuario = Integer.parseInt(numeroUsuario);
            guess(this.numeroUsuario);
            
        }catch(Exception e){
            estado = "Valor invalido, solo se pueden digitar numeros enteros.";
        }
    }
	
		
	public void restart(){
	        Random rand = new Random();
	        numero = rand.nextInt(21);
	        intentos = 0;
	        premio = 100000;
	        estado = "Tiene que adivinar un numero entero entre 0 y 20.";
	        fallidos = "";
	        
	}
	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}
