package com.example.PremiumCleanCare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button  btnlist, btnadd, btntracking, btninfo;
    ViewFlipper v_flipper;

    //Menampilkan menu yang telah dibuat
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //Menangani kejadian ketika menu di click
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){ //Switch untuk menentukan kejadian masing2 id ketika di click
            case R.id.profile:
                Intent intent = new Intent( MainActivity.this, Profile.class);
                startActivity(intent);
                return true;
            default:
                return true;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlist = (Button) findViewById(R.id.btnlist);
        btnadd = (Button) findViewById(R.id.btnadd);
        btntracking = (Button) findViewById(R.id.btntracking);
        btninfo = (Button) findViewById(R.id.btninfo);
        v_flipper = (ViewFlipper) findViewById(R.id.v_flipper);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, Tambah.class);
                startActivity(intent);
            }
        });
        btntracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, TrackingList.class);
                startActivity(intent);
            }
        });
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent( MainActivity.this, Info.class);
                 startActivity(intent);

            }
        });
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, PaketList.class);
                startActivity(intent);
            }
        });

        //RUNNING TEXT
        TextView marque = (TextView) this.findViewById(R.id.sliding_text_marquee);
        marque.setSelected(true);

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
