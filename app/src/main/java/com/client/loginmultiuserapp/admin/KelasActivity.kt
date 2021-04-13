package com.client.loginmultiuserapp.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.client.loginmultiuserapp.KosongActivity
import com.client.loginmultiuserapp.R
import kotlinx.android.synthetic.main.activity_kelas.*

class KelasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelas)

        kelasAadmin.setOnClickListener {
            val intent = Intent(this, Tambah::class.java)
            startActivity(intent)
        }

        kelasBadmin.setOnClickListener {
            val intent = Intent(this, Tambah::class.java)
            startActivity(intent)
        }

        kelasCadmin.setOnClickListener {
            val intent = Intent(this, Tambah::class.java)
            startActivity(intent)
        }

        kelasDadmin.setOnClickListener {
            val intent = Intent(this, Tambah::class.java)
            startActivity(intent)
        }

        kelasEadmin.setOnClickListener {
            val intent = Intent(this, Tambah::class.java)
            startActivity(intent)
        }

        kelasFadmin.setOnClickListener {
            val intent = Intent(this, Tambah::class.java)
            startActivity(intent)
        }

        kelasGadmin.setOnClickListener {
            val intent = Intent(this, Tambah::class.java)
            startActivity(intent)
        }
    }
}