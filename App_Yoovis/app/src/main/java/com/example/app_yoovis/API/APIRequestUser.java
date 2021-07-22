package com.example.app_yoovis.API;

import com.example.app_yoovis.Model.LoginRequest;
import com.example.app_yoovis.Model.LoginResponse;
import com.example.app_yoovis.Model.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIRequestUser {
    @POST("api/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
    @POST("api/logout")
    Call<LoginResponse> userLogout(@Header("Authorization") String token);
    @POST("api/register")
    Call<LoginResponse> userRegister(@Body RegisterRequest registerRequest);
}
