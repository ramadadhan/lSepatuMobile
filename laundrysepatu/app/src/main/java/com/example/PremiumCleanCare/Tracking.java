package com.example.PremiumCleanCare;

public class Tracking {

    private String nonota;
    private String tanggal;
    private String ttlbayar;

    public Tracking(String nonota, String tanggal, String ttlbayar) {
        this.nonota = nonota;
        this.tanggal = tanggal;
        this.ttlbayar = ttlbayar;

    }

    public String getNonota() {
        return nonota;
    }
    public void setNonota(String nonota) {
        this.nonota = nonota;
    }

    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTtlbayar() {
        return ttlbayar;
    }
    public void setTtlbayar(String ttlbayar) {
        this.ttlbayar = ttlbayar;
    }

}
