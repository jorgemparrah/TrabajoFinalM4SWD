package com.devops.dxc.devops.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class RestDataTest {

	@Test
	void testGetData() {
		RestData restData = new RestData();
		assertEquals(600000, restData.getData("600000", "2000000").getSueldo());
	}

	@Test
	void testNumberFormatException() {
		RestData restData = new RestData();

		assertThrows(NumberFormatException.class, () -> {
			restData.getData("ahorro", "2000000").getSueldo();
		});

		assertThrows(NumberFormatException.class, () -> {
			restData.getData("2000000", "sueldo").getSueldo();
		});

	}

}
