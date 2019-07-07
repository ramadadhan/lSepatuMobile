package com.example.PremiumCleanCare;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TrackingAdapter extends RecyclerView.Adapter<TrackingAdapter.TrackingViewHolder>{
    private ArrayList<Tracking> dataList;//digunakan untuk text
    private ArrayList<Integer> sepatuList; //Digunakan untuk Image/Gambar

    public class TrackingViewHolder extends RecyclerView.ViewHolder{
        private TextView txtnonota, txttanggal, txtttlbayar;
        private CardView cv_tracking;
        private ImageView imgsepatu;

        public TrackingViewHolder(View itemView) {
            super(itemView);
            txtnonota = (TextView) itemView.findViewById(R.id.txt_no_nota);
            txttanggal = (TextView) itemView.findViewById(R.id.txt_tanggal);
            txtttlbayar = (TextView) itemView.findViewById(R.id.txt_ttlbayar);
            cv_tracking = (CardView) itemView.findViewById(R.id.cv_tracking);
            imgsepatu = (ImageView) itemView.findViewById(R.id.imgsepatu);
        }
    }

    public TrackingAdapter(ArrayList<Tracking> dataList) {
        this.dataList = dataList;

    }

    @Override
    public void onBindViewHolder(TrackingViewHolder holder, int position) {
        //mengambil dan mengeset data dati addData(ArrayList)=>TrackingList
        holder.txtnonota.setText(dataList.get(position).getNonota());
        holder.txttanggal.setText(dataList.get(position).getTanggal());
        holder.txtttlbayar.setText(dataList.get(position).getTtlbayar());
    }

    @Override
    public TrackingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //membuat view baru
        View view = layoutInflater.inflate(R.layout.cardview_tracking, parent, false);
        //mengeset view dari berbagai parameter layout lainnya
        return new TrackingViewHolder(view);
    }
    @Override
    public int getItemCount() {
        //menghitung ukuran addData / jumlah data yang ditampilkan di RecyclerView
        return dataList.size();
    }
}
