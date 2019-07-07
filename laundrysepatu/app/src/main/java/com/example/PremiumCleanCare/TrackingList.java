package com.example.PremiumCleanCare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TrackingList extends AppCompatActivity {

    private RecyclerView recycler_view;
    private TrackingAdapter adapter;
    private CardView cvtracking;
    private ArrayList<Tracking> trackingArrayList;
    Button btndttracking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_list);

        addData();

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        cvtracking = (CardView) findViewById(R.id.cv_tracking);
        btndttracking = (Button) findViewById(R.id.btndetailtracking);

        recycler_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( TrackingList.this, TrackingDetail.class);
                startActivity(intent);
            }
        });

        btndttracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( TrackingList.this, TrackingDetail.class);
                startActivity(intent);
            }
        });

        //menggunakan LinearLayoutManager untuk list
        //yang berisi daftar item yang disusun kebawah
        adapter = new TrackingAdapter(trackingArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TrackingList.this);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adapter);


    }
    //Item data yang akan ditamilkan di RecyclerView
    void addData() {
        trackingArrayList = new ArrayList<>();
        trackingArrayList.add(new Tracking("TN001", "2019-05-28", "Rp 80000"));
        trackingArrayList.add(new Tracking("TN002", "2019-05-28", "Rp 20000"));
        trackingArrayList.add(new Tracking("TN003", "2019-05-28", "Rp 5000"));
    }
}
