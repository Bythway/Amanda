package com.example.yeisongomez.amanda.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yeisongomez.amanda.R;

public class LoginActivity extends AppCompatActivity {

    EditText user;
    EditText password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.login_user);
        password = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login_button);

        login.setOnClickListener(login());
    }

    private View.OnClickListener login(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }
}
