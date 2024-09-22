package com.example.userregistration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userregistration.dao.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByCollegeEmailId(String emailId);
}

