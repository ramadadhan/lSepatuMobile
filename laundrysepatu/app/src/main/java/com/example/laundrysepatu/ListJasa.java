package com.example.laundrysepatu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class ListJasa extends AppCompatActivity {

    //Data-Data yang Akan dimasukan Pada ListView
    private String[] paket = {"1. Deep Clean (20k)", "2. Unyellowing (25k)", "3. Recolour (80k)"};

    //ArrayList digunakan Untuk menampung Data paket
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jasa);
        ListView listView = findViewById(R.id.listjasa);
        data = new ArrayList<>();
        getData();
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, data);
        listView.setAdapter(adapter);
    }

    private void getData(){
        //Memasukan Semua Data paket kedalam ArrayList
        Collections.addAll(data, paket);
    }
}
