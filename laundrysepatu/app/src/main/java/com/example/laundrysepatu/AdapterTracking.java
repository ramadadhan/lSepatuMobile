package com.example.laundrysepatu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class AdapterTracking extends RecyclerView.Adapter<TrackingList> {
    Context context;
    List<String> versionModels;

    //Array tambahan untuk picture
    public static List<String> foto = new ArrayList<String>();

    //Text
    public static List<String> transaksi = new ArrayList<String>();
    public static List<String> keterangan = new ArrayList<String>();

    //Set List Items
    public void setCardList(Context context) {

        //Ambil nama picture dari array list_icon
        String[] fotoarray = context.getResources().getStringArray(R.array.list_itempict);

        //text
        String[] transaksiarray = context.getResources().getStringArray(R.array.list_kodetransaksi);
        String[] keteranganarray = context.getResources().getStringArray(R.array.list_keterangan);
        for (int i = 0; i < transaksiarray.length; ++i) {
            foto.add(fotoarray[i]);
            transaksi.add(transaksiarray[i]);
            keterangan.add(keteranganarray[i]);
        }
    }

    public AdapterTracking(Context context) {
        this.context = context;
        setCardList(context);
    }

    public AdapterTracking(List<String> versionModels) {
        this.versionModels = versionModels;

    }

    @Override
    public TrackingList onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list_tracking, viewGroup, false);
        TrackingList viewHolder = new TrackingList(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TrackingList versionViewHolder, int i) {

        //Cari Picture di drawable sesuai nama dari array
        //lalu menyusunnya sesuai urutan dari atas ke bawah
        int listIcon = context.getResources().getIdentifier(String.valueOf(foto.get(i)),
                "drawable", context.getPackageName());
        versionViewHolder.picture.setImageResource(listIcon);

        versionViewHolder.transaction.setText(transaksi.get(i));
        versionViewHolder.description.setText(keterangan.get(i));
    }

    @Override
    public int getItemCount() {

        return transaksi == null ? 0 : transaksi.size();
    }

}
