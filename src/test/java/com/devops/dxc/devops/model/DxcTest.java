package com.devops.dxc.devops.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DxcTest {

	public static final int AHORRO = 2000000;
	public static final int SUELDO = 600000;
	public static final int IMPUESTO = 0;
	public static final int CONIMPUESTO = 1529692;
	public static final int SALDO = 1000000;
	private Dxc dxc;

	@BeforeEach
	public void setUp() {
		dxc = new Dxc(2000000, 600000);
	}

	@Test
	public void testDxc() throws Exception {
		assertEquals(AHORRO, dxc.getAhorro());
		assertEquals(SUELDO, dxc.getSueldo());
	}

	@Test
	public void testImpuesto() throws Exception {
		assertEquals(IMPUESTO, dxc.getImpuesto());
		assertEquals(SALDO, dxc.getSaldo());
	}
	
}
