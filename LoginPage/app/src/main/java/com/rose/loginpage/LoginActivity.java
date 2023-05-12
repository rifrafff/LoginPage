package com.rose.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    ImageView iconn;
    EditText kulAdi,sifre;
    Button login,register;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        kulAdi=findViewById(R.id.txtUsername1);
        sifre=findViewById(R.id.txtPassword1);
        register=findViewById(R.id.btnRegister1);
        login=findViewById(R.id.btnLogin);
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
        Animation anim1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim1);
        kulAdi.startAnimation(anim);
        sifre.startAnimation(anim1);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=kulAdi.getText().toString();
                String password=sifre.getText().toString();
                Database db = new Database(getApplicationContext(),"LoginApp",null,1);
                if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)){
                    if(db.Login(username,password)==1){
                        Toast.makeText(getApplicationContext(),username + " Hoşgeldiniz",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(LoginActivity.this,NaviBarActivity.class);
                        i.putExtra("username",username);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Kullanıcı Adı veya Şifre Yanlış", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Bilgiler Boş Olamaz", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}