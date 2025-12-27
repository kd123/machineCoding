package com.lms.domain;


import com.lms.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

}

