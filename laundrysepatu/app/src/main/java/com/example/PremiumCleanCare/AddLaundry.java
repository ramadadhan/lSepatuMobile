package com.example.PremiumCleanCare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddLaundry {
    @Expose
    @SerializedName("id") private int id;
    @Expose
    @SerializedName("nama") private String nama;
    @Expose
    @SerializedName("alamat") private String alamat;
    @Expose
    @SerializedName("mereksepatu") private String mereksepatu;
    @Expose
    @SerializedName("keterangan") private String keterangan;
    @Expose
    @SerializedName("img") private int img;
    @Expose
    @SerializedName("color") private int color;
    @Expose
    @SerializedName("waktu/tanggal") private String waktu_tanggal;
    @Expose
    @SerializedName("success") private boolean success;
    @Expose
    @SerializedName("message") private String message;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMereksepatu() {
        return mereksepatu;
    }

    public void setMereksepatu(String mereksepatu) {
        this.mereksepatu = mereksepatu;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

//    public int getImg() {
//        return img;
//    }
//
//    public void setImg(int img) {
//        this.img = img;
//    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getWaktu_tanggal() {
        return waktu_tanggal;
    }

    public void setWaktu_tanggal(String waktu_tanggal) {
        this.waktu_tanggal = waktu_tanggal;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
