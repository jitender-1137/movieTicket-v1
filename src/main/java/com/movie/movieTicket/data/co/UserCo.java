package com.movie.movieTicket.data.co;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserCo {

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
    private String dob;

    @NotBlank
    @Size(min = 8, message = "Password should have atleast 8 characters")
    private String password;

    @NotBlank
    private String rePassword;

    @AssertTrue(message = "Terms and Conditons must be checked")
    private boolean termsAndCondtions;
}
