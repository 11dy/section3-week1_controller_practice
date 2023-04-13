package com.codestates.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {
    // 커피 정보 등록
    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("engName") String engName,
                                     @RequestParam("korName") String korName,
                                     @RequestParam("price") int price){
        Map<String, Object> map = new HashMap<>();
        map.put("engName", engName);
        map.put("korName", korName.trim()); // 한글 입력시 양 끝의 공백 제거
        map.put("price", Integer.valueOf(price));

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    // 특정 커피 정보를 제공하는 핸들러 메서드
    @GetMapping("/{coffee-id}") // 클라이언트가 서버에 리소스를 조회할 때 사용하는 애너테이션
    public ResponseEntity getCoffee(@PathVariable("coffee-id")long coffeeId){ // 특정 회원의 정보를 클라이언트 쪽에 제공하는 핸들러 메서드
        System.out.println(" coffeeId: " + coffeeId);
        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //커피 목록을 제공하는 핸들러 메서드
    @GetMapping
    public ResponseEntity getCoffees(){ // 회원 목록을 클라이언트에게 제공하는 핸들러 메서드
        System.out.println("# get Coffees");
        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }



}