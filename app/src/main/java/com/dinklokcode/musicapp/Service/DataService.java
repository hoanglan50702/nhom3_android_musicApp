package com.dinklokcode.musicapp.Service;

import com.dinklokcode.musicapp.Model.ChuDeModel;
import com.dinklokcode.musicapp.Model.PlaylistModel;
import com.dinklokcode.musicapp.Model.Quangcao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();
    @GET("tatcachude.php")
    Call<List<ChuDeModel>> GetChuDeCurrent();
    @GET("danhsachcacplaylist.php")
    Call<List<PlaylistModel>> GetPlayList();
}
