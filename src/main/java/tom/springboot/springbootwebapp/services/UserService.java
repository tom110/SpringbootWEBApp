package tom.springboot.springbootwebapp.services;

import tom.springboot.springbootwebapp.domain.User;

public interface UserService extends CRUDService<User> {

    User findByUsername(String username);

}
