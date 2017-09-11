package tom.springboot.springbootwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tom.springboot.springbootwebapp.domain.Permission;

public interface PermssionRepository  extends CrudRepository<Permission, Integer> {
}
