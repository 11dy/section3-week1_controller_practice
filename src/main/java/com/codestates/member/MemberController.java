package com.codestates.member;

import com.codestates.member.MemberPatchDto;
import com.codestates.member.MemberPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController   // (1)해당 클래스가 REST API의 리소스(자원, Resource)를 처리하기 위한 API 엔드포인트로 동작함을 정의
// 또한 애플리케이션 로딩 시, Spring Bean으로 등록
//@RequestMapping("/v1/members")   // (2) 클라이언트의 요청과 클라이언트 요청을 처리하는 핸들러 메서드(Handler Method)를 매핑해주는 역할
@RequestMapping( "/v1/members")
public class MemberController {
    @PostMapping//클라이언트의 요청 데이터(request body)를 서버에 생성할 때 사용하는 애너테이션
    // 회원 정보 등록
    public ResponseEntity postMember(@RequestParam("email") String email,  // @RequestParam은 핸들러 메서드의 파라미터 종류 중 하나
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone) {
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("name", name);
        map.put("phone", phone);
        // reponsentity 객체로 리턴, 응답 데이터와 http응답 상태를 함께 전달
        return new ResponseEntity<>(map, HttpStatus.CREATED); // HttpStatus.CREATED는 클라이언트의 POST 요청을 처리
    }

    @GetMapping("/{member-id}") // 클라이언트가 서버에 리소스를 조회할 때 사용하는 애너테이션
    public ResponseEntity getMember(@PathVariable("member-id")long memberId){ // 특정 회원의 정보를 클라이언트 쪽에 제공하는 핸들러 메서드
        System.out.println(" memberId: " + memberId);
        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 모든 회원 정보 조회
    @GetMapping // 별도의 URI를 지정해주지 않았기 때문에 클래스 레벨의 URI(“/v1/members”)에 매핑
    public ResponseEntity getMembers(){ // 회원 목록을 클라이언트에게 제공하는 핸들러 메서드
        System.out.println("# get Members");
        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 회원 정보 삭제
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {
        // No need business logic

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
