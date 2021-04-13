package com.client.loginmultiuserapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.client.loginmultiuserapp.adapter.RecyclerAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_materi.*
import java.util.*

class MateriActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerAdapter

    private var materiList = mutableListOf<String>()
    private var displayList = mutableListOf<String>()

    private lateinit var deletedMateri: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

        btn_absenMurid.setOnClickListener {
            val intent = Intent(this, SimpanAbsen::class.java)
            startActivity(intent)
        }

        materiList.add("Materi Pertemuan Pertama")
        materiList.add("Pertemuan Kedua")
        materiList.add("Pertemuan Ketiga")
        materiList.add("Pertemuan Keempat")
        materiList.add("Pertemuan Kelima")
        materiList.add("Pertemuan keenam")
        materiList.add("Pertemuan Ketujuh")
        materiList.add("Pertemuan Kedelapan")
        materiList.add("Pertemuan Kesembilan")
        materiList.add("Pertemuan Kesepuluh")

        displayList.addAll(materiList)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerAdapter = RecyclerAdapter(displayList)

        recyclerView.adapter = recyclerAdapter

        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        swipeRefresh.setOnRefreshListener {
            displayList.clear()
            displayList.addAll(materiList)
            recyclerView.adapter!!.notifyDataSetChanged()
            swipeRefresh.isRefreshing = false
        }

    }

    private var simpleCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP.or(ItemTouchHelper.DOWN), ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT)){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            var  startPosition =  viewHolder.adapterPosition
            var endPosition = target.adapterPosition

            Collections.swap(displayList, startPosition, endPosition)
            recyclerView.adapter?.notifyItemMoved(startPosition, endPosition)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            var position = viewHolder.adapterPosition

            when(direction){
                ItemTouchHelper.LEFT -> {
                    deletedMateri = displayList.get(position)
                    displayList.removeAt(position)
                    recyclerAdapter.notifyItemRemoved(position)

                    Snackbar.make(recyclerView, "$deletedMateri is deleted", Snackbar.LENGTH_LONG).setAction("Undo", View.OnClickListener {
                        displayList.add(position, deletedMateri)
                        recyclerAdapter.notifyItemInserted(position)
                    }).show()
                }
                ItemTouchHelper.RIGHT -> {
                    var editText = EditText(this@MateriActivity)
                    editText.setText(displayList[position])

                    val builder = AlertDialog.Builder(this@MateriActivity)
                    builder.setTitle("Update an Item")
                    builder.setCancelable(true)
                    builder.setView(editText)

                    builder.setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which ->
                        displayList.clear()
                        displayList.addAll(materiList)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    })
                    builder.setPositiveButton("update", DialogInterface.OnClickListener{ dialog, which ->
                        displayList.set(position, editText.getText().toString())
                        recyclerView.adapter!!.notifyItemChanged(position)
                    })

                    builder.show()
                }
            }
        }
    }
}