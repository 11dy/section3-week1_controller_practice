package com.codestates.member;

import javax.validation.constraints.Pattern;

public class MemberPatchDto {
    private long memberId; // Request Body에 포한되는 데이터가 아니라 유효성 검증 필요 없다.
    @Pattern(regexp = "^\\S+(\\s?\\S+)*$", message = "회원 이름은 공백이 아니어야 합니다.")
    private String name;

    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",// 정규표현식 사용
            message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
}
