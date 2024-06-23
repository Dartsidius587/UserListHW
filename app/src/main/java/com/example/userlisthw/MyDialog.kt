package com.example.userlisthw

import android.content.Context
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MyDialog {
    companion object{
        fun createDialog(context: Context, adapter: ArrayAdapter<String>) =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                val builder = AlertDialog.Builder(context)
                val note = adapter.getItem(position)
                builder.setTitle("Внимание!")
                    .setIcon(R.drawable.icon_delete)
                    .setMessage("Удалить пользователя: $note")
                    .setCancelable(true)
                    .setPositiveButton("Да"){ dialog, whith ->
                        adapter.remove(note)
                        Toast.makeText(context,"Пользователь удален: $note", Toast.LENGTH_LONG).show()
                    }
                    .setNegativeButton("Нет"){dialog, whith ->
                        dialog.cancel()
                    }.create()
                builder.show()
            }
    }
}