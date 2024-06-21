package com.example.deliciousbusan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deliciousbusan.model.UserTb;

public interface UserTbRepository extends JpaRepository<UserTb, Integer> {
    // 문제 4)
    public UserTb findByUserName(String userName);
}
