package com.client.loginmultiuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.client.loginmultiuserapp.admin.AdminMainActivity
import com.client.loginmultiuserapp.guru.GuruActivity
import com.client.loginmultiuserapp.models.ResponseUser
import com.client.loginmultiuserapp.networking.ApiClient
import com.client.loginmultiuserapp.user.UserMainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // binding layouting
        edtEmail = findViewById(R.id.email)
        edtPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {

            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "email atau password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // panggil api backend dari kode di bawah ini
            ApiClient.getClientAPI().login(
                email, password
            ).enqueue(object : Callback<ResponseUser> {
                override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<ResponseUser>,
                    response: Response<ResponseUser>
                ) {
                  if (response.isSuccessful) {
                      val isSuccess = response.body()?.isSuccess
                      if (isSuccess != null && isSuccess == true) {
                          val hakAkses = response.body()?.data?.hakAkses
                          when (hakAkses) {
                              "admin" -> {
                                  val intent = Intent(this@LoginActivity, AdminMainActivity::class.java)
                                  intent.putExtra("DATA_USER", response.body()?.data)
                                  startActivity(intent)
                              }
                              "user" -> {
                                  val intent = Intent(this@LoginActivity, UserMainActivity::class.java)
                                  intent.putExtra("DATA_USER", response.body()?.data)
                                  startActivity(intent)
                              }
                              "guru" -> {
                                  val intent = Intent(this@LoginActivity, GuruActivity::class.java)
                                  intent.putExtra("DATA_USER", response.body()?.data)
                                  startActivity(intent)
                              }
                          }
                      } else if (isSuccess == false){
                          Toast.makeText(this@LoginActivity, response.body()?.message, Toast.LENGTH_SHORT).show()
                      }
                  } else {
                      Toast.makeText(this@LoginActivity, "Gagal", Toast.LENGTH_SHORT).show()
                  }
                }
            })
        }
    }
}