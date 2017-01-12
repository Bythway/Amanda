package com.example.yeisongomez.amanda.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yeisongomez.amanda.Fragments.DiaryFragment;
import com.example.yeisongomez.amanda.Fragments.ActivitysFragment;
import com.example.yeisongomez.amanda.Objects.User;
import com.example.yeisongomez.amanda.Fragments.PensumFragment;
import com.example.yeisongomez.amanda.R;
import com.example.yeisongomez.amanda.SQLite.UserDB;
import com.example.yeisongomez.amanda.Fragments.ScoreFragment;
import com.example.yeisongomez.amanda.Fragments.SettingsFragment;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addIconMenuToolbar();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_activity);
        this.navigationFragment(new ActivitysFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            CharSequence title = ((Toolbar) findViewById(R.id.toolbar)).getTitle();
            if (title == getString(R.string.add_activity)){
                addIconMenuToolbar();
            }
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getUser();
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;
        if (id == R.id.nav_activity) {
            fragment = new ActivitysFragment();
        } else if (id == R.id.nav_diary) {
            fragment = new DiaryFragment();
        } else if (id == R.id.nav_pensum) {
            fragment = new PensumFragment();
        } else if (id == R.id.nav_current_score) {
            fragment = new ScoreFragment();
        } else if (id == R.id.nav_settings) {
            fragment = new SettingsFragment();
        }

        this.navigationFragment(fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getUser(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            UserDB userDB = new UserDB(this);
            userDB.open();
            user = userDB.getUserById(extras.getInt("USER_ID"));
            userDB.close();
        }
        this.editNavHeader(user.getFOTO(), user.getNombreApellido(), user.getROL());
    }

    private void editNavHeader(String avatar, String names, String rol){
        Picasso.with(this).load(avatar)
                .placeholder(R.drawable.ic_account_circle_black_80dp)
                .error(R.drawable.ic_account_circle_black_80dp)
                .centerCrop()
                .resize(130, 130)
                .into((ImageView) findViewById(R.id.user_avatar));
        ((TextView) findViewById(R.id.user_names)).setText(names);
        ((TextView) findViewById(R.id.user_rol)).setText(rol);
    }

    private void navigationFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contentFrame, fragment);
        fragmentTransaction.commit();
    }

    private void addIconMenuToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }
}
