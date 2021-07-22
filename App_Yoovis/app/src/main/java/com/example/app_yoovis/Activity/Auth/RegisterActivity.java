package com.example.app_yoovis.Activity.Auth;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_yoovis.API.APIRequestUser;
import com.example.app_yoovis.API.APIUtils;
import com.example.app_yoovis.Model.LoginResponse;
import com.example.app_yoovis.Model.RegisterRequest;
import com.example.app_yoovis.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    public APIRequestUser apiRequestUser;
    private Button reg_btn;
    private EditText reg_nama, reg_username, reg_email, reg_password, reg_konfirmasi;
    private String nama, username, email, password, konfimasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        apiRequestUser = APIUtils.getRequestUser();

        reg_btn = findViewById(R.id.reg_btn);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cariView();
                if (TextUtils.isEmpty(nama) || TextUtils.isEmpty(email) || TextUtils.isEmpty(username)
                        || TextUtils.isEmpty(password) || TextUtils.isEmpty(konfimasi)){
                    Toast.makeText(RegisterActivity.this, "Harap diisi semua!", Toast.LENGTH_SHORT).show();
                }else{
                    register();
                }
            }
        });

    }

    private void register(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setName(nama);
        registerRequest.setEmail(email);
        registerRequest.setUsername(username);
        registerRequest.setPassword(password);
        registerRequest.setPassword_confirmation(konfimasi);

        Call<LoginResponse> loginResponseCall = apiRequestUser.userRegister(registerRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    String msg = response.body().getMessage();
                    Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getBaseContext(), "Gagal Register", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Gagal Konek Server"+ t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }

    private void cariView(){
        reg_nama = findViewById(R.id.reg_nama);
        nama = reg_nama.getText().toString();

        reg_email = findViewById(R.id.reg_email);
        email = reg_email.getText().toString();

        reg_username = findViewById(R.id.reg_username);
        username = reg_username.getText().toString();

        reg_password = findViewById(R.id.reg_password);
        password = reg_password.getText().toString();

        reg_konfirmasi = findViewById(R.id.reg_konfirmasi);
        konfimasi = reg_konfirmasi.getText().toString();
    }


}