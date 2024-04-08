package rohith.dev.fakestoreapi.service;

import java.util.ArrayList;

import rohith.dev.fakestoreapi.models.Product;

public interface ProductService {

    public Product getSingleProduct(Long id);

    public ArrayList<Product> getAllProducts();

}
