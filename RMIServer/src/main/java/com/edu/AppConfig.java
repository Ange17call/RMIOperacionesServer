package com.edu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.edu.interfaz.Operaciones;

@Configuration
@ComponentScan("com.edu")
public class AppConfig {
	
	@Bean(name = "/sumaRMI")
	public RmiServiceExporter registerService(Operaciones servicioOperaciones) {
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setServiceName("Operaciones");
		rmiServiceExporter.setService(servicioOperaciones);
		rmiServiceExporter.setServiceInterface(Operaciones.class);
	    rmiServiceExporter.setRegistryPort(1099);
		
		return rmiServiceExporter;
	}
}