package com.client.loginmultiuserapp.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.client.loginmultiuserapp.R
import kotlinx.android.synthetic.main.activity_buat_kelas.*

class BuatKelas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buat_kelas)

        smpnKelas.setOnClickListener {
            val intent = Intent(this, KelasActivity::class.java)
            startActivity(intent)
        }
    }
}