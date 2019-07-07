package com.example.PremiumCleanCare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    EditText edttxtusername, edttxtpassword;
    Button btnkeluar, btnmasuk;
    TextView daftar;
    String username, password, id;
    ImageView imglogo;

    public static  String URL ="http://192.168.43.177/premiumcleancare/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnkeluar = (Button) findViewById(R.id.btnkeluar);
        btnmasuk = (Button) findViewById(R.id.btnmasuk);
        edttxtusername = (EditText) findViewById(R.id.edttxtusername);
        edttxtpassword = (EditText) findViewById(R.id.edttxtpassword);
        daftar = (TextView) findViewById(R.id.daftar);
        imglogo = (ImageView) findViewById(R.id.imglogo);

        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this,"Keluar", Toast.LENGTH_SHORT).show();
            }
        });

        btnmasuk.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                username = edttxtusername.getText().toString().trim();
                password = edttxtpassword.getText().toString().trim();

                if (username.isEmpty()){
                    edttxtusername.setError("Username harus diisi!");
                }else if(password.isEmpty()){
                    edttxtpassword.setError("Password harus diisi!");
                }else {
                    auth_user(username, password);
                }
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Login.this, Registrasi.class);
                startActivity(intent);
            }
        });
        imglogo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    //PROSES LOGIN
    private void auth_user(final String id, final String password){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");
                            if(success.equals("1")){
                                for(int i=0 ; i<jsonArray.length() ; i++){
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                                    String id = jsonObject1.getString("id").trim();
                                    Toast.makeText(Login.this,
                                            "Login berhasil ! \n id : "+id,
                                            Toast.LENGTH_SHORT)
                                            .show();
                                }
                            }else{
                                Toast.makeText(Login.this,
                                        "Username dan Password tidak ditemukan! ",
                                        Toast.LENGTH_SHORT)
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Login.this,
                                    "Error login : " + e.toString(),
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this,
                                "Error login : " + error.toString(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);     // sesuaikan dengan $_POST pada PHP
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

//    private void prosesLogin() {
//        // Setting POST request ke server
//        StringRequest loginRequest = new StringRequest(Request.Method.POST, "http://192.168.43.177/premiumcleancare/login.php",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Handle response dari server ketika sukses dengan mengkonvert menjadi JSON
//                        try {
//                            JSONObject json = new JSONObject(response);
//                            // Mengambil variable status pada response
//                            String status = json.getString("status");
//                            if(status.equals("success")){
//                                // Jika Login Sukses Maka pindah ke activity lain.
//                                Intent intent = new Intent(Login.this, MainActivity.class);
//                                startActivity(intent);
//                                finish();
//                            }else{
//                                // Jika Login Gagal Maka mengeluarkan Toast dengan message.
//                                Toast.makeText(getApplicationContext(), "Username & Password Salah", Toast.LENGTH_LONG).show();
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // Handle response dari server ketika gagal
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                }
//        ){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> params = new HashMap<>();
//                params.put("username", edttxtusername.getText().toString());
//                params.put("password", edttxtpassword.getText().toString());
//                return params;
//            }
//        };
//        // Buat antrian request pada cache android
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        // Tambahkan Request pada antrian request
//        requestQueue.add(loginRequest);
//
//    }

}
