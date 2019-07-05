package com.modicare;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ToggleButton;

// import com.example.mac.androidtest.R;

public class HomeActivity  extends AppCompatActivity {
    ImageView menuimg, profile_imag;
    NavigationView navigationView;
    Context context;
    ImageView cart, notofication;
    boolean doubleBackToExitPressedOnce = false;
    ToggleButton toggleBtn_available;
    private DrawerLayout drawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        menuimg = (ImageView) findViewById(R.id.menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
    }
}



