package com.client.loginmultiuserapp.guru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.client.loginmultiuserapp.R
import com.client.loginmultiuserapp.SimpanAbsen

class AbsenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen)

        val btnSimpanabsen = findViewById<Button>(R.id.btnSimpanAbsen)
        btnSimpanabsen.setOnClickListener {
            startActivity(Intent(this, SimpanAbsen::class.java))
        }
    }
}