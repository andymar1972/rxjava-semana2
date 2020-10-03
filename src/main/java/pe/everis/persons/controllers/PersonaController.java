package pe.everis.persons.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import pe.everis.persons.models.entity.Persona;
import pe.everis.persons.models.service.IPersonaService;

@RestController
public class PersonaController {

	@Autowired
	private IPersonaService personaService;

	@GetMapping("/personas")
	public Observable<Persona> listar() {
		return personaService.findAll();
	}

	@GetMapping("/persona/{dni}")
	public Maybe<Persona> detalle(@PathVariable Integer dni) {
		return personaService.findByDni(dni);
	}

}
