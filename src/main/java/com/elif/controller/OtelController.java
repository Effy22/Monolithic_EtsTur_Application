package com.elif.controller;

import com.elif.domain.*;
import com.elif.dto.request.*;
import com.elif.dto.response.HomePageOtelResponseDto;
import com.elif.dto.response.OtelSaveResponseDto;
import com.elif.service.OtelService;
import com.elif.utility.Enum.ERoomType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.elif.constants.RestApiUrl.*;

@RestController
@RequestMapping(OTEL)
@RequiredArgsConstructor
public class OtelController {
    // TAG ,IMAGE,ROOM,ADDRESS

    private final OtelService otelService;

    @PostMapping(CREATE_OTEL)
    public ResponseEntity<OtelSaveResponseDto> saveOtel(@RequestBody OtelSaveRequestDto dto ){
        return ResponseEntity.ok(otelService.saveOtel(dto));

    }
    @PostMapping(CREATE_CATEGORY)
    public ResponseEntity<Category> saveCategory(@RequestBody CategorySaveRequestDto dto){
        return ResponseEntity.ok(otelService.saveCategory(dto));
    }

    @PostMapping(CREATE_PROPERTIES)
    public ResponseEntity<Properties> saveProperties(@RequestBody PropertySaveRequestDto dto){
        return ResponseEntity.ok(otelService.saveProperty(dto));
    }

    @PostMapping(CREATE_CATEGORY_PROPERTIES)
    public ResponseEntity<Category_Properties> saveCategoryProperties(@RequestBody Category_PropertiesSaveRequestDto dto){
        return ResponseEntity.ok(otelService.saveCategory_properties(dto));
    }

    @PostMapping(CREATE_ADDRESS)
    public ResponseEntity<Address> saveAddress(@RequestBody AddressSaveRequestDto dto){
        return ResponseEntity.ok(otelService.saveAddress(dto));
    }

    @PostMapping(CREATE_IMAGE)
    public ResponseEntity<Image> saveImage(@RequestBody ImageSaveRequestDto dto ){
        return ResponseEntity.ok(otelService.saveImage(dto));

    }
    @PostMapping(CREATE_TAG)
    public ResponseEntity<Tags> saveTag(@RequestBody TagsSaveRequestDto dto ){
        return ResponseEntity.ok(otelService.saveTags(dto));

    }

    @PostMapping(value = CREATE_ROOM, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Room> saveRoom(@RequestParam("roomType") ERoomType roomType, @ModelAttribute RoomSaveRequestDto dto){
        return ResponseEntity.ok(otelService.saveRoom(dto));
    }

    @GetMapping(FILTER_LIST)
    public ResponseEntity<Map<Properties, List<Properties>>> filterList() {
        return ResponseEntity.ok(otelService.filterList());
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<HomePageOtelResponseDto>> findAll(){
        return ResponseEntity.ok(otelService.findAllByPoint());
    }
    @GetMapping(FIND_OTEL_BY_NAME)
    public ResponseEntity<List<HomePageOtelResponseDto>> findOtelByName(@RequestBody String search){
        return ResponseEntity.ok(otelService.findOtelByName(search));
    }

    @GetMapping(FIND_OTEL_BY_ADDRESSNAME)
    public ResponseEntity<List<HomePageOtelResponseDto>> findOtelByAddressName(@RequestBody String search){
        return ResponseEntity.ok(otelService.findAddressByName(search));
    }
    @GetMapping(FIND_OTEL_BY_ID)
    public ResponseEntity<Otel> findOtelById(@RequestParam String id){
        return ResponseEntity.ok(otelService.findOtelById(id));
    }


}
