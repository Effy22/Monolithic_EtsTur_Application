package com.elif.service;

import com.elif.domain.Image;
import com.elif.dto.request.ImageSaveRequestDto;
import com.elif.exception.ErrorType;
import com.elif.exception.OtelException;
import com.elif.repository.ImageRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService extends ServiceManager<Image,String> {
    private final ImageRepository repository;
    public ImageService(ImageRepository repository) {
        super(repository);
        this.repository = repository;

    }

    public Image save(ImageSaveRequestDto dto) {
        Optional<Image> optionalImage = repository.findByName(dto.getName());
        if(optionalImage.isPresent()){
            throw new OtelException(ErrorType.IMAGE_ALREADY_EXIST);
        }
        Image image = Image.builder()
                .name(dto.getName())
                .url(dto.getUrl())
                .category(dto.getCategory())
                .roomId(dto.getRoomId())
                .build();

       return save(image);
    }
}
