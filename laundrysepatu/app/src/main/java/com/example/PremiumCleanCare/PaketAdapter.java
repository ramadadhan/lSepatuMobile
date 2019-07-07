package com.example.PremiumCleanCare;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PaketAdapter extends RecyclerView.Adapter<PaketAdapter.PaketViewHolder> {
    private ArrayList<Paket> dataList;

    public PaketAdapter(ArrayList<Paket> dataList) {
        this.dataList = dataList;
    }

    @Override
    public PaketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cardview_paket, parent, false);
        return new PaketViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PaketViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtKeterangan.setText(dataList.get(position).getKeterangan());
        holder.txtHarga.setText(dataList.get(position).getHarga());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class PaketViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtKeterangan, txtHarga;

        public PaketViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_paket);
            txtKeterangan = (TextView) itemView.findViewById(R.id.txt_keterangan);
            txtHarga = (TextView) itemView.findViewById(R.id.txt_harga);
        }
    }
}
