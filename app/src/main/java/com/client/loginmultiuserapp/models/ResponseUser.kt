package com.client.loginmultiuserapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseUser(

	@field:SerializedName("data")
	val data: User? = null,

	@field:SerializedName("is_success")
	val isSuccess: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
) : Parcelable

@Parcelize
data class User(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("hak_akses")
	val hakAkses: String? = null,

	@field:SerializedName("nama_lengkap")
	val namaLengkap: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null
) : Parcelable
