package com.devops.dxc.devops.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilTest {

	@BeforeEach
	public void setUp() {
		new Util();
	}

	@Test
	void testImpuesto() {
		assertEquals(405000, Util.getImpuesto(2500000, 3000000));
		assertEquals(690000, Util.getImpuesto(3500000, 3000000));
		assertEquals(912000, Util.getImpuesto(4500000, 3000000));
		assertEquals(1050000, Util.getImpuesto(6500000, 3000000));
	}

}
