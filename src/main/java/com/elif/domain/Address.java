package com.elif.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Address extends BaseEntity{
    @Id
    private String id;
    private String name;
    private String streetNumber;
    private String district; //id yazıp heryerde düzeltebilirim.
    private String zipCode;
    private String description;

}
