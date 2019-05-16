package com.example.laundrysepatu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button btnlogin, btnlist, btnadd, btntracking, btninfo;
    ViewFlipper v_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlist = (Button) findViewById(R.id.btnlist);
        btnadd = (Button) findViewById(R.id.btnadd);
        btntracking = (Button) findViewById(R.id.btntracking);
        btninfo = (Button) findViewById(R.id.btninfo);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Klik Tambah", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( MainActivity.this, Tambah.class);
                startActivity(intent);
            }
        });
        btntracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, TrackingList.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Klik Tracking", Toast.LENGTH_SHORT).show();
            }
        });
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Klik Info", Toast.LENGTH_SHORT).show();
            }
        });
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, ListJasa.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Klik List Jasa", Toast.LENGTH_SHORT).show();
            }
        });

    //SLIDE IMAGES
        int images[] = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3};
        v_flipper = findViewById(R.id.v_flipper);

        for (int i =0; i<images.length; i++){
            fliverImages(images[i]);
        }
        for (int image: images)
            fliverImages(image);

    }
    public  void  fliverImages(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);


    }

    public void onclick(View view) {
    }
}
