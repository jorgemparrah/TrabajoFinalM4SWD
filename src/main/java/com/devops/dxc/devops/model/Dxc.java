package com.devops.dxc.devops.model;

import java.io.Serializable;

public class Dxc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2988002029080131424L;
	
	private int sueldo;
	private int ahorro;

	public Dxc(int ahorro, int sueldo){
		this.ahorro = ahorro;
		this.sueldo = sueldo;
	}

	public Dxc() {
	}

	public int getDxc() {
		return Util.getDxc(ahorro,sueldo);
	}
	public int getSaldo() {
		return Util.getSaldo(ahorro,getDxc());
	}
	public int getImpuesto() {
		return Util.getImpuesto(sueldo,getDxc());
	}
	
	public int getSueldo() {
		return sueldo;
	}

	public int getAhorro() {
		return ahorro;
	}

}
