package com.devops.dxc.devops.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UfTest {
	
	public static final String CODIGO = "UF";
	public static final String NOMBRE = "UF";
	public static final String UNIDAD = "UNIDAD DE FOMENTO";
	public static final String VERSION = "1";
	public static final String AUTOR = "GRUPO1";
	private Uf uf;

	
	@BeforeEach
	public void setUp() {
		uf = new Uf();
		
		uf.setCodigo(CODIGO);
		uf.setNombre(NOMBRE);
		uf.setUnidad_medida(UNIDAD);
		uf.setVersion(VERSION);
		uf.setAutor(AUTOR);
		
	}
	
	@Test
	void test() {
		assertEquals(CODIGO,uf.getCodigo());
		assertEquals(NOMBRE,uf.getNombre());
		assertEquals(UNIDAD,uf.getUnidad_medida());
		assertEquals(VERSION,uf.getVersion());
		assertEquals(AUTOR,uf.getAutor());
	}

}
