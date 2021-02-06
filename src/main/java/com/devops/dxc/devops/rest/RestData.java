package com.devops.dxc.devops.rest;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devops.dxc.devops.model.Dxc;
import com.devops.dxc.devops.model.Validation;

@RestController
@RequestMapping(path = "/rest/msdxc")
public class RestData {

	private final static Logger LOGGER = Logger.getLogger(RestData.class.getName());

	@GetMapping(path = "/dxc", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Dxc getData(@RequestParam(name = "sueldo") String sueldo,
			@RequestParam(name = "ahorro") String ahorro) {
		LOGGER.log(Level.INFO, "Parametros - ahorro [{0}] - sueldo[{1}]", new Object[]{ ahorro, sueldo});
		int ahorroInt = Validation.validate(ahorro);
		int sueldoInt = Validation.validate(sueldo);
		LOGGER.log(Level.INFO, "Calcular - Ahorro [{0}] - Sueldo[{1}]", new Object[]{ ahorroInt, sueldoInt});
		Dxc response = new Dxc(ahorroInt, sueldoInt);
		return response;
	}
}