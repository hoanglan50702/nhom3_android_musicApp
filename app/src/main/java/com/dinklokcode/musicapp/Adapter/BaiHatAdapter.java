package com.dinklokcode.musicapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dinklokcode.musicapp.Model.BaiHatModel;
import com.dinklokcode.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BaiHatAdapter extends RecyclerView.Adapter<BaiHatAdapter.ViewHolder>{
    Context context;
    ArrayList<BaiHatModel> baiHatArraylist;

    public BaiHatAdapter(Context context, ArrayList<BaiHatModel> baiHatArraylist) {
        this.context = context;
        this.baiHatArraylist = baiHatArraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_baihat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHatModel baihat = baiHatArraylist.get(position);
        holder.txtTenCasi.setText(baihat.getTenCaSi());
        holder.txtTenBaihat.setText(baihat.getTenBaiHat());
        Picasso.with(context).load(baihat.getHinhBaiHat()).into(holder.imgBaihat);
    }

    @Override
    public int getItemCount() {
        return baiHatArraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTenBaihat,txtTenCasi;
        ImageView imgBaihat,imgThich;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenBaihat = itemView.findViewById(R.id.txtTenBaihat);
            txtTenCasi = itemView.findViewById(R.id.txtCasiBaihai);
            imgBaihat = itemView.findViewById(R.id.imgBaihat);
            imgThich = itemView.findViewById(R.id.imgthich);
        }
    }
}
