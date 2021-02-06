package com.devops.dxc.devops;

import static java.time.Duration.ofSeconds;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.devops.dxc.devops.model.Util;

@SpringBootTest
class DevopsApplicationTests {

	private final String CONSULTARUT = "8388316-2";
	private final List<String> AFILIADOS = Arrays.asList("13706546-0", "13527931-5", "8388316-2");
	private final List<String> DEUDORES = Arrays.asList("11013725-7", "13706546-0", "13527931-5", "8388316-2");

	@Test
	@DisplayName("Prueba de AppContext")
	public void applicationContextTest() {
		DevopsApplication.main(new String[] {});
	}

	@Test
	@DisplayName("NO EXCEDE TIMEOUT CALCULO UF API")
	public void whenAssertingTimeout_thenNotExceeded() {
		assertTimeout(ofSeconds(6), () -> {
			Util.getUf();
		});
	}

	@Test
	@DisplayName("¿TENGO SALDO?")
	public void whenAssertingTengoSaldo() {
		assertEquals(9000000, Util.getSaldo(10000000, 1000000));
	}

	@Test
	@DisplayName("¿TENGO QUE PAGAR IMPUESTOS?")
	public void whenAssertingImpuestos() {
		assertEquals(320000, Util.getImpuesto(2000000, 4000000));
	}

	@Test
	@DisplayName("RETIRO FORZOSO POR DEUDAS DE PENSIONES DE ALIMENTOS")
	public void whenAssertingPesionAlimentos() {
		assertThat(DEUDORES, hasItems(CONSULTARUT));
	}

	@Test
	@DisplayName("¿PUEDO RETIRAR TODOS MIS AHORROS?")
	public void whenAssertingRetirarTodo() {
		assertEquals(900000, Util.getDxc(900000, 600000));
	}

	@Test
	@DisplayName("¿PUEDO REALIZAR OTRO RETIRO DEL 10% ?")
	public void whenAssertingRealizarOtroRetiro() {
		assertEquals(900000, Util.getDxc(900000, 600000));
		assertThat(AFILIADOS, hasItems(CONSULTARUT));

	}

	@Test
	@DisplayName("MONTO MAXIMO DEL 10%")
	public void whenAssertingMontoMaximo() {
		assertTrue(Util.getDxc(100000000, 3000000) == (150 * Util.getUf()), "monto maximo permitido");

	}

}
