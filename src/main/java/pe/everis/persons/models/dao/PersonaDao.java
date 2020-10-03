package pe.everis.persons.models.dao;

import org.springframework.data.repository.CrudRepository;

import pe.everis.persons.models.entity.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long> {

}
