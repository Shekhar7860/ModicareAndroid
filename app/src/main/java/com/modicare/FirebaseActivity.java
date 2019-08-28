package com.modicare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

 // import com.example.mac.androidtest.R;
import com.modicare.Listdata;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseActivity extends AppCompatActivity {

    TextView ename,eemail,eaddress;
    Button save,view;
    ImageView back_arrow;
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<Listdata> list;
    RecyclerView recyclerview;
    private ProgressBar spinner;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.VISIBLE);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9784974231819956/9178059869");
        AdRequest request = new AdRequest.Builder().build();
        interstitialAd.loadAd(request);
        interstitialAd.setAdListener(new AdListener(){
            public void onAdLoaded(){
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                }
            }
        });

       recyclerview = (RecyclerView) findViewById(R.id.rview);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("shopping-list");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                // StringBuffer stringbuffer = new StringBuffer();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    Userdetails userdetails = dataSnapshot1.getValue(Userdetails.class);
                    Listdata listdata = new Listdata();
                    String name=userdetails.getName();
                    String email=userdetails.getEmail();
                    String address=userdetails.getAddress();
                    String image=userdetails.getImage();
                     Log.w("activity", image);
                    spinner.setVisibility(View.GONE);
                    listdata.setName(name);
                    listdata.setEmail(email);
                    listdata.setAddress(address);
                    listdata.setImage(image);
                    list.add(listdata);
                    // Toast.makeText(MainActivity.this,""+name,Toast.LENGTH_LONG).show();

                }

                RecyclerviewAdapter recycler = new RecyclerviewAdapter(FirebaseActivity.this, list);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(FirebaseActivity.this);
                recyclerview.setLayoutManager(layoutmanager);
                recyclerview.setItemAnimator( new DefaultItemAnimator());
                recyclerview.setAdapter(recycler);
                back_arrow = (ImageView) findViewById(R.id.back_arrow);
                back_arrow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(FirebaseActivity.this, MainActivity.class));
                        finish();
                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //  Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name =  ename.getText().toString();
//                String email =  eemail.getText().toString();
//                String address =  eaddress.getText().toString();
//
//
//                String key =myRef.push().getKey();
//                Userdetails userdetails = new Userdetails();
//
//                userdetails.setName(name);
//                userdetails.setEmail(email);
//                userdetails.setAddress(address);
//
//                myRef.child(key).setValue(userdetails);
//                ename.setText("");
//                eemail.setText("");
//                eaddress.setText("");
//
//            }
//        });


//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                myRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        list = new ArrayList<>();
//                        // StringBuffer stringbuffer = new StringBuffer();
//                        for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
//
//                            Userdetails userdetails = dataSnapshot1.getValue(Userdetails.class);
//                            Listdata listdata = new Listdata();
//                            String name=userdetails.getName();
//                            String email=userdetails.getEmail();
//                            String address=userdetails.getAddress();
//                            listdata.setName(name);
//                            listdata.setEmail(email);
//                            listdata.setAddress(address);
//                            list.add(listdata);
//                            // Toast.makeText(MainActivity.this,""+name,Toast.LENGTH_LONG).show();
//
//                        }
//
//                        RecyclerviewAdapter recycler = new RecyclerviewAdapter(list);
//                        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(FirebaseActivity.this);
//                        recyclerview.setLayoutManager(layoutmanager);
//                        recyclerview.setItemAnimator( new DefaultItemAnimator());
//                        recyclerview.setAdapter(recycler);
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        // Failed to read value
//                        //  Log.w(TAG, "Failed to read value.", error.toException());
//                    }
//                });
//
//            }
     //   });


    }
}

