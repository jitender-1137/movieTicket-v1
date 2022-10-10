package com.movie.movieTicket.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String username;
    private String dob;
    private String password;
    private Long createdAt;
    private Long updatedAt;
    private boolean termsAndConditions;
}
