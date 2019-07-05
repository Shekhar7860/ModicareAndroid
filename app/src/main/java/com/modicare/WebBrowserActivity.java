package com.modicare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

// import com.example.mac.androidtest.R;

public class WebBrowserActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.funblog.in/"));
        startActivity(browserIntent);
    }
}
