package tom.springboot.springbootwebapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tom.springboot.springbootwebapp.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "select u from User u where username=?1")
    User findByUsername(String username);
}
