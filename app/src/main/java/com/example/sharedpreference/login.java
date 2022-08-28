package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText etEmail,etPassword;
    Button login_btn;
    TextView register;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
        login_btn.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    private void initialize() {
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        login_btn=findViewById(R.id.login_btn);
        register=findViewById(R.id.register);
        preferences=getSharedPreferences("UserInfo",0);
    }
    public void onClick(View v){
        if(v==login_btn) {
            String etEmailValue = etEmail.getText().toString();
            String etPasswordValue = etPassword.getText().toString();
            String registeredEmail=preferences.getString("etNewEmail","");
            String registeredPassword=preferences.getString("etNewPass","");
            if(etEmailValue.equals(registeredEmail)&&etPasswordValue.equals(registeredPassword)){
                Intent intent=new Intent(login.this,dashboard.class);
                startActivity(intent);
            }
        }
        if(v==register){
            Intent intent1 = new Intent(login.this,register.class);
            startActivity(intent1);
        }

    }
}