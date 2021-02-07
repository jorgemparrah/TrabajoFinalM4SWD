package com.devops.dxc.devops.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.devops.dxc.devops.model.Dxc;
import com.devops.dxc.devops.model.Util;

class RestDataTest {

	private static RestData restData;
	private static double valorUf;

	public static final int SUELDO_CERO = 0;
	public static final int SUELDO_MEDIO_BAJO = 800000;
	public static final int SUELDO_MEDIO_ALTO = 1450000;
	public static final int SUELDO_TRAMO_3 = 1600000;
	public static final int SUELDO_TRAMO_4 = 3000000;
	public static final int SUELDO_TRAMO_5 = 4000000;
	public static final int SUELDO_TRAMO_6 = 5500000;
	public static final int SUELDO_TRAMO_7 = 9000000;
	
	public static final double IMPUESTO_TRAMO_3 = 0.08;
	public static final double IMPUESTO_TRAMO_4 = 0.135;
	public static final double IMPUESTO_TRAMO_5 = 0.23;
	public static final double IMPUESTO_TRAMO_6 = 0.304;
	public static final double IMPUESTO_TRAMO_7 = 0.35;
	
	@BeforeAll
	public static void setUp() {
		restData = new RestData();
		valorUf = Util.getUf();
	}

	@Test
	public void testSueldoCero() {
		baseSinImpuesto(SUELDO_CERO);
	}

	@Test
	public void testSueldoMedioBajo() {
		baseSinImpuesto(SUELDO_MEDIO_BAJO);
	}
	
	@Test
	public void testSueldoMedio() {
		baseSinImpuesto(SUELDO_MEDIO_ALTO);
	}
	
	@Test
	public void testSueldoTramo3() {
		baseConImpuesto(SUELDO_TRAMO_3, IMPUESTO_TRAMO_3);
	}
	
	@Test
	public void testSueldoTramo4() {
		baseConImpuesto(SUELDO_TRAMO_4, IMPUESTO_TRAMO_4);
	}
	
	@Test
	public void testSueldoTramo5() {
		baseConImpuesto(SUELDO_TRAMO_5, IMPUESTO_TRAMO_5);
	}
	
	@Test
	public void testSueldoTramo6() {
		baseConImpuesto(SUELDO_TRAMO_6, IMPUESTO_TRAMO_6);
	}

	@Test
	public void testSueldoTramo7() {
		baseConImpuesto(SUELDO_TRAMO_7, IMPUESTO_TRAMO_7);
	}
	
	private void baseSinImpuesto(int sueldo) {
		base(sueldo, 0, 0, 0, 0);
		base(sueldo, 800000, 800000, 0, 0);
		base(sueldo, 6000000, convertirUfAPesos(35), 6000000 - convertirUfAPesos(35), 0);
		base(sueldo, 13000000, 1300000, 11700000, 0);
		base(sueldo, 70000000, convertirUfAPesos(150), 70000000 - convertirUfAPesos(150), 0);
	}
	
	private void baseConImpuesto(int sueldo, double porcentajeImpuesto) {
		base(sueldo, 0, 0, 0, 0);
		base(sueldo, 800000, 800000, 0, (int) (800000 * porcentajeImpuesto));
		base(sueldo, 6000000, convertirUfAPesos(35), 6000000 - convertirUfAPesos(35), (int) (convertirUfAPesos(35) * porcentajeImpuesto));
		base(sueldo, 13000000, 1300000, 11700000, (int) (1300000 * porcentajeImpuesto));
		base(sueldo, 70000000, convertirUfAPesos(150), 70000000 - convertirUfAPesos(150), (int) (convertirUfAPesos(150) * porcentajeImpuesto));
	}

	private void base(int sueldo, int ahorro, int dxcEsperado, int saldoEsperado, int impuestoEsperado) {
		Dxc respuesta = restData.getData(Integer.toString(sueldo), Integer.toString(ahorro));
		assertEquals(sueldo, respuesta.getSueldo());
		assertEquals(ahorro, respuesta.getAhorro());
		assertEquals(dxcEsperado, respuesta.getDxc());
		assertEquals(saldoEsperado, respuesta.getSaldo());
		assertEquals(impuestoEsperado, respuesta.getImpuesto());
	}
	
	private int convertirUfAPesos(int cantidadUf) {
		return (int) (cantidadUf * valorUf);
	}

}
