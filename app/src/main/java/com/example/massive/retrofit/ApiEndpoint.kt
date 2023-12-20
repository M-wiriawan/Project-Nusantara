package com.example.massive.retrofit


import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.PUT


interface ApiEndpoint {

    @FormUrlEncoded
    @POST("register.php")
    fun performUserSignIn(
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("email") email: String
    ): Call<ApiResponse>


    @FormUrlEncoded
    @POST("login.php")
    fun performUserLogin(@Field("name") name: String, @Field("password") password: String): Call<ApiResponse>

    @FormUrlEncoded
    @POST("buat_event.php")
    fun performbuat_event(
        @Field("Judul") Judul: String,
        @Field("Deskripsi") Deskripsi: String,
        @Field("Tanggal") Tanggal: String,
        @Field("Kategori_Acara") Kategori_Acara: String,
        @Field("Gambar_Acara") Gambar_Acara: String,
        @Field("Kode_Acara") Kode_Acara: String
    ): Call<ApiResponse>

}