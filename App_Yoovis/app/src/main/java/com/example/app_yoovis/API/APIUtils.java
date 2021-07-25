package com.example.app_yoovis.API;

public class APIUtils {

    private APIUtils(){

    }

    public static final String API_URL = "https://wsjti.id/YooVis/public/";
//    public static final String API_URL = "http://192.168.1.70:8080/";
    public static APIRequestUser getRequestUser(){
        return RetrofitClient.getClient(API_URL).create(APIRequestUser.class);
    }
    public static APIRequestKerusakan getRequestKerusakan(){
        return RetrofitClient.getClient(API_URL).create(APIRequestKerusakan.class);
    }
}
