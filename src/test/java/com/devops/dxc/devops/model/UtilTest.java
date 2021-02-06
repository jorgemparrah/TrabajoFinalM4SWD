package com.devops.dxc.devops.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilTest {

	private static final double UF = 29000;
	
	@BeforeEach
	public void setUp() {
		new Util();
	}

	@Test
	void testDxc() {
		assertEquals(800000, Util.getDxc(800000, 1000, UF));
		assertEquals(1015000, Util.getDxc(5000000, 1000, UF));
		assertEquals(2000000, Util.getDxc(20000000, 1000, UF));
		assertEquals(4350000, Util.getDxc(50000000, 1000, UF));
	}
	
	@Test
	void testImpuesto() {
		assertEquals(405000, Util.getImpuesto(2500000, 3000000));
		assertEquals(690000, Util.getImpuesto(3500000, 3000000));
		assertEquals(912000, Util.getImpuesto(4500000, 3000000));
		assertEquals(1050000, Util.getImpuesto(6500000, 3000000));
	}

}
