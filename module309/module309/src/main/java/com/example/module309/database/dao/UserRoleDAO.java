package com.example.module309.database.dao;

import com.example.module309.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    UserRole findById(Integer id);

    List<UserRole> findByUserId(Integer userId);
}
