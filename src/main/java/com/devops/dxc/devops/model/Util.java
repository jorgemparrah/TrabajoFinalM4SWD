package com.devops.dxc.devops.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.client.RestTemplate;

public class Util {

	private final static Logger LOGGER = Logger.getLogger("devops.subnivel.Modelo");

	/**
	 * Método para cacular el 10% del ahorro en la AFP. Las reglas de negocio se
	 * pueden conocer en
	 * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
	 * 
	 * @param ahorro
	 * @param sueldo
	 * @return
	 */
	public static int getDxc(int ahorro, int sueldo) {

		if (((ahorro * 0.1) / getUf()) > 150) {
			return (int) (150 * getUf());
		} else if ((ahorro * 0.1) <= 1000000 && ahorro >= 1000000) {
			return (int) 1000000;
		} else if (ahorro <= 1000000) {
			return (int) ahorro;
		} else {
			return (int) (ahorro * 0.1);
		}
	}
	
	 /**
	 * Método para cacular el saldo restantes, despues de haber solicitado el 10% del ahorro en la AFP. 
	 * Las reglas de negocio se pueden conocer en
	 * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
	 * 
	 * @param ahorro
	 * @param dxc
	 * @return
	 */
	public static int getSaldo(int ahorro, int dxc) {
		return (int) (ahorro - dxc);
	}	

	/**
	 * Método que retorna el valor de la UF. Este método debe ser refactorizado por
	 * una integración a un servicio que retorne la UF en tiempo real. Por ejemplo
	 * mindicador.cl
	 * 
	 * @return
	 */
	public static int getUf() {

		RestTemplate restTemplate = new RestTemplate();

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();

		try {
			Uf valor = restTemplate.getForObject((new StringBuilder()).append("https://mindicador.cl/api/uf/")
					.append(dateFormat.format(date)).toString(), Uf.class);

			LOGGER.log(Level.INFO, "Valor Uf: " + valor.getSerie().get(0).getValor());

			return (int) valor.getSerie().get(0).getValor();

		} catch (Exception e) {
			return 29000;
		}

	}

}
