package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity implements View.OnClickListener {
    EditText etNewName,etNewPass,etNewEmail;
    RadioGroup gender;
    Button etNewRegister;
    TextView tvLogin;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialize();
        etNewRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    private void initialize() {
        etNewName=findViewById(R.id.etNewName);
        etNewEmail=findViewById(R.id.etNewEmail);
        etNewPass=findViewById(R.id.etNewPass);
        etNewRegister=findViewById(R.id.etNewRegister);
        tvLogin=findViewById(R.id.tvLogin);
        gender=findViewById(R.id.gender);
        preferences=getSharedPreferences("UserInfo",0);

    }
    public void onClick(View v) {
        if(v==etNewRegister) {
            String etNewNameValue = etNewName.getText().toString();
            String etNewEmailValue = etNewEmail.getText().toString();
            String etNewPassValue = etNewPass.getText().toString();
            if (etNewEmailValue.length() > 1&&etNewNameValue.length()>1&&etNewPassValue.length()>1) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("etNewName", etNewNameValue);
                editor.putString("etNewEmail", etNewEmailValue);
                editor.putString("etNewPass", etNewPassValue);
                editor.apply();
                Toast.makeText(register.this, "User successfully registered", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(register.this, "Enter value first!", Toast.LENGTH_SHORT).show();
            }
        }
        if(v==tvLogin){
            Intent intent1=new Intent(register.this,login.class);
            startActivity(intent1);
        }
    }
}