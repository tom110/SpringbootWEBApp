package tom.springboot.springbootwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tom.springboot.springbootwebapp.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
