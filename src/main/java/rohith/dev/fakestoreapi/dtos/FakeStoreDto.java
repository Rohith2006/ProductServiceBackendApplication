package rohith.dev.fakestoreapi.dtos;

import lombok.Getter;
import lombok.Setter;
import rohith.dev.fakestoreapi.models.Category;

@Getter
@Setter
public class FakeStoreDto {
    private Long id;
    private String title;
    private double price;

    private String category;
    private String description;
    private String image;
}
