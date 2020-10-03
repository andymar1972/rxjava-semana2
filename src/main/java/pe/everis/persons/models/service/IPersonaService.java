package pe.everis.persons.models.service;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import pe.everis.persons.models.entity.Persona;

public interface IPersonaService {

	public Observable<Persona> findAll();

	public Maybe<Persona> findByDni(Integer dni);

}
