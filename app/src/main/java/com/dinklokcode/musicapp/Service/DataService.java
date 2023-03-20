package com.dinklokcode.musicapp.Service;

import com.dinklokcode.musicapp.Model.BaiHatModel;
import com.dinklokcode.musicapp.Model.ChuDeModel;
import com.dinklokcode.musicapp.Model.NgheSiModel;
import com.dinklokcode.musicapp.Model.PlaylistModel;
import com.dinklokcode.musicapp.Model.Quangcao;
import com.dinklokcode.musicapp.Model.RadioModel;
import com.dinklokcode.musicapp.Model.ThinhHanhModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("tatcachude.php")
    Call<List<ChuDeModel>> GetChuDeCurrent();

    @GET("danhsachcacplaylist.php")
    Call<List<PlaylistModel>> GetPlayList();

    @GET("nghesicurrent.php")
    Call<List<NgheSiModel>> GetNgheSiCurrent();

    @GET("thinhhanhcurrent.php")
    Call<List<ThinhHanhModel>> GetThinhHanhCurrent();

    @GET("radiocurrent.php")
    Call<List<RadioModel>> GetRadioCurrent();

    @GET("test.php")
    Call<List<BaiHatModel>> GetAllBaihat();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHatModel>> GetDanhSachBaiHatTheoQuangCao(@Field("idQuangCao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHatModel>> GetDanhSachBaiHatTheoPlayList(@Field("idPlayList") String idPlayList);

    @FormUrlEncoded
    @POST("canhan_playlist.php")
    Call<List<PlaylistModel>> GetDSPlayListCaNhan(@Field("username") String username);

    @FormUrlEncoded
    @POST("canhan_dsbaihatyt.php")
    Call<List<BaiHatModel>> GetDSBaiHatYTCaNhan(@Field("username") String username);
}
