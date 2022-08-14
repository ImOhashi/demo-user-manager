package com.ohashi.demousermanager.application.web.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank
    private String nickname;

    @NotNull
    @NotEmpty
    @NotBlank
    private String password;

    @Email
    @NotNull
    @NotEmpty
    @NotBlank
    private String email;
}
