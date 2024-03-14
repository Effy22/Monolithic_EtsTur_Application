package com.elif.service;

import com.elif.domain.Properties;
import com.elif.dto.request.PropertySaveRequestDto;
import com.elif.exception.ErrorType;
import com.elif.exception.OtelException;
import com.elif.repository.PropertiesRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PropertiesService extends ServiceManager<Properties,String> {

    private final PropertiesRepository repository;
    public PropertiesService(PropertiesRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Properties save(PropertySaveRequestDto dto){

        Optional<Properties> optionalProperties = repository.findByName(dto.getName());
        if(optionalProperties.isPresent()){
            throw new OtelException(ErrorType.PROPERTIES_ALREADY_EXIST);
        }
        Properties properties = Properties.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .parentId(dto.getParentId())
                .build();

        return save(properties);
    }

    public Map<Properties, List<Properties>> filterList() {
        List<Properties> allProperties = repository.findAll(); //parentId null kontrolü koy, groupby ile parentıd null olanları listele
        Map<Properties, List<Properties>> propertiesWithSubProperties = new HashMap<>();
        for (Properties property : allProperties) {
            List<Properties> subProperties = repository.findByParentId(property.getId());
            if (Objects.isNull(property.getParentId()) || property.getParentId().isEmpty())
                propertiesWithSubProperties.put(property, subProperties);
        }
        return propertiesWithSubProperties;
    }



}
