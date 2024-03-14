package com.elif.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OtelSaveResponseDto {

    private String id;
    private String name;
    private String addressId;
    private String phoneNumber;
    private List<String> rooms;
    private List<String> comments;
    private List<String> images;
    private LocalDateTime entryHour;
    private LocalDateTime existHour;
}
