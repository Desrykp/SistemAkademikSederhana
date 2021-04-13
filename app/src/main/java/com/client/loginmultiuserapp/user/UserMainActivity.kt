package com.client.loginmultiuserapp.user

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.client.loginmultiuserapp.*
import com.client.loginmultiuserapp.admin.KelasActivity
import kotlinx.android.synthetic.main.activity_user_main.*

class UserMainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main)

        tv_lihatDetail.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        rl_arsipHome.setOnClickListener {
            val intent = Intent(this, KosongActivity::class.java)
            startActivity(intent)
        }

        img_jadwal.setOnClickListener {
            val intent = Intent(this, KosongActivity::class.java)
            startActivity(intent)
        }

        cdv_les.setOnClickListener {
            val intent = Intent(this, RuangLes::class.java)
            startActivity(intent)
        }

        cdv_baca.setOnClickListener {
            val intent = Intent (this, KosongActivity::class.java)
            startActivity(intent)
        }

        cdv_cerita.setOnClickListener {
            val intent = Intent (this, RuangCerita::class.java)
            startActivity(intent)
        }

        cdv_uji.setOnClickListener {
            val intent = Intent (this, KosongActivity::class.java)
            startActivity(intent)
        }

        cdv_class.setOnClickListener {
            val intent = Intent (this, KelasActivity::class.java)
            startActivity(intent)
        }

        cdv_vidio.setOnClickListener {
            val intent = Intent(this, RuangVideo::class.java)
            startActivity(intent)
        }

        cdv_kelas1.setOnClickListener {
            val intent = Intent(this, MateriActivity::class.java)
            startActivity(intent)
        }

        cdv_kelas2.setOnClickListener {
            val intent = Intent(this, MateriActivity::class.java)
            startActivity(intent)
        }

        cdv_kelas3.setOnClickListener {
            val intent = Intent(this, MateriActivity::class.java)
            startActivity(intent)
        }

        cdv_kelas4.setOnClickListener {
            val intent = Intent(this, MateriActivity::class.java)
            startActivity(intent)
        }

        cdv_kelas5.setOnClickListener {
            val intent = Intent(this, MateriActivity::class.java)
            startActivity(intent)
        }

        cdv_kelas6.setOnClickListener {
            val intent = Intent(this, MateriActivity::class.java)
            startActivity(intent)
        }

        cdv_kelas7.setOnClickListener {
            val intent = Intent(this, MateriActivity::class.java)
            startActivity(intent)
        }

//        val tampung = findViewById<TextView>(R.id.user_txt_name)
//        val user = intent.getParcelableExtra<User>("DATA_USER")
//        tampung.setText("Halo ${user?.namaLengkap} kamu login sebagai ${user?.hakAkses}")

//        val user = intent.getParcelableExtra<User>("DATA_USER")
//        user_txt_name.setText("Halo ${user?.namaLengkap} kamu login sebagai ${user?.hakAkses}")
    }
}