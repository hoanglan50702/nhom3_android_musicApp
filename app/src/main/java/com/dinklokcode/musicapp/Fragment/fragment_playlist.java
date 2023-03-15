package com.dinklokcode.musicapp.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dinklokcode.musicapp.Adapter.ChuDeAdapter;
import com.dinklokcode.musicapp.Adapter.PlaylistAdapter;
import com.dinklokcode.musicapp.Model.ChuDeModel;
import com.dinklokcode.musicapp.Model.PlaylistModel;
import com.dinklokcode.musicapp.R;
import com.dinklokcode.musicapp.Service.APIService;
import com.dinklokcode.musicapp.Service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragment_playlist extends Fragment {

    View view;
    PlaylistAdapter PlaylistAdapter;
    RecyclerView recyclerViewPlaylist;
    TextView tenChuDe;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist, container, false);
        recyclerViewPlaylist = view.findViewById(R.id.recyclerviewplaylist);
        tenChuDe = view.findViewById(R.id.txtchude);
        GetData();
        return view;
    }

    private void GetData() {
        DataService dataservice = APIService.getService();
        Call<List<PlaylistModel>> callback = dataservice.GetPlayList();
        callback.enqueue(new Callback<List<PlaylistModel>>() {
            @Override
            public void onResponse(Call<List<PlaylistModel>> call, Response<List<PlaylistModel>> response) {
                ArrayList<PlaylistModel> mangplaylist = (ArrayList<PlaylistModel>) response.body();
                PlaylistAdapter = new PlaylistAdapter(getActivity(), mangplaylist);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewPlaylist.setLayoutManager(linearLayoutManager);
                recyclerViewPlaylist.setAdapter(PlaylistAdapter);
            }

            @Override
            public void onFailure(Call<List<PlaylistModel>> call, Throwable t) {

            }
        });
    }

}