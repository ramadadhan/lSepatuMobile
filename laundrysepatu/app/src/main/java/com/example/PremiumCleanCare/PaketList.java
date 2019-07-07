package com.example.PremiumCleanCare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class PaketList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PaketAdapter adapter;
    private ArrayList<Paket> paketArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paket_list);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new PaketAdapter(paketArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PaketList.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }

    void addData() {
        paketArrayList = new ArrayList<>();
        paketArrayList.add(new Paket("Deep Clean (Membersihkan Menyeluruh)",
                "Membersihkan sepatu1 pada seluruh bagian (Outer Sole, Mid Sole, & Upper)", "20k"));
        paketArrayList.add(new Paket("Unyellowing (Menghiangkan Kuning)", "Menghilangkan kerak kuning pada bagian Mid Sole", "25k"));
        paketArrayList.add(new Paket("Recolour (Mewarnai Ulang)", "Mewarnai bagian Upper yang memudar atau ingin di warnai ulang", "80k"));
    }

}
