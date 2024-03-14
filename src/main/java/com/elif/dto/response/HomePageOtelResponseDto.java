package com.elif.dto.response;

import com.elif.domain.Tags;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomePageOtelResponseDto {
    private String name;
    private String addressName;
    private Double point;
    private int commentCount;
    private List<Tags> tags;
}
