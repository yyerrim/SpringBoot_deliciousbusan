package com.example.deliciousbusan.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class UserTb {
  @Id
  int userId;
  String userName;
  String email;
  String pass;
  String phoneNum;
  String regDate;

  // 문제 4)
  @OneToMany(mappedBy = "userTb")
  List<FavoriteTb> favoriteTbList = new ArrayList<>();
}
