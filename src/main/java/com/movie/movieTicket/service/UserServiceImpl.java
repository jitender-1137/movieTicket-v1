package com.movie.movieTicket.service;

import com.movie.movieTicket.dao.UserDao;
import com.movie.movieTicket.dto.UserDto;
import com.movie.movieTicket.exception.ServiceException;
import com.movie.movieTicket.model.User;
import com.movie.movieTicket.utility.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    MessageSource messageSource;

    @Override
    public User addNewUser(@Valid UserDto userDto) {
        User user = CommonUtil.convert(userDto, User.class);
        user.setName(userDto.getName());
        if (CommonUtil.isValidGmail(userDto.getEmail())) {
            user.setEmail(userDto.getEmail().trim());
        } else {
            log.info("email much contain '@gmail.com'");
            throw new ServiceException("CS_03");
        }

        user.setUsername(CommonUtil.removeWhiteSpace(userDto.getUsername()));
        validateUsername(user.getUsername());


        if (!userDto.getPassword().trim().equals(userDto.getRePassword().trim())) {
            log.info("password and repassword are mismatch");
            throw new ServiceException("CS_02");
        } else if (!CommonUtil.isValidPassword(userDto.getPassword().trim())) {
            log.info(
                    "password must contain atleast one number, one small alphabet, one capital alphabet and one special charactor");
            throw new ServiceException("CS_04");
        } else {
            user.setPassword(userDto.getPassword());
        }

        user.setCreatedAt(System.currentTimeMillis());
        user.setUpdatedAt(System.currentTimeMillis());
        User saveUser = userDao.save(user);
        if (saveUser.getId() != null) {
            return CommonUtil.convert(saveUser, User.class);
        }
        return null;
    }

    private void validateUsername(String username) {
        if (!StringUtils.hasLength(username))
            return;
        List<User> userList = userDao.getByUsername(username);
        if (!userList.isEmpty()) {
            throw new ServiceException("CS_01");

        }
    }

    @Override
    public List<User> getAll() {
        List<User> list = userDao.findAll();
        return list;
    }

}
