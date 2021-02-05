package com.devops.dxc.devops.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilTest {

	private Util util;

	@BeforeEach
	public void setUp() {

	}

	@Test
	void testImpuesto() {
		util = new Util();
		assertEquals(405000, util.getImpuesto(2500000, 3000000));
		assertEquals(690000, util.getImpuesto(3500000, 3000000));
		assertEquals(912000, util.getImpuesto(4500000, 3000000));
		assertEquals(1050000, util.getImpuesto(6500000, 3000000));
	}

}
