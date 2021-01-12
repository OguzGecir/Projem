package com.h5190076_oguzcan_gecir_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.h5190076_oguzcan_gecir_final.R;

public class UyeViewHolder extends RecyclerView.ViewHolder {

    ImageView imgUyeResim;
    TextView txtUyeAdi;
    TextView txtDogumTarih;
    TextView txtPozisyon;
    TextView txtBoyu;

    public UyeViewHolder(@NonNull View cardView, UyeAdaptor.OnItemClickListener listener) {
        super(cardView);


        txtUyeAdi =itemView.findViewById(R.id.txtUyeAdi);
        txtPozisyon = itemView.findViewById(R.id.txtPozisyon);
        imgUyeResim =itemView.findViewById(R.id.imgBurcLogo);
        txtDogumTarih =itemView.findViewById(R.id.txtDogumTarih);
        txtBoyu=itemView.findViewById(R.id.txtBoy);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(getAdapterPosition());
            }
        });

        };




    }

