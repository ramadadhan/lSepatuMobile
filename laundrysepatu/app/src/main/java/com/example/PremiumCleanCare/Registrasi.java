package com.example.PremiumCleanCare;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class Registrasi extends AppCompatActivity {
    Button btndaftar, btnbatal;
    EditText nama, alamat, email, username,password, ulangipassword;
    CircleImageView imgprofile;
    final int kodeGallery = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        btndaftar = (Button) findViewById(R.id.btndaftar);
        btnbatal = (Button) findViewById(R.id.btnbatal);
        imgprofile = (CircleImageView) findViewById(R.id.imgprofile);
        nama = (EditText) findViewById(R.id.edittextnamalengkap);
        alamat = (EditText) findViewById(R.id.edittextalamatlengkap);
        email = (EditText) findViewById(R.id.edittextemail);
        username = (EditText) findViewById(R.id.edittextusername);
        password = (EditText) findViewById(R.id.edittextpassword);
        ulangipassword = (EditText) findViewById(R.id.edittextulangipassword);

        imgprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentGallery, kodeGallery);
            }
        });

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Registrasi.this,"Anda Telah Terdaftar", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( Registrasi.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
        btnbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Registrasi.this,"Batal", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( Registrasi.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == kodeGallery && resultCode == RESULT_OK) {
            imageUri = data.getData();
            imgprofile.setImageURI(imageUri);
        }
    }
}
