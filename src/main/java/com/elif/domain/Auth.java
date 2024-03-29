package com.elif.domain;

import com.elif.utility.Enum.ERole;
import com.elif.utility.Enum.EStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
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
public class Auth extends BaseEntity{
    @Id
    private String id;
    @Email
    @NotNull
    private String email;
    @Indexed(unique = true)
    @NotNull
    private String username;
    @Size(min = 8, max = 20)
    @NotNull
    private String password;

    @Builder.Default
    private ERole role = ERole.USER;
    @Builder.Default
    private EStatus status = EStatus.PENDING;

    private String activationCode;
}
