package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dto.FakeStoreCategoryDto;
import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService{
    private final RestTemplate restTemplate;

    public FakeStoreCategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Category convertFakeStoreCategoryToProduct(FakeStoreCategoryDto fakeStoreCategoryDto){
        Category category = new Category();
        category.setId(fakeStoreCategoryDto.getId());
        category.setName(fakeStoreCategoryDto.getName());

        return category;
    }



    @Override
    public List<Category> getAllCategory() {
        FakeStoreCategoryDto[] categoryDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories/", FakeStoreCategoryDto[].class);

        List<Category> answer = new ArrayList<>();
        for (FakeStoreCategoryDto dto: categoryDto){
            answer.add(convertFakeStoreCategoryToProduct(dto));
        }

return answer;
    }

}
