package com.dinklokcode.musicapp.Fragment;

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

import com.dinklokcode.musicapp.Adapter.RadioAdapter;
import com.dinklokcode.musicapp.Adapter.ThinhHanhAdapter;
import com.dinklokcode.musicapp.Model.RadioModel;
import com.dinklokcode.musicapp.Model.ThinhHanhModel;
import com.dinklokcode.musicapp.R;
import com.dinklokcode.musicapp.Service.APIService;
import com.dinklokcode.musicapp.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Radio extends Fragment {

    View view;
    RadioAdapter radioAdapter;
    RecyclerView recyclerViewradio;
    TextView tenRadio;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_radio, container, false);
        recyclerViewradio = view.findViewById(R.id.recyclerviewradio);
        tenRadio = view.findViewById(R.id.txtradio);
        GetData();
        return view;
    }

    private void GetData() {
        DataService dataservice = APIService.getService();
        Call<List<RadioModel>> callback = dataservice.GetRadioCurrent();
        callback.enqueue(new Callback<List<RadioModel>>() {
            @Override
            public void onResponse(Call<List<RadioModel>> call, Response<List<RadioModel>> response) {
                ArrayList<RadioModel> mangradio = (ArrayList<RadioModel>) response.body();
                radioAdapter = new RadioAdapter(getActivity(), mangradio);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewradio.setLayoutManager(linearLayoutManager);
                recyclerViewradio.setAdapter(radioAdapter);
            }

            @Override
            public void onFailure(Call<List<RadioModel>> call, Throwable t) {

            }

        });
    }
}