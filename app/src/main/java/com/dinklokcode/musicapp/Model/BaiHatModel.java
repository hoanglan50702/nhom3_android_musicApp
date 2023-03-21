package com.dinklokcode.musicapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaiHatModel implements Parcelable {
    @SerializedName("idBaiHat")
    @Expose
    private int idBaiHat;
    @SerializedName("TenBaiHat")
    @Expose
    private String TenBaiHat;
    @SerializedName("HinhBaiHat")
    @Expose
    private String HinhBaiHat;
    @SerializedName("CaSi")
    @Expose
    private String CaSi;
    @SerializedName("LinkBaiHat")
    @Expose
    private String LinkBaiHat;

    public BaiHatModel(int idBaiHat, String TenBaiHat, String HinhBaiHat, String CaSi, String LinkBaiHat) {
        this.idBaiHat = idBaiHat;
        this.TenBaiHat = TenBaiHat;
        this.HinhBaiHat = HinhBaiHat;
        this.CaSi = CaSi;
        this.LinkBaiHat = LinkBaiHat;
    }


    protected BaiHatModel(Parcel in) {
        idBaiHat = in.readInt();
        TenBaiHat = in.readString();
        HinhBaiHat = in.readString();
        CaSi = in.readString();
        LinkBaiHat = in.readString();
    }

    public static final Creator<BaiHatModel> CREATOR = new Creator<BaiHatModel>() {
        @Override
        public BaiHatModel createFromParcel(Parcel in) {
            return new BaiHatModel(in);
        }

        @Override
        public BaiHatModel[] newArray(int size) {
            return new BaiHatModel[size];
        }
    };

    public int getIdBaiHat() {
        return idBaiHat;
    }

    public void setIdBaiHat(int idBaiHat) {
        this.idBaiHat = idBaiHat;
    }

    public String getTenBaiHat() {
        return TenBaiHat;
    }

    public void setTenBaiHat(String TenBaiHat) {
        this.TenBaiHat = TenBaiHat;
    }

    public String getHinhBaiHat() {
        return HinhBaiHat;
    }

    public void setHinhBaiHat(String hinhBaiHat) {
        this.HinhBaiHat = hinhBaiHat;
    }

    public String getTenCaSi() {
        return CaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        this.CaSi = tenCaSi;
    }

    public String getLinkBaiHat() {
        return LinkBaiHat;
    }

    public void setLinkBaiHat(String linkBaiHat) {
        this.LinkBaiHat = linkBaiHat;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idBaiHat);
        parcel.writeString(TenBaiHat);
        parcel.writeString(HinhBaiHat);
        parcel.writeString(CaSi);
        parcel.writeString(LinkBaiHat);
    }

}