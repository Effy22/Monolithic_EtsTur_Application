package com.elif.domain;

import com.elif.utility.Enum.EPaymentType;
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
public class Payment extends BaseEntity {
    @Id
    private String id;
    private String reservationId;
    private Double totalPrice;
    private EPaymentType paymentType;
}
