package com.example.deliciousbusan.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class TagTb {
  @Id
  int tagId;
  String tagName;
  int hitCnt;

  // 문제 5)
  @OneToMany(mappedBy = "tagTb")
  List<ShopTagTb> shopTagTbList = new ArrayList<>();
}
