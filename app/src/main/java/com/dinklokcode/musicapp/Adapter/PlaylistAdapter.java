package com.dinklokcode.musicapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dinklokcode.musicapp.Model.PlaylistModel;
import com.dinklokcode.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder>{

    Context context;
    ArrayList<PlaylistModel> mangplaylist;
    View view;

    public PlaylistAdapter(Context context, ArrayList<PlaylistModel> mangplaylist) {
        this.context = context;
        this.mangplaylist = mangplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.dong_playlist,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        PlaylistModel playlist = mangplaylist.get(position);
        holder.txttenplaylist.setText(playlist.getTen());
        Picasso.with(context).load(playlist.getHinhPlaylist()).into(holder.imgplaylist);
    }

    @Override
    public int getItemCount() {
        return mangplaylist != null ? mangplaylist.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgplaylist;
        TextView txttenplaylist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgplaylist = itemView.findViewById(R.id.imageviewplaylist);
            txttenplaylist = itemView.findViewById(R.id.textviewplaylist);
        }
    }
}
