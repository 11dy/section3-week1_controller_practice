package com.codestates;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RestClientExample01 {
    public static void main(String[] args) {
        // 객체 생성
        RestTemplate restTemplate =
                new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        // HTTP Request를 요청할 엔드포인트의 URI를 생성
        UriComponents uriComponents =
                UriComponentsBuilder
                        .newInstance() // 객체 생성
                        .scheme("http") // URI의 scheme을 설정
                        .host("worldtimeapi.org") // 호스트 정보
                        .port(80) // 디폴트 80. 생략가능
                        // URI의 path에서 {continents}, {city} 의 두 개의 템플릿 변수를 사용
                        .path("/api/timezone/{continents}/{city}")
                        .encode()
                        .build();
        //빌드 타임에 {continents}는 ‘Asia’, {city}는 ‘Seoul’로 변환
        URI uri = uriComponents.expand("Asia", "Seoul").toUri();

        // request 전송
//        String result = restTemplate.getForObject(uri, String.class); // getForObject는 HTTP Get 요청을 통해 서버의 리소스를 조회
//        System.out.println(result);
        // 응답 데이터를 받기 위한 클래스를 사용하는 방식
//        WorldTime worldTime = restTemplate.getForObject(uri, WorldTime.class);
//
//        System.out.println("# datatime: " + worldTime.getDatetime());
//        System.out.println("# timezone: " + worldTime.getTimezone());
//        System.out.println("# day_of_week: " + worldTime.getDay_of_week());

        //getForEntity()를 사용한 Response Body(바디, 컨텐츠) + Header(헤더) 정보 전달 받기
//        ResponseEntity<WorldTime> response =
//                restTemplate.getForEntity(uri, WorldTime.class);
//
//        System.out.println("# datatime: " + response.getBody().getDatetime());
//        System.out.println("# timezone: " + response.getBody().getTimezone()());
//        System.out.println("# day_of_week: " + response.getBody().getDay_of_week());
//        System.out.println("# HTTP Status Code: " + response.getStatusCode());
//        System.out.println("# HTTP Status Value: " + response.getStatusCodeValue());
//        System.out.println("# Content Type: " + response.getHeaders().getContentType());
//        System.out.println(response.getHeaders().entrySet());

    }
}
