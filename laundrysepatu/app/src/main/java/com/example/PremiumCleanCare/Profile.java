package com.example.PremiumCleanCare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Profile extends AppCompatActivity {

//    TextView txtpcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        txtpcc = (TextView) findViewById(R.id.txtpcc);
//        Typeface customfont = Typeface.createFromAsset(getAssets(), "font/Knight Brush Demo.otf");
//        txtpcc.setTypeface(customfont);
    }
    //Menampilkan menu yang telah dibuat
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_profile,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //Menangani kejadian ketika menu di click
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){ //Switch untuk menentukan kejadian masing2 id ketika di click
            case R.id.logout:
                Intent intent = new Intent( Profile.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.editprofile:
                Intent intent1 = new Intent( Profile.this, ProfileEdit.class);
                startActivity(intent1);
                break;
        }
        return true;
    }
}
