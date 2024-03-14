package com.elif.service;

import com.elif.domain.Category;
import com.elif.dto.request.CategorySaveRequestDto;
import com.elif.exception.ErrorType;
import com.elif.exception.OtelException;
import com.elif.repository.CategoryRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService extends ServiceManager<Category,String> {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository ) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;

    }

    public Category save(CategorySaveRequestDto dto) {

        Optional<Category> optionalCategory = categoryRepository.findByName(dto.getName());
        if(optionalCategory.isPresent()){
            throw new OtelException(ErrorType.CATEGORY_ALREADY_EXIST);
        }
        Category category = Category.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();

        return save(category);
    }
}
