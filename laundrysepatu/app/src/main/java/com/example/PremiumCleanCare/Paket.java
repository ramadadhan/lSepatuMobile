package com.example.PremiumCleanCare;

public class Paket {

        private String nama;
        private String keterangan;
        private String harga;

        public Paket(String nama, String keterangan, String harga) {
            this.nama = nama;
            this.keterangan = keterangan;
            this.harga = harga;

        }

        public String getNama() {
            return nama;
        }
        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getKeterangan() {
            return keterangan;
        }
        public void setKeterangan(String keterangan) {
            this.keterangan = keterangan;
        }

        public String getHarga() {
            return harga;
        }
        public void setHarga(String harga) {
            this.harga = harga;
        }

}
