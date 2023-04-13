package com.codestates;


// 전체 응답 데이터를 모두 전달 받는 것이 아니라 datetime과 timezone 정보만 전달
public class WorldTime {
    private String datetime;
    private String timezone;
    private int day_of_week;

    public String getDatetime() {
        return datetime;
    }

    public String getTimezone() {
        return timezone;
    }

    public int getDay_of_week() {
        return day_of_week;
    }
}
