package com.devops.dxc.devops.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	public static int getDxc(int ahorro, int sueldo, double uf) {
		if (((ahorro * 0.1) / uf) > 150) {
			return (int) (150 * uf);
		} else if ((ahorro / uf) <= 35) {
			return (int) ahorro;
		} else if ((ahorro * 0.1 / uf) <= 35) {
			return (int) (35 * uf);
		} else {
			return (int) (ahorro * 0.1);
		}
	}

	/**
	 * Método para cacular el saldo restantes, despues de haber solicitado el 10%
	 * del ahorro en la AFP. Las reglas de negocio se pueden conocer en
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
	 * Método para cacular el impuesto a pagar. Las reglas de negocio se pueden
	 * conocer en
	 * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
	 * 
	 * @param sueldo
	 * @param dxc
	 * @return
	 */
	public static int getImpuesto(int sueldo, int dxc) {
		if ((sueldo * 12 >= 17864280) && (sueldo * 12 <= 29773800)) {
			return (int) (dxc * 0.08);
		} else if ((sueldo * 12 >= 29773801) && (sueldo * 12 <= 41600000)) {
			return (int) (dxc * 0.135);
		} else if ((sueldo * 12 >= 41600001) && (sueldo * 12 <= 53500000)) {
			return (int) (dxc * 0.23);
		} else if ((sueldo * 12 >= 53500001) && (sueldo * 12 <= 71400000)) {
			return (int) (dxc * 0.304);
		} else if (sueldo * 12 > 71400000) {
			return (int) (dxc * 0.35);
		} else {
			return (int) 0;
		}
	}

	/**
	 * Método que retorna el valor de la UF. Este método debe ser refactorizado por
	 * una integración a un servicio que retorne la UF en tiempo real. Por ejemplo
	 * mindicador.cl
	 * 
	 * @return
	 */
	public static double getUf() {
		try {

			RestTemplate restTemplate = new RestTemplate();

			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();

			Uf valor = restTemplate.getForObject((new StringBuilder()).append("https://mindicador.cl/api/uf/")
					.append(dateFormat.format(date)).toString(), Uf.class);

			LOGGER.log(Level.INFO, "Valor Uf: " + valor.getSerie().get(0).getValor());

			return valor.getSerie().get(0).getValor();

		} catch (Exception e) {
			return 29000;
		}

	}

}
