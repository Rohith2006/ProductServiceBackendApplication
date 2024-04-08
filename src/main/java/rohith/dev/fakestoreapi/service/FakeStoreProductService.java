package rohith.dev.fakestoreapi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import rohith.dev.fakestoreapi.dtos.FakeStoreDto;
import rohith.dev.fakestoreapi.models.Category;
import rohith.dev.fakestoreapi.models.Product;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate = new RestTemplate();
    public Product convertDtoToProduct(FakeStoreDto fakeStoreDto){
        Product product = new Product();
        product.setId(fakeStoreDto.getId());
        product.setTitle(fakeStoreDto.getTitle());
        product.setPrice(fakeStoreDto.getPrice());
        product.setImageURL(fakeStoreDto.getImage());
        product.setDescription(fakeStoreDto.getDescription());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreDto.getCategory());
        return product;
    }
    @Override
    public Product getSingleProduct(Long id){
        FakeStoreDto fakeStoreDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,
                FakeStoreDto.class
        );
//        System.out.println("runnig");
        return convertDtoToProduct(fakeStoreDto);
    };

    @Override
    public ArrayList<Product> getAllProducts(){
        FakeStoreDto[] fakeStoreDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreDto[].class
        );
        ArrayList<Product> products = new ArrayList<>();
        for(FakeStoreDto fakeStoreDto: fakeStoreDtos){
            products.add(convertDtoToProduct(fakeStoreDto));
        }
        return products;
    };


}
