package com.client.loginmultiuserapp.guru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.client.loginmultiuserapp.*
import com.client.loginmultiuserapp.admin.KelasActivity
import kotlinx.android.synthetic.main.activity_guru.*

class GuruActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guru)

        tv_lihatDetailm.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        cdvjadwalMentor.setOnClickListener {
            val intent = Intent(this, KosongActivity::class.java)
            startActivity(intent)
        }

        tv_Downloadm.setOnClickListener {
            val intent = Intent(this, KosongActivity::class.java)
            startActivity(intent)
        }

        cdv_lesm.setOnClickListener {
            val intent = Intent(this, RuangLes::class.java)
            startActivity(intent)
        }

        cdv_bacam.setOnClickListener {
            val intent = Intent (this, KosongActivity::class.java)
            startActivity(intent)
        }

        cdv_ceritam.setOnClickListener {
            val intent = Intent (this, RuangCerita::class.java)
            startActivity(intent)
        }

        cdv_ujim.setOnClickListener {
            val intent = Intent (this, KosongActivity::class.java)
            startActivity(intent)
        }

        cdv_classm.setOnClickListener {
            val intent = Intent (this, KelasActivity::class.java)
            startActivity(intent)
        }

        cdv_vidiom.setOnClickListener {
            val intent = Intent(this, RuangVideo::class.java)
            startActivity(intent)
        }

        cdvwebMentor.setOnClickListener {
            val intent = Intent(this, MateriActivity::class.java)
            startActivity(intent)
        }

        cdvAndroMentor.setOnClickListener {
            val intent = Intent(this, MateriActivity::class.java)
            startActivity(intent)
        }

        cdvUiuxMentor.setOnClickListener {
            val intent = Intent(this, MateriActivity::class.java)
            startActivity(intent)
        }

        cdvCcMentor.setOnClickListener {
            val intent = Intent(this, MateriActivity::class.java)
            startActivity(intent)
        }

//        val tampung = findViewById<TextView>(R.id.guru_txt_name)
//        val user = intent.getParcelableExtra<User>("DATA_USER")
//        tampung.setText("Halo ${user?.namaLengkap} kamu login sebagai ${user?.hakAkses}")

//        val user = intent.getParcelableExtra<User>("DATA_USER")
//        admin_txt_name.setText("Halo ${user?.namaLengkap} kamu login sebagai ${user?.hakAkses}")
    }
}