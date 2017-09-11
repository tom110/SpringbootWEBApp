package tom.springboot.springbootwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tom.springboot.springbootwebapp.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
