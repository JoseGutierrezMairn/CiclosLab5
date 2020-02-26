package edu.eci.cvsd.servlet.Model;

import java.util.Random;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

@ManagedBean("guessBean")
@ApplicationScoped
public class SesionBacking {
	
	private int intentos=0;
	private int premio=100000;
	private int numero;
	private boolean finalizado=false;
	
	public SesionBacking () {
	}
	
	public void guess(int intento) {
		if(intento==numero) {
			finalizado=!finalizado;
		}
		else {
			intentos+=1;
			premio-=10000;
		}
	}
	
	public void restart() {
		Random random = new Random();
		premio=100000;
		numero=random.nextInt(9999);
	}
	
	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	
}
