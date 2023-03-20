package com.dinklokcode.musicapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dinklokcode.musicapp.Model.BaiHat;
import com.dinklokcode.musicapp.Model.BaiHatModel;
import com.dinklokcode.musicapp.R;
import com.dinklokcode.musicapp.Service.APIService;
import com.dinklokcode.musicapp.Service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaiHatAdapter extends RecyclerView.Adapter<BaiHatAdapter.ViewHolder>{
    Context context;
    ArrayList<BaiHat> baiHatArraylist;

    public BaiHatAdapter(Context context, ArrayList<BaiHat> baiHatArraylist) {
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
        BaiHat baihat = baiHatArraylist.get(position);
        holder.txtTenCasi.setText(baihat.getCaSi());
        holder.txtTenBaihat.setText(baihat.getTenBaiHat());
        Picasso.with(context).load(baihat.getHinhBaiHat()).into(holder.imgBaihat);
        holder.imgThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgThich.setImageResource(R.drawable.love);
                DataService db = APIService.getService();
                Call<List<BaiHat>> callback = db.GetDSBaiHatYTCaNhan("username123");
                callback.enqueue(new Callback<List<BaiHat>>() {
                    @Override
                    public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {

                    }

                    @Override
                    public void onFailure(Call<List<BaiHat>> call, Throwable t) {

                    }
                });
            }
        });
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
