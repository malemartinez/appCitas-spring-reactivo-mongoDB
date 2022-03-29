package com.springBajo8.springBajo8;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.service.impl.citasReactivaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class SpringBajo8ApplicationTests {

	@Autowired
	citasReactivaServiceImpl citasReactivaService;

//	@Test
//	void contextLoads() {
//	}

	@Test
	void testMono() {
		citasDTOReactiva citaMedica = new citasDTOReactiva();
		citaMedica.setApellidosMedico("Aldana");
		citaMedica.setEstadoReservaCita("en espera");
		citaMedica.setNombreMedico("camilo");
		citaMedica.setFechaReservaCita("22-05-28");
		citaMedica.setHoraReservaCita("5:00");

		Mono<citasDTOReactiva> uno = citasReactivaService.save(citaMedica);
		StepVerifier.create(uno).expectNext(citaMedica).verifyComplete();
	}
	@Test
	void testVarios() {
		Flux<citasDTOReactiva> uno = citasReactivaService.findByIdPaciente("12");
		StepVerifier.create(uno).expectComplete();
	}

}
