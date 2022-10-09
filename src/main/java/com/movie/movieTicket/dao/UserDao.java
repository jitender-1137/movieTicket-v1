package com.movie.movieTicket.dao;

import com.movie.movieTicket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User save(@Valid User userDto);

    @Query(value = "SELECT * FROM User u WHERE u.username = ?1", nativeQuery = true)
    List<User> getByUsername(String username);

}
