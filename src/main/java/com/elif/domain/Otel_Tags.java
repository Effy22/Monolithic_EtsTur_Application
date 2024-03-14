package com.elif.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Otel_Tags extends BaseEntity {

    @Id
    private String id;
    private String otelId;
    private String tagId;
}
