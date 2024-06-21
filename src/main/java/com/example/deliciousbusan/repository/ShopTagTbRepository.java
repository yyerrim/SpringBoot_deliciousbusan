package com.example.deliciousbusan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deliciousbusan.model.ShopTagTb;
import com.example.deliciousbusan.model.TagTb;

public interface ShopTagTbRepository extends JpaRepository<ShopTagTb, Integer> {
    // 문제 3)
    public List<ShopTagTb> findByTagTb(TagTb tagTb);
}
