package com.example.laundrysepatu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class TrackingList extends AppCompatActivity {

    //Data-Data yang Akan dimasukan Pada ListView
    private String[] transaksi = {"1. Tracking a", "2. Tracking b", "3. Tracking c"};

    //ArrayList digunakan Untuk menampung Data tracking
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_list);
        ListView listView = findViewById(R.id.trackinglist);
        data = new ArrayList<>();
        getData();
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, data);
        listView.setAdapter(adapter);
    }

    private void getData(){
        //Memasukan Semua Data tracking kedalam ArrayList
        Collections.addAll(data, transaksi);
    }
}
