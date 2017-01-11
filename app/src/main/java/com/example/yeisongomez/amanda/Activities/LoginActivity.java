package com.example.yeisongomez.amanda.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yeisongomez.amanda.Objects.User;
import com.example.yeisongomez.amanda.R;
import com.example.yeisongomez.amanda.SQLite.UserDB;

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

        Cursor user = onUser();
        if(user.getCount() > 0){
            navigationHome(user);
        } else {
            ImageView logo = (ImageView) findViewById(R.id.login_image);
            logo.setImageResource(R.mipmap.ic_launcher);

            login = (Button) findViewById(R.id.login_button);
            login.setOnClickListener(login());
        }
    }

    private View.OnClickListener login(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, WebViewChairaActivity.class);
                startActivity(intent);
            }
        };
    }

    private Cursor onUser(){
        UserDB userDB = new UserDB(this);
        userDB.open();
        //TODO Eliminar las 2 siguientes lineas para que cargue el login
        userDB.deleteUserAll();
        userDB.createUser(new User(1, "GOMEZ RODRIGUEZ", "YEISON ", "HOMBRE", "O+", "yeisom40@gmail.com", "ESTUDIANTE", "CAQUETA", "FLORENCIA", "ACTIVO", "https://avatars0.githubusercontent.com/u/14795272?v=3&u=40650119908b3b3daaf7ab0e9b8b5326dbb9909f&s=400"));

        Cursor cursor = userDB.getUsers();
        userDB.close();
        return cursor;
    }

    private void navigationHome(Cursor user){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        if(user != null){
            intent.putExtra("USER_ID", user.getInt(0));
        }
        startActivity(intent);
    }
}
