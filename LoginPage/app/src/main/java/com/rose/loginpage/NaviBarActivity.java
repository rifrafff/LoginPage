package com.rose.loginpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NaviBarActivity extends AppCompatActivity {
    BottomNavigationView navibarim;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navibar_page);
        navibarim=findViewById(R.id.bnavim);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new HomeFragment()).commit();
        navibarim.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new HomeFragment()).commit();
                        break;
                    case R.id.share:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new ShareFragment()).commit();
                        break;
                    case R.id.person:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new PersonFragment()).commit();
                }
                return false;
            }
        });

    }


}