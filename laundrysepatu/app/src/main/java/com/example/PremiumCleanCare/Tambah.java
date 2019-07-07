package com.example.PremiumCleanCare;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tambah extends Activity {
    public static final int NOTIFICATION_ID = 1;
    final int kodeGallery = 100;
    EditText etnama, etalamat, etmereksepatu, etketerangan;
    ImageButton shareloc;
    Button btnbatal, btnuploadfoto, btntambah;
    ImageView img;
    Uri imageUri;
    ProgressDialog progressDialog;
    ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        shareloc = (ImageButton) findViewById(R.id.shareloc);
        btnbatal = (Button) findViewById(R.id.btnbatal);
        btntambah = (Button) findViewById(R.id.btntambah);
        btnuploadfoto = (Button) findViewById(R.id.btnuploadfoto);
        etnama = (EditText) findViewById(R.id.edittextnamalengkap);
        etalamat = (EditText) findViewById(R.id.edittextalamatlengkap);
        etmereksepatu = (EditText) findViewById(R.id.edittextmereksepatu);
        etketerangan = (EditText) findViewById(R.id.edittextketerangan);
        img = (ImageView) findViewById(R.id.imgviewupload);


        shareloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( Tambah.this, "Share Location", Toast.LENGTH_SHORT).show();
            }
        });
        btnbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tambah.this, "Batal", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Tambah.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnuploadfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentGallery, kodeGallery);
            }
        });
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etnama.getText().toString().trim();
                String alamat = etalamat.getText().toString().trim();
                String mereksepatu = etmereksepatu.getText().toString().trim();
                String keterangan = etketerangan.getText().toString().trim();
                //Int img = img.getText().toString().trim();
                int color = -2184710;

                if(nama.isEmpty()){
                    etnama.setError("Masukkan nama...");
                }else if(alamat.isEmpty()) {
                    etalamat.setError("Masukkan alamat...");
                }else if(mereksepatu.isEmpty()) {
                    etmereksepatu.setError("Masukkan merek sepatu...");
                }else if(keterangan.isEmpty()) {
                    etketerangan.setError("Masukkan keterangan sepatu...");
//                }else if(img.isEmpty(){
//                  img.setError("Masukkan foto sepatu...");
                }else {
                    tambahLaundry(nama, alamat, mereksepatu, keterangan, color);
                }
            }
        });
    }

    private void tambahLaundry(String nama, String alamat, String mereksepatu, String keterangan, int color) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Tunggu sebentar...");
        //BUAT ALERT DIALOG
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        //set judul dialog
        alertDialogBuilder.setTitle("Apakah data yang dimasukkan benar?");

        //set pesan dari dialog
        alertDialogBuilder.setIcon(R.mipmap.logo);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                progressDialog.show();

                apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                Call<AddLaundry> call = (Call<AddLaundry>) apiInterface;

                call.enqueue(new Callback<AddLaundry>() {
                    @Override
                    public void onResponse(@NonNull Call<AddLaundry> call,@NonNull Response<AddLaundry> response) {
                        progressDialog.dismiss();

                        if (response.isSuccessful() && response.body() != null){

                            boolean success = response.body().getSuccess ();
                            if (success){
                                Toast.makeText(Tambah.this, response.body().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                                finish(); //back to main activity
                            }else {
                                Toast.makeText(Tambah.this, response.body().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<AddLaundry> call, @NonNull Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(Tambah.this, t.getLocalizedMessage(),
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //jika tombol tidak di klik maka akan kembali ke activity tambah
                        dialog.cancel();
                    }
                });

        //membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        //menampilkan alert dialog
        alertDialog.show();
    }

    private void tampilNotification(String toString, String toString1, String toString2, String toString3, Intent intent) {
        //membuat komponen pending intent
        PendingIntent pendingIntent = PendingIntent.getActivity(Tambah.this, NOTIFICATION_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //membangun dan mensetup notifikation dengan NotifikationCompat.Builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(Tambah.this);
        Notification notification;
                notification = builder.setSmallIcon(R.mipmap.logo) //ikon notifikasi
                                        .setContentIntent(pendingIntent)
                                        .setContentTitle("Tambah Laundry") //judul
                                        .setAutoCancel(true) //untuk menswipe atau menghapus icon
                                        .setLargeIcon(BitmapFactory.decodeResource(Tambah.this.getResources(), R.mipmap.logo))
                                        .setContentText("Data yang anda masukkan berhasil diterima dan segera diproses")
                                        .build();



        //menambahkan notifikasi dengan menggunakan NotificationManager
        NotificationManager notificationManager = (NotificationManager) Tambah.this.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_ID, notification);
    }


    //Tampil Img dari galeri
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == kodeGallery && resultCode == RESULT_OK) {
            imageUri = data.getData();
            img.setImageURI(imageUri);
        }
    }
}

