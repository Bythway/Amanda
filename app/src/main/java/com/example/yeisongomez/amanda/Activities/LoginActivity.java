package com.example.yeisongomez.amanda.Activities;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.yeisongomez.amanda.R;

public class LoginActivity extends AppCompatActivity {

    Button login;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        login = (Button) findViewById(R.id.login_button);

        login.setOnClickListener(login());
    }

    private View.OnClickListener login(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(LoginActivity.this, WebViewChairaActivity.class);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }
}
