package studentservice.data;

import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<StudentEntity,Long>{
	
	

}
