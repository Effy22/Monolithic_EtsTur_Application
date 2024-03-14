package com.elif.dto.request;

import com.elif.domain.Image;
import com.elif.utility.Enum.ERoomType;
import com.elif.utility.Enum.RoomProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomSaveRequestDto {
    private String name;
    private ERoomType eRoomType;
    private int roomNumber;
    private int personCapacity;
    private int bedCount;
    private int bathCount;
    private int roomCount;
    private Double unitPrice;
    private String description;
    private List<RoomProperties> roomProperties;
    private List<Image> imageList;
}
