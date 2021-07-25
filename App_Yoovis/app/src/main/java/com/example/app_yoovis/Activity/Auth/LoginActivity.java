package com.example.app_yoovis.Activity.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_yoovis.API.APIRequestUser;
import com.example.app_yoovis.API.APIUtils;
import com.example.app_yoovis.Activity.MainActivity;
import com.example.app_yoovis.Model.LoginRequest;
import com.example.app_yoovis.Model.LoginResponse;
import com.example.app_yoovis.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public APIRequestUser apiRequestUser;
    private Button btnLogin, btn_register;
    private EditText et_username, et_password;
    private String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        apiRequestUser = APIUtils.getRequestUser();

        btn_register = findViewById(R.id.log_btnregister);
        btnLogin = findViewById(R.id.login_btn);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findView();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(LoginActivity.this,"Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(LoginActivity.this,"Username: "+user+"Password: "+pass, Toast.LENGTH_SHORT).show();
                    cekData();
                }
            }
        });

    }

    public void cekData(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(user);
        loginRequest.setPassword(pass);

        Call<LoginResponse> loginResponseCall = apiRequestUser.userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    String msg = response.body().getMessage();
                    Integer id = response.body().getId();
                    String user = response.body().getUsername();
                    String token = response.body().getToken();

                    SharedPref.setLoginId(getBaseContext(), id.toString());
                    SharedPref.setLoginUsername(getBaseContext(), user);
                    SharedPref.setLogInToken(getBaseContext(), token);
                    SharedPref.setLoginStatus(getBaseContext(), true);

                    startActivity(new Intent(getBaseContext(), MainActivity.class));
                    finish();

//                    Toast.makeText(getBaseContext(),"pesan: "+msg+"Id: "+id+"Username: "+user+"Token: "+ token, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getBaseContext(),"Gagal login", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Gagal konek server: "+ t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void findView(){
        et_username = findViewById(R.id.login_username);
        user = et_username.getText().toString();
        et_password = findViewById(R.id.login_password);
        pass = et_password.getText().toString();
    }
}