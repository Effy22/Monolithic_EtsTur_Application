package com.elif.dto.request;

import com.elif.utility.Enum.EImageCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageSaveRequestDto {

    private String url;
    private EImageCategory category;
    private String name;
    private String roomId;
}
