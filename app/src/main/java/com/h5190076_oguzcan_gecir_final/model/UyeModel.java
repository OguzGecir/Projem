package com.h5190076_oguzcan_gecir_final.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UyeModel {


    @SerializedName("AdiSoyadi")
    @Expose
    private String adiSoyadi;
    @SerializedName("Pozisyonu")
    @Expose
    private String pozisyonu;
    @SerializedName("ResimURL")
    @Expose
    private String resimURL;
    @SerializedName("DogumTarihi")
    @Expose
    private String dogumTarihi;
    @SerializedName("Boyu")
    @Expose
    private String boyu;
    @SerializedName("Biyografi")
    @Expose
    private String biyografi;

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getPozisyonu() {
        return pozisyonu;
    }

    public void setPozisyonu(String pozisyonu) {
        this.pozisyonu = pozisyonu;
    }

    public String getResimURL() {
        return resimURL;
    }

    public void setResimURL(String resimURL) {
        this.resimURL = resimURL;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getBoyu() {
        return boyu;
    }

    public void setBoyu(String boyu) {
        this.boyu = boyu;
    }

    public String getBiyografi() {
        return biyografi;
    }

    public void setBiyografi(String biyografi) {
        this.biyografi = biyografi;
    }

}