package com.movie.movieTicket.service;

import com.movie.movieTicket.dto.UserDto;
import com.movie.movieTicket.model.User;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

    User addNewUser(@Valid UserDto userDto);

    List<User> getAll();

}
