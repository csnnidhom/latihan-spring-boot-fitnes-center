package com.endpoints.fitnescenter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "users",
        indexes = {
                @Index(name = "fk_name_user", columnList = "name")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private boolean active;

    private String otp;

    private LocalDateTime otp_generated_time;

    private String token;

    @Column(name = "token_expired_at")
    private Long tokenExpiredAt;

    private String name_credit_card;

    private String number_credit_card;

    @Column(name = "expired_credit_card")
    private Date card_expired;

}
