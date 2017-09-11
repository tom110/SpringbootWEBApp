package tom.springboot.springbootwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tom.springboot.springbootwebapp.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
