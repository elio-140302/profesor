package profesorrepositorio;

import org.springframework.data.repository.CrudRepository;

import profesorentity.Profesor;

public interface ProfesorRepository extends CrudRepository<Profesor, Integer> {

	}
