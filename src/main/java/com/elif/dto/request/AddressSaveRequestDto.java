package com.elif.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressSaveRequestDto {

    private String name;
    private String streetNumber;
    private String district;
    private String zipCode;
    private String description;
}
