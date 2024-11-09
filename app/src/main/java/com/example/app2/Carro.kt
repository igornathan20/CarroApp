package com.example.app2
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
class Carro(
    val carroImage: Int,
    val modelo: String,
    val marca: String,
    val torc: String,
    val potencia: String,
    val consumo: String,
    val tabelaFipe: String,

): Parcelable