package com.elif.dto.request;

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
public class OtelSaveRequestDto {
    private String name;
    private String addressId;
    private String phoneNumber;
    private LocalDateTime entryHour;
    private LocalDateTime existHour;
}
