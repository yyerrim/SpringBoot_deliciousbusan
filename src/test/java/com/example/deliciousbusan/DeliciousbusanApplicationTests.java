package com.example.deliciousbusan;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.HTML.Tag;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.example.deliciousbusan.model.FavoriteTb;
import com.example.deliciousbusan.model.ShopTagTb;
import com.example.deliciousbusan.model.ShopTb;
import com.example.deliciousbusan.model.TagTb;
import com.example.deliciousbusan.model.UserTb;
import com.example.deliciousbusan.repository.FavoriteTbRepository;
import com.example.deliciousbusan.repository.ShopTagTbRepository;
import com.example.deliciousbusan.repository.ShopTbRepository;
import com.example.deliciousbusan.repository.TagTbRepository;
import com.example.deliciousbusan.repository.UserTbRepository;

@SpringBootTest
class DeliciousbusanApplicationTests {
	@Autowired
	FavoriteTbRepository favoriteTbRepository;
	@Autowired
	ShopTagTbRepository shopTagTbRepository;
	@Autowired
	ShopTbRepository shopTbRepository;
	@Autowired
	TagTbRepository tagTbRepository;
	@Autowired
	UserTbRepository userTbRepository;

	// 1. 자주 검색된 태그 상위 2개 확인
	// -> 해운대, 서면
	@Test
	void 문제1() {
		List<TagTb> t = tagTbRepository.findAllByOrderByHitCntDesc();
		for (int i = 0; i < 2; i++) {
			TagTb tagTb = t.get(i);
			String name = tagTb.getTagName();
			System.out.println(name);
		}
		// // 강사님 풀이
		// Direction direction = Direction.DESC;
		// Sort sort = Sort.by(direction, "hitCnt"); // 역순으로 hitCnt 정렬
		// Pageable pageable = PageRequest.of(0, 2, sort);
		// Page<TagTb> p = tagTbRepository.findAll(pageable);
		// List<TagTb> list = p.getContent();
		// for (TagTb t : list) {
		// 	System.out.println(t.getTagName());
		// }
	}

	// 2. 가장 많이 검색된 태그를 사용하는 매장 개수 확인
	// -> 44
	@Test
	@Transactional
	void 문제2() {
		List<TagTb> t = tagTbRepository.findAllByOrderByHitCntDesc();
		for (int i = 0; i < 1; i++) {
			TagTb tagTb = t.get(i);
			List<ShopTagTb> s = shopTagTbRepository.findByTagTb(tagTb);
			System.out.println(s.size());
		}
		// // 강사님 풀이
		// Direction direction = Direction.DESC;
		// Sort sort = Sort.by(direction, "hitCnt");
		// Pageable pageable = PageRequest.of(0, 1, sort);
		// Page<TagTb> p = tagTbRepository.findAll(pageable);
		// List<TagTb> list = p.getContent();
		// TagTb tt = list.get(0); // 데이터가 1건이란걸 아니까 한개만 뽑아오기
		// List<ShopTagTb> sttl = tt.getShopTagTbList();
		// int size = sttl.size();
		// System.out.println(size);
	}

	// 3. '거북선횟집' 매장에 연결된 모든 태그명 확인
	// -> 부산, 해운대구, 해운대, 미포, 거북선획집, 횟집, 모듬회, 바다보이는집, 단체, 모임, 한식
	@Test
	@Transactional
	void 문제3() {
		ShopTb shopTb = shopTbRepository.findByShopName("거북선횟집");
		List<ShopTagTb> list = shopTb.getShopTagTbList();
		for (ShopTagTb s : list) {
			TagTb tagId = s.getTagTb();
			String name = tagId.getTagName();
			System.out.println(name);
		}
	}

	// 4. '한구름' 사용자가 즐겨찾기로 등록된 매장명과 매장의 설명 확인
	// -> 디딤돌 싱싱한 굴과 고소한 보쌈 전문점 / 해림 꽃새우 회 전문점
	@Test
	@Transactional
	void 문제4() {
		UserTb userTb = userTbRepository.findByUserName("한구름");
		List<FavoriteTb> list = userTb.getFavoriteTbList();
		for (FavoriteTb f : list) {
			String 매장명 = f.getShopTb().getShopName();
			String 매장설명 = f.getShopTb().getShopDesc();
			System.out.printf("%s : %s\n", 매장명, 매장설명);
		}
	}

	// 5. 아이디가 64인 매장을 즐겨찾기로 등록된 사용자의 이름과 이메일 주소 확인
	// -> 김명 windo@gmail.com 양말 liox2xoil.nate.com
	@Test
	@Transactional
	void 문제5() {
		Optional<ShopTb> opt = shopTbRepository.findById(64);
		ShopTb shopTb = opt.get();
		List<FavoriteTb> list = shopTb.getFavoriteTbList();
		for (FavoriteTb f : list) {
			String name = f.getUserTb().getUserName();
			String email = f.getUserTb().getEmail();
			System.out.printf("%s:%s\n", name, email);
		}
	}

}
