package com.example.PremiumCleanCare;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("inputpesan.php")
    Call<AddLaundry> tambahLaundry(
//          @Field("id") int id,
            @Field("nama") String nama,
            @Field("alamat") String alamat,
            @Field("mereksepatu") String mereksepatu,
            @Field("keterangan") String keterangan,
            @Field("color") int color
//          @Field("img") int img;
    );
}
