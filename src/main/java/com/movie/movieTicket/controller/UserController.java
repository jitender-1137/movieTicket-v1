package com.movie.movieTicket.controller;

import com.movie.movieTicket.data.co.UserCo;
import com.movie.movieTicket.dto.ResponseDto;
import com.movie.movieTicket.dto.SuccessResponseDto;
import com.movie.movieTicket.dto.UserDto;
import com.movie.movieTicket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/v1")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseDto addUser(@Valid @RequestBody UserCo userCo) {

        UserDto userDto = userService.addNewUser(userCo);

        return new SuccessResponseDto(userDto, "user add successfully");
    }

    @GetMapping("/get")
    public ResponseDto getUser() {
        List<UserDto> userDto = userService.getAll();
        return new SuccessResponseDto(userDto, "fetch successfully ", Long.valueOf(userDto.size()));

    }
}
