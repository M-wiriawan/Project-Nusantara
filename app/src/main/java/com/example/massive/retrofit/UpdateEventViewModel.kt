package com.example.massive.retrofit

data class UpdateEventViewModel(
    val id: Int,
    val judul: String,
    val deskripsi: String,
    val tanggal: Int,
    val kategori: String,
    val foto: String,
    val kode: String
)
