package com.devops.dxc.devops.model;

public class Validation {

	private static final String ERROR_CAMPO_VACIO = "Los campos son obligatorios";
	private static final String ERROR_CAMPO_NO_VALIDO = "Debe ingresar datos validos";

	public static int validate(String value) {
		if (value == null || value.trim().isEmpty()) {
			throw new RuntimeException(ERROR_CAMPO_VACIO);
		}
		try {
			int valueInt = Integer.parseInt(value);
			if (valueInt < 0) {
				throw new IllegalArgumentException();
			}
			return valueInt;
		} catch (Exception e) {
			throw new RuntimeException(ERROR_CAMPO_NO_VALIDO);
		}
	}

}
