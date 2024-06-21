package com.example.deliciousbusan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deliciousbusan.model.ShopTb;

public interface ShopTbRepository extends JpaRepository<ShopTb, Integer> {
    // 문제 3)
    public ShopTb findByShopName(String shopName);
}
