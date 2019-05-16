package com.example.laundrysepatu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button btnkeluarlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnkeluarlogin = (Button) findViewById(R.id.btnkeluarlogin);

        btnkeluarlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this,"Keluar", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( Login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
