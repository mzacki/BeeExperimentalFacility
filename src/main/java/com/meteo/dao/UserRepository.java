package com.meteo.dao;

import com.meteo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Matt on 17.05.2019 at 11:02.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
}
