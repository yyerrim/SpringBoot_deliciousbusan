package com.example.deliciousbusan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ShopTagTb {
  @Id
  int seq;

  @ManyToOne
  @JoinColumn(name = "shop_id")
  ShopTb shopTb;

  @ManyToOne
  @JoinColumn(name = "tag_id")
  TagTb tagTb;
}
