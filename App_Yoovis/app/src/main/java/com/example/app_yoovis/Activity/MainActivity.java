package com.example.app_yoovis.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.app_yoovis.API.APIRequestUser;
import com.example.app_yoovis.API.APIUtils;
import com.example.app_yoovis.Activity.Auth.LoginActivity;
import com.example.app_yoovis.Activity.Auth.SharedPref;
import com.example.app_yoovis.Activity.Home.HomeFragment;
import com.example.app_yoovis.Activity.Profile.ProfileFragment;
import com.example.app_yoovis.Activity.Transaksi.TransaksiFragment;
import com.example.app_yoovis.Model.LoginResponse;
import com.example.app_yoovis.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Boolean statusLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusLogin = SharedPref.getLogInStatus(getBaseContext());
        loadFragment (new HomeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_transaksi:
                if(statusLogin){
                    fragment = new TransaksiFragment();
                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                break;
            case R.id.nav_profile:
                if(statusLogin){
                    fragment = new ProfileFragment();
                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                break;
        }
        return loadFragment(fragment);
    }
}