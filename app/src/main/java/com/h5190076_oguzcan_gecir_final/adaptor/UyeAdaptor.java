package com.h5190076_oguzcan_gecir_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190076_oguzcan_gecir_final.model.UyeModel;
import com.h5190076_oguzcan_gecir_final.R;
import com.h5190076_oguzcan_gecir_final.util.GlideUtil;


import java.util.List;

public class UyeAdaptor extends RecyclerView.Adapter<UyeViewHolder> {


    List<UyeModel> uyeler;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(int position);
    }


    public UyeAdaptor(List<UyeModel> uyeler, Context context,OnItemClickListener listener) {
        this.uyeler = uyeler;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public UyeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_uyeler,parent,false);
        return new UyeViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UyeViewHolder viewHolder, int position) {

        viewHolder.txtDogumTarih.setText(uyeler.get(position).getDogumTarihi());
        viewHolder.txtUyeAdi.setText(uyeler.get(position).getAdiSoyadi());
        viewHolder.txtBoyu.setText(uyeler.get(position).getBoyu());
        viewHolder.txtPozisyon.setText(uyeler.get(position).getPozisyonu());
        GlideUtil.resmiIndiripGoster(context,uyeler.get(position).getResimURL(),viewHolder.imgUyeResim);


    }

    @Override
    public int getItemCount() {
        return uyeler.size();
    }
}
