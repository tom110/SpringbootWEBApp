package tom.springboot.springbootwebapp.services;


import tom.springboot.springbootwebapp.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
