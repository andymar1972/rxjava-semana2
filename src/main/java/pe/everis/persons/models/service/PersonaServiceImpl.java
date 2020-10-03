package pe.everis.persons.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import pe.everis.persons.models.dao.PersonaDao;
import pe.everis.persons.models.entity.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private PersonaDao personaDao;

	@Override
	@Transactional(readOnly = true)
	public Observable<Persona> findAll() {
		return Observable.fromIterable(personaDao.findAll()).map(persona -> persona);
	}

	@Override
	@Transactional(readOnly = true)
	public Maybe<Persona> findByDni(Integer dni) {

		Maybe<Persona> personaConDni = this.findAll().filter(persona -> persona.getDni() == dni.intValue())
				.firstElement();

		return personaConDni;
	}

}
