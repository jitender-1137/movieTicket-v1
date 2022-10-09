package com.movie.movieTicket.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotBlank
    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, message = "Username should have atleast 6 characters")
    private String username;

    @NotBlank
    @Size(min = 8, message = "Password should have atleast 8 characters")
    private String password;

    @NotBlank
    private String rePassword;

}
