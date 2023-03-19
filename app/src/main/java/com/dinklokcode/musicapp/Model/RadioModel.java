package com.dinklokcode.musicapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RadioModel implements Serializable {
    @SerializedName("idRadio")
    @Expose
    private String idRadio;
    @SerializedName("HinhAnhRadio")
    @Expose
    private String hinhAnhRadio;
    @SerializedName("NoiDungRadio")
    @Expose
    private String noiDungRadio;

    public String getIdRadio() {
        return idRadio;
    }

    public void setIdRadio(String idRadio) {
        this.idRadio = idRadio;
    }

    public String getHinhAnhRadio() {
        return hinhAnhRadio;
    }

    public void setHinhAnhRadio(String hinhAnhRadio) {
        this.hinhAnhRadio = hinhAnhRadio;
    }

    public String getNoiDungRadio() {
        return noiDungRadio;
    }

    public void setNoiDungRadio(String noiDungRadio) {
        this.noiDungRadio = noiDungRadio;
    }
}
