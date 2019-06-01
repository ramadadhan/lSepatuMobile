package com.example.laundrysepatu;



import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TrackingList extends RecyclerView.ViewHolder implements View.OnClickListener {

    //Variable
    CardView cardItemLayout;
    ImageView picture; // Picture
    TextView transaction;
    TextView description;

    public TrackingList(View itemView) {
        super(itemView);

        //Set id
        cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_tracking);

        //Tambahan untuk id Picture
        picture = (ImageView)itemView.findViewById(R.id.foto);

        //id Text
        transaction = (TextView) itemView.findViewById(R.id.listitem_transaksi);
        description = (TextView) itemView.findViewById(R.id.listitem_keterangan);

        //onClick
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //tampilkan toas ketika click
        Toast.makeText(v.getContext(),
                String.format("Position %d", getAdapterPosition()),
                Toast.LENGTH_SHORT).show();
    }
}


