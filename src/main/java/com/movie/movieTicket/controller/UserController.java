package com.movie.movieTicket.controller;

import com.movie.movieTicket.dto.ResponseDto;
import com.movie.movieTicket.dto.SuccessResponseDto;
import com.movie.movieTicket.dto.UserDto;
import com.movie.movieTicket.model.User;
import com.movie.movieTicket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseDto addUser(@Valid @RequestBody UserDto userDto) {

        User user = userService.addNewUser(userDto);

        return new SuccessResponseDto(user, "user add successfully");
    }

    @GetMapping("/get")
    public ResponseDto getUser() {
        List<User> user = userService.getAll();
        return new SuccessResponseDto(user, "fetch successfully ", Long.valueOf(user.size()));

    }
}
