package com.modicare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

// import com.example.mac.androidtest.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import java.util.ArrayList;


public class IdeasListActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mDatabase;
    EditText forgot_pass_email;
    ImageView back_arrow;
    Button btn_reset_password, openweb;
    Context context;
    TextView heading, content;
    ImageView image;
    JSONArray itemSelectedJson = new JSONArray();
    public final String android_version_names[] = {
            "Business Idea 1",
            "Business Idea 2",
            "Business Idea 3",
            "Business Idea 4",
            "Business Idea 5",
            "Business Idea 6",
            "Business Idea 7",
            "Business Idea 8",
            "Business Idea 9",
            "Business Idea 10"
    };

    private final Integer android_image_urls[] = {
            R.drawable.business1, R.drawable.business2, R.drawable.business3, R.drawable.business4,
            R.drawable.business5, R.drawable.business6, R.drawable.business7, R.drawable.business8,
            R.drawable.business9, R.drawable.business10

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        context = IdeasListActivity.this;
       FirebaseApp.initializeApp(this);
        Intent intent = this.getIntent();
        if (intent != null) {
            String gameId = intent.getStringExtra("value");
            String name = intent.getStringExtra("name");
            String imageUrl = intent.getStringExtra("image");
           Log.w("image", imageUrl);
          //  Log.w("name", name);
            image =   (ImageView) findViewById(R.id.image);
            heading  = (TextView) findViewById(R.id.heading);
            content  = (TextView) findViewById(R.id.content);
            Picasso.with(IdeasListActivity.this).load(imageUrl).resize(500, 500).into(image);
            heading.setText(name);
            content.setText(gameId);
        }
        openweb = findViewById(R.id.openweb);
        openweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IdeasListActivity.this, WebBrowserActivity.class));
                finish();
            }
        });

        back_arrow = (ImageView) findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        initViews();
        // setOnclickListener();
    }

    private void initViews(){



    }
    private ArrayList<AndroidVersion> prepareData(){

        ArrayList<AndroidVersion> android_version = new ArrayList<>();

        for(int i=0;i<android_version_names.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }


    private void setOnclickListener() {
        btn_reset_password.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

//        if (!validateEmail()) {
//            return;
//        } else {
//
//            if (connectionDetector.isConnectingToInternet()) {
//                Forgotpassword();
//            } else {
//                Toast.makeText(context, "No internet", Toast.LENGTH_SHORT).show();
//            }
//
//
//        }

    }



    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }



}