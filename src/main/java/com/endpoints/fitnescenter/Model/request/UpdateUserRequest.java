package com.endpoints.fitnescenter.Model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequest {

    @NotBlank
    @Size(max = 30)
    private String name;

    @NotBlank
    @Email
    @Size(max = 30)
    private String email;

    @Size(max = 100)
    private String password;

    @NotBlank
    @Size(max = 30)
    private String phone;

    @NotBlank
    @Size(max = 30)
    private String nameCard;

    @NotBlank
    @Size(max = 50)
    private String numberCreditCard;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expiredDate;

}
