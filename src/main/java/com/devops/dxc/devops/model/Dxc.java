package com.devops.dxc.devops.model;

import java.io.Serializable;

public class Dxc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2988002029080131424L;
	
	private int sueldo;
	private int ahorro;
	private double uf;

	public Dxc(int ahorro, int sueldo, double uf){
		this.ahorro = ahorro;
		this.sueldo = sueldo;
		this.uf = uf;
	}

	public int getDxc() {
		return Util.getDxc(ahorro,sueldo, uf);
	}
	public int getSaldo() {
		return Util.getSaldo(ahorro, getDxc());
	}
	public int getImpuesto() {
		return Util.getImpuesto(sueldo, getDxc());
	}
	
	public int getSueldo() {
		return sueldo;
	}

	public int getAhorro() {
		return ahorro;
	}

}
