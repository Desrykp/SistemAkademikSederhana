package com.client.loginmultiuserapp.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.client.loginmultiuserapp.R
import com.client.loginmultiuserapp.models.User
import kotlinx.android.synthetic.main.activity_admin_main.*
import kotlinx.android.synthetic.main.activity_user_main.*

class AdminMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_main)

        btnBuatkelas.setOnClickListener {
            val intent = Intent(this, BuatKelas::class.java)
            startActivity(intent)
        }

//        val tampung = findViewById<TextView>(R.id.admin_txt_name)
//        val user = intent.getParcelableExtra<User>("DATA_USER")
//        tampung.setText("Halo ${user?.namaLengkap} kamu login sebagai ${user?.hakAkses}")

//        val user = intent.getParcelableExtra<User>("DATA_USER")
//        admin_txt_name.setText("Halo ${user?.namaLengkap} kamu login sebagai ${user?.hakAkses}")
    }
}