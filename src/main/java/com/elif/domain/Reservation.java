package com.elif.domain;

import com.elif.utility.Enum.EReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Reservation extends BaseEntity{
    @Id
    private String id;
    private String userId;
    private String otelId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalPrice;
    private Double discountRate;
    private String paymentId;

    private EReservationStatus status;


}
