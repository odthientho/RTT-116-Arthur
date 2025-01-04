package com.example.module309.database.dao;

import com.example.module309.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findByEmailIgnoreCase(String email);

}
