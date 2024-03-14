package com.elif.service;

import com.elif.domain.Room;
import com.elif.domain.Tags;
import com.elif.dto.request.RoomSaveRequestDto;
import com.elif.dto.request.TagsSaveRequestDto;
import com.elif.exception.ErrorType;
import com.elif.exception.OtelException;
import com.elif.mapper.RoomMapper;
import com.elif.repository.TagsRepository;
import com.elif.utility.ServiceManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagsService extends ServiceManager<Tags,String> {
    private final TagsRepository repository;

    public TagsService(TagsRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Tags save(TagsSaveRequestDto dto) {
        Optional<Tags> optionalTags = repository.findByName(dto.getName());
        if(optionalTags.isPresent()){
            throw new OtelException(ErrorType.TAG_ALLREADY_EXIST);
        }
        Tags tags = Tags.builder()
                .name(dto.getName())
                .build();
        return save(tags);

    }
    public List<Tags> findByIdContaining(List<String> tagsList) {
        return repository.findByIdContaining(tagsList);
    }
}
