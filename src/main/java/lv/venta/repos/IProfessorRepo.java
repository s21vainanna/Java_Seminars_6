package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

public interface IProfessorRepo extends CrudRepository<Professor, Long> {
	//it will generate query
}
