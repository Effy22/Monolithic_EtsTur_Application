package com.elif.domain;

import com.elif.utility.Enum.ERoomType;
import com.elif.utility.Enum.RoomProperties;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Room extends BaseEntity{
    @Id
    private String id;
    @NotNull
    private String name;
    private int roomNumber;
    private ERoomType eRoomType;
    private int personCapacity;
    private int bedCount;
    private int bathCount;
    private int roomCount;

    private Double unitPrice;
    private String description;

    @Builder.Default
    private List<RoomProperties> roomProperties = new ArrayList<>();


}
