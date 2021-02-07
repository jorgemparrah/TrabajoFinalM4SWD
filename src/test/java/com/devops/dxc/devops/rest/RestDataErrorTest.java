package com.devops.dxc.devops.rest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RestDataErrorTest {

	private static final String ERROR_CAMPO_VACIO = "Los campos son obligatorios";
	private static final String ERROR_CAMPO_NO_VALIDO = "Debe ingresar datos validos";
	
	private static RestData restData;
	
	@BeforeAll
	public static void setUp() {
		restData = new RestData();
	}

	@Test
	public void testDatosVacios() {
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			restData.getData("", "1000");
		});
		assertTrue(e.getMessage().equals(ERROR_CAMPO_VACIO));
		
		e = assertThrows(RuntimeException.class, () -> {
			restData.getData("1000", "");
		});
		assertTrue(e.getMessage().equals(ERROR_CAMPO_VACIO));
	}
	
	@Test
	public void testDatosNoValidos() {
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			restData.getData("AAAAA", "1000");
		});
		assertTrue(e.getMessage().equals(ERROR_CAMPO_NO_VALIDO));
		
		e = assertThrows(RuntimeException.class, () -> {
			restData.getData("1000", "BBBBB");
		});
		assertTrue(e.getMessage().equals(ERROR_CAMPO_NO_VALIDO));
		
		e = assertThrows(RuntimeException.class, () -> {
			restData.getData("AAAAAA", "BBBBB");
		});
		assertTrue(e.getMessage().equals(ERROR_CAMPO_NO_VALIDO));
		
		e = assertThrows(RuntimeException.class, () -> {
			restData.getData("10000", "-50000");
		});
		assertTrue(e.getMessage().equals(ERROR_CAMPO_NO_VALIDO));
		
		e = assertThrows(RuntimeException.class, () -> {
			restData.getData("-10000", "50000");
		});
		assertTrue(e.getMessage().equals(ERROR_CAMPO_NO_VALIDO));
		
		e = assertThrows(RuntimeException.class, () -> {
			restData.getData("-20000", "-20000");
		});
		assertTrue(e.getMessage().equals(ERROR_CAMPO_NO_VALIDO));
	}

}
