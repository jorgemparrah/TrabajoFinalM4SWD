package com.devops.dxc.devops.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RestDataTest {

	@Test
	void testGetData() {
		RestData restData = new RestData();
		assertEquals(600000, restData.getData("600000", "2000000").getSueldo());
	}

}
