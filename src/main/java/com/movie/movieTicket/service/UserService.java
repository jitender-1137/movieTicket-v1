package com.movie.movieTicket.service;

import com.movie.movieTicket.data.co.UserCo;
import com.movie.movieTicket.dto.UserDto;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

    UserDto addNewUser(@Valid UserCo userCo);

    List<UserDto> getAll();

}
