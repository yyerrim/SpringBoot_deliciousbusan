package com.example.deliciousbusan.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class ShopTb {
  @Id
  int shopId;
  String shopName;
  String shopDesc;
  String address;
  String telNum;
  String parkingInfo;
  String latitude;
  String longitude;
  String regDate;

  // 문제 3)
  @OneToMany(mappedBy = "shopTb")
  List<ShopTagTb> shopTagTbList = new ArrayList<>();

  // 문제 5)
  @OneToMany(mappedBy = "shopTb")
  List<FavoriteTb> favoriteTbList = new ArrayList<>();
}
