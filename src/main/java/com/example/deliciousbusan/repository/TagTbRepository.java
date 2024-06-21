package com.example.deliciousbusan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deliciousbusan.model.TagTb;

public interface TagTbRepository extends JpaRepository<TagTb, Integer> {
    // 문제 1) 문제 2)
    public List<TagTb> findAllByOrderByHitCntDesc();
}
