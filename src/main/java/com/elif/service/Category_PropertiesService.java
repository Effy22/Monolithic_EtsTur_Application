package com.elif.service;

import com.elif.domain.Category_Properties;
import com.elif.dto.request.Category_PropertiesSaveRequestDto;
import com.elif.exception.ErrorType;
import com.elif.exception.OtelException;
import com.elif.repository.Category_PropertiesRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Category_PropertiesService extends ServiceManager<Category_Properties,String> {
    private final Category_PropertiesRepository repository;
    public Category_PropertiesService(Category_PropertiesRepository repository) {
        super(repository);
        this.repository = repository;

    }

    public Category_Properties save(Category_PropertiesSaveRequestDto dto) {

         Optional<Category_Properties> category_properties2 = repository.findOptionalByCategoryIdAndPropertyId(dto.getCategoryId(),dto.getPropertyId());
         if(category_properties2.isPresent()){
             throw new OtelException(ErrorType.CATEGORY_PROPERTIES_ALREADY_EXIST);
         }

        Category_Properties category_properties= Category_Properties.builder()
                .categoryId(dto.getCategoryId())
                .propertyId(dto.getPropertyId())
                .build();
        return save(category_properties);
    }
}
