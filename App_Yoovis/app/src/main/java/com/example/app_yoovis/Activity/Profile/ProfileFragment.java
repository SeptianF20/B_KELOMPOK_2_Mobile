package com.example.app_yoovis.Activity.Profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.app_yoovis.API.APIRequestUser;
import com.example.app_yoovis.API.APIUtils;
import com.example.app_yoovis.Activity.Auth.LoginActivity;
import com.example.app_yoovis.Activity.Auth.SharedPref;
import com.example.app_yoovis.Model.LoginResponse;
import com.example.app_yoovis.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment {

    View view;
    public APIRequestUser apiRequestUser;
    private String token;
    ImageView btnLogout;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        apiRequestUser = APIUtils.getRequestUser();
        String code = SharedPref.getLoginToken(getActivity());
        token = "Bearer "+code;

        btnLogout = view.findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout(token);
            }
        });

        return view;

    }

    public void logout(String token){
        Call<LoginResponse> logoutCall = apiRequestUser.userLogout(token);
        logoutCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    String message = response.body().getMessage();
                    SharedPref.clearLogoutUser(getActivity());
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().finish();
                    Toast.makeText(getActivity(), "Success"+message,Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(), "Logout Failed",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

}