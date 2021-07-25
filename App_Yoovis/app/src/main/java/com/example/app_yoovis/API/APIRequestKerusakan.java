package com.example.app_yoovis.API;

import com.example.app_yoovis.Model.DataResponse;
import com.example.app_yoovis.Model.LoginRequest;
import com.example.app_yoovis.Model.LoginResponse;
import com.example.app_yoovis.Model.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIRequestKerusakan {

    @GET("api/kerusakan")
    Call<DataResponse> getKerusakan(@Header("Authorization") String token);

}
