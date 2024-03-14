package com.elif.domain;

import com.elif.utility.Enum.EImageCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Image extends BaseEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name; //otel içermeli kaydeden için Bebek-Otel-r2434.jpg gibi.
    private String url;
    private EImageCategory category;
    private String roomId;
}
