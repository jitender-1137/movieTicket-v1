package com.movie.movieTicket.service;

import com.movie.movieTicket.dao.UserDao;
import com.movie.movieTicket.data.co.UserCo;
import com.movie.movieTicket.dto.UserDto;
import com.movie.movieTicket.exception.ServiceException;
import com.movie.movieTicket.model.User;
import com.movie.movieTicket.utility.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    MessageSource messageSource;

    @Override
    public UserDto addNewUser(@Valid UserCo userCo) {
        User user = CommonUtil.convert(userCo, User.class);
        user.setName(userCo.getName());
        if (CommonUtil.isValidGmail(userCo.getEmail())) {
            user.setEmail(userCo.getEmail().trim());
        } else {
            log.info("email much contain '@gmail.com'");
            throw new ServiceException("CS_03");
        }

        String isValidUsername = validateUsername(userCo.getUsername());
        user.setUsername(isValidUsername);
        user.setDob(Date.valueOf(userCo.getDob()));
        user.setTermsAndConditions(userCo.isTermsAndCondtions());

        if (!userCo.getPassword().trim().equals(userCo.getRePassword().trim())) {
            log.info("password and repassword are mismatch");
            throw new ServiceException("CS_02");
        } else if (!CommonUtil.isValidPassword(userCo.getPassword().trim())) {
            log.info(
                    "password must contain atleast one number, one small alphabet, one capital alphabet and one special charactor");
            throw new ServiceException("CS_04");
        } else {
            user.setPassword(userCo.getPassword().trim());
        }

        user.setCreatedAt(System.currentTimeMillis());
        user.setUpdatedAt(System.currentTimeMillis());
        User saveUser = userDao.save(user);
        if (saveUser.getId() != null) {
            return CommonUtil.convert(saveUser, UserDto.class);
        }
        return null;
    }

    private String validateUsername(String username) {
        username = CommonUtil.removeWhiteSpace(username);
        List<User> userList = userDao.getByUsername(username);
        if (!userList.isEmpty()) {
            throw new ServiceException("CS_01");
        }
        return username;
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> userDtoList = new ArrayList<>();
        UserDto userDto = new UserDto();
        List<User> list = userDao.findAll();

        for (User user : list) {
            userDto = CommonUtil.convert(user, UserDto.class);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

}
