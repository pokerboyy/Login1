package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboard extends AppCompatActivity implements View.OnClickListener {
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initialize();
        logout.setOnClickListener(this);
    }

    private void initialize() {
        logout=findViewById(R.id.logout);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(dashboard.this,login.class);
        startActivity(intent);
    }
}