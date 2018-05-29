package hello;

import org.springframework.data.repository.CrudRepository;
import hello.File;

public interface FileRepository extends CrudRepository<File, Long> {

}
