package com.example.deliciousbusan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class FavoriteTb {
  @Id
  int id;

  String regDate;

  @ManyToOne
  @JoinColumn(name = "shop_id")
  ShopTb shopTb;

  @ManyToOne
  @JoinColumn(name = "user_id")
  UserTb userTb;
}
