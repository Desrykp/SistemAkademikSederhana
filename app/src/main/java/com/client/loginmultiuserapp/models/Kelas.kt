package com.client.loginmultiuserapp.models

import java.io.Serializable

data class Kelas (
    val nkelas : String,
    val nMentor : String,
    val nJadwal: String,
    val nDeskripsi: String,
    var explainable: Boolean = false){

}
