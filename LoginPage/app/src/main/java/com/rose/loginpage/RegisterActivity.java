package com.rose.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username,email,name,password;
    TextView back;
    Button registerr;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.txtUsername);
        email=findViewById(R.id.txtEmail);
        name=findViewById(R.id.txtName);
        password=findViewById(R.id.txtPassword);
        registerr=findViewById(R.id.btnRegister);
        back=findViewById(R.id.txtBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        registerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namee=name.getText().toString();
                String emaill=email.getText().toString();
                String usernamee=username.getText().toString();
                String passwordd=password.getText().toString();
                Database db = new Database(getApplicationContext(),"LoginApp",null,1);
                if(!TextUtils.isEmpty(namee) && !TextUtils.isEmpty(emaill) && !TextUtils.isEmpty(usernamee) && !TextUtils.isEmpty(passwordd)){
                    db.Register(namee,emaill,usernamee,passwordd);
                    Toast.makeText(RegisterActivity.this, "Başarıyla Kayıt Oldunuz", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                }else{
                    Toast.makeText(RegisterActivity.this, "Bilgiler Boş Olamaz", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}