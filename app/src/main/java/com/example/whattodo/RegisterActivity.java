package com.example.whattodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister;
    Button btnLinkToLoginScreen;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
        btnLinkToLoginScreen = findViewById(R.id.btnLinkToLoginScreen);
        btnLinkToLoginScreen.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnLinkToLoginScreen:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.btnRegister:
                Toast complete = Toast.makeText(this,
                        getString(R.string.registration_complete), Toast.LENGTH_SHORT);
                complete.show();
                intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;

        }

    }
}

