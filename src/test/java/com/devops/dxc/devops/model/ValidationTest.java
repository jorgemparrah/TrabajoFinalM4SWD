package com.devops.dxc.devops.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {

	private static final String ERROR_CAMPO_VACIO = "Los campos son obligatorios";
	private static final String ERROR_CAMPO_NO_VALIDO = "Debe ingresar datos validos";

	@Test
	void instancia() {
		new Validation();
	}
	
	@Test
	@DisplayName("Validacion de campo vacio")
	void validacionVacio() {
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			Validation.validate("");
		});
		assertTrue(e.getMessage().equals(ERROR_CAMPO_VACIO));
	}

	@Test
	@DisplayName("Validacion de campo no numerico")
	void validacionNoNumerico() {
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			Validation.validate("AAAAAA");
		});
		assertTrue(e.getMessage().equals(ERROR_CAMPO_NO_VALIDO));
	}

	@Test
	@DisplayName("Validacion de campo numerico negativo")
	void validacionNegativo() {
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			Validation.validate("-500");
		});
		assertTrue(e.getMessage().equals(ERROR_CAMPO_NO_VALIDO));
	}

}
