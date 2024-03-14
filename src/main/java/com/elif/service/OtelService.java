package com.elif.service;

import com.elif.domain.*;
import com.elif.domain.Properties;
import com.elif.dto.request.*;
import com.elif.dto.response.FilterListResponseDto;
import com.elif.dto.response.HomePageOtelResponseDto;
import com.elif.dto.response.OtelSaveResponseDto;
import com.elif.exception.ErrorType;
import com.elif.exception.OtelException;
import com.elif.mapper.OtelMapper;
import com.elif.repository.OtelRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OtelService extends ServiceManager<Otel,String> {
    private final OtelRepository repository;
    private final CategoryService categoryService;
    private final PropertiesService propertiesService;
    private final Category_PropertiesService categoryPropertiesService;
    private final AddressService addressService;
    private final RoomService roomService;
    private final ImageService imageService;
    private final CommentService commentService;
    private final Otel_TagsService otel_tagsService;
    private final TagsService tagsService;
    public OtelService(TagsService tagsService,Otel_TagsService otel_tagsService,CommentService commentService,ImageService imageService,RoomService roomService,AddressService addressService,OtelRepository repository,CategoryService categoryService,PropertiesService propertiesService,Category_PropertiesService categoryPropertiesService) {
        super(repository);
        this.repository = repository;
        this.categoryService=categoryService;
        this.propertiesService=propertiesService;
        this.categoryPropertiesService=categoryPropertiesService;
        this.addressService=addressService;
        this.roomService=roomService;
        this.imageService=imageService;
        this.commentService=commentService;
        this.otel_tagsService=otel_tagsService;
        this.tagsService=tagsService;
    }

    public OtelSaveResponseDto saveOtel(OtelSaveRequestDto dto) {
       Optional<Otel> optionalOtel= repository.findByNameAndAddressId(dto.getName(),dto.getAddressId());
       if(optionalOtel.isPresent()){
           throw new OtelException(ErrorType.OTEL_ALREADY_EXIST);
       }

       Otel otel = OtelMapper.INSTANCE.fromSaveRequestDtoToOtel(dto);
       repository.save(otel);
       OtelSaveResponseDto otelSaveResponseDto = OtelMapper.INSTANCE.fromOtelToSaveResponseDto(otel);

       return otelSaveResponseDto;
    }

    public Category saveCategory(CategorySaveRequestDto dto){
        return categoryService.save(dto);
    }


    public Properties saveProperty(PropertySaveRequestDto dto) {
        return propertiesService.save(dto);
    }

    public Category_Properties saveCategory_properties(Category_PropertiesSaveRequestDto dto) {
        return categoryPropertiesService.save(dto);
    }

    public Room saveRoom(RoomSaveRequestDto dto) {
        return roomService.save(dto);
    }

    public Address saveAddress(AddressSaveRequestDto dto) {
        return addressService.save(dto);
    }

    public Image saveImage(ImageSaveRequestDto dto) {
        return imageService.save(dto);
    }


    public Map<Properties, List<Properties>> filterList() {
        return propertiesService.filterList();
    }


    public List<HomePageOtelResponseDto> findAllByPoint() {

        List<HomePageOtelResponseDto> otelDtoList=new ArrayList<>();
        List<Otel> otelList = findAll();

        otelList.stream()
                .map(this::getHomePageOtelResponseDto)
                .sorted(Comparator.comparingDouble(HomePageOtelResponseDto::getPoint).reversed())
                .forEach(otelDtoList::add);

        return otelDtoList;
    }

    private HomePageOtelResponseDto getHomePageOtelResponseDto(Otel otel) {
        Optional<Address> addressOptional = addressService.findById(otel.getAddressId());
        List<Comment> commentList = commentService.findByOtelId(otel.getId());
        List<Otel_Tags> otel_tagsList = otel_tagsService.findByOtelId(otel.getId());


        List<String> tagsList=otel_tagsList.stream().map(x->x.getTagId()).toList();
        List<Tags> tags =tagsService.findByIdContaining(tagsList);
        return HomePageOtelResponseDto.builder()
                .name(otel.getName())
                .point(otel.getPoint())
                .addressName(addressOptional.get().getName())
                .tags(tags)
                .commentCount(commentList.size())
                .build();

    }


    public Tags saveTags(TagsSaveRequestDto dto) {
        return tagsService.save(dto);
    }

    public List<HomePageOtelResponseDto> findOtelByName(String search) {

        List<HomePageOtelResponseDto> otelDtoList=new ArrayList<>();
        List<Otel> otelList = repository.findByNameContainingIgnoreCase(search);

        otelList.stream()
                .map(this::getHomePageOtelResponseDto)
                .sorted(Comparator.comparingDouble(HomePageOtelResponseDto::getPoint).reversed())
                .forEach(otelDtoList::add);
        return otelDtoList;
    }


    public List<HomePageOtelResponseDto> findAddressByName(String search) {

        List<HomePageOtelResponseDto> otelDtoList = new ArrayList<>();
        List<Address> addressList = addressService.findByNameContainingIgnoreCaseOrStreetNumberContainingIgnoreCase(search);
        List<String> addressListId = addressList.stream().map(x -> x.getId()).collect(Collectors.toList());
        repository.findAllByAddressIdIn(addressListId).stream()
                .map(this::getHomePageOtelResponseDto)
                .sorted(Comparator.comparingDouble(HomePageOtelResponseDto::getPoint).reversed())
                .forEach(otelDtoList::add);

        return otelDtoList;
    }

    public Otel findOtelById(String id) {
        return repository.findById(id).orElseThrow(() -> new OtelException(ErrorType.OTEL_NOT_FOUND));
    }

    public List<Otel> findAllByOtelIdIn(List<String> favOtels) {
        return repository.findAllByIdIn(favOtels);
    }
}
