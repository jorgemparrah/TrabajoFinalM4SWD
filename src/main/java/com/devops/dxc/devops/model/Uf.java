package com.devops.dxc.devops.model;

import java.util.List;

public class Uf {

	private String version;
	private String autor;
	private String codigo;
	private String nombre;
	private String unidad_medida;
	private List<Serie> serie;

	public String getAutor() {
		return autor;
	}
	
	public String setAutor(String autor) {
		return this.autor = autor;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidad_medida() {
		return unidad_medida;
	}

	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

	public List<Serie> getSerie() {
		return serie;
	}

	public void setSerie(List<Serie> serie) {
		this.serie = serie;
	}

	static class Serie {
		private double valor;
		private String fecha;

		public double getValor() {
			return valor;
		}

		public String getFecha() {
			return fecha;
		}

	}
}