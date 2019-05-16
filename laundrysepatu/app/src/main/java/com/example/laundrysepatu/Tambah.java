package com.example.laundrysepatu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Tambah extends AppCompatActivity {
    ImageButton shareloc;
    Button btnkeluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        shareloc = (ImageButton) findViewById(R.id.shareloc);
        btnkeluar = (Button) findViewById(R.id.btnkeluar);

        shareloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tambah.this,"Share Location", Toast.LENGTH_SHORT).show();
            }
        });
        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tambah.this,"Keluar", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( Tambah.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
