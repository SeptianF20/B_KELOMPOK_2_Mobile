package com.example.app_yoovis.API;

import com.example.app_yoovis.Model.DataResponse;
import com.example.app_yoovis.Model.DataUserResponse;
import com.example.app_yoovis.Model.LoginRequest;
import com.example.app_yoovis.Model.LoginResponse;
import com.example.app_yoovis.Model.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIRequestUser {
    @POST("api/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
    @POST("api/logout")
    Call<LoginResponse> userLogout(@Header("Authorization") String token);
    @POST("api/register")
    Call<LoginResponse> userRegister(@Body RegisterRequest registerRequest);

    @GET("api/datauser/{id}")
    Call<DataUserResponse> getDataUser(@Path("id") int id, @Header("Authorization") String auth);

}
