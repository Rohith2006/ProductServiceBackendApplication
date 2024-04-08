package rohith.dev.fakestoreapi.controllers;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import rohith.dev.fakestoreapi.models.Product;
import rohith.dev.fakestoreapi.service.ProductService;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/sayhello")
    public String sayHello(){
        return  "Hello Wolrd";
    }

    // this {ID}is PathURL
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        System.out.println(id);
        return productService.getSingleProduct(id);
    }


    @GetMapping("/products")
    public ArrayList<Product> CreateProduct(){
        return productService.getAllProducts();
    }


}
