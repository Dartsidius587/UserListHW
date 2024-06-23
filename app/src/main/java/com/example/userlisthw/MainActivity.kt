package com.example.userlisthw

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private var usersList: MutableList<String> = mutableListOf()
    private lateinit var programTileTB: Toolbar
    private lateinit var addUserBTN: Button
    private lateinit var listLV: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_exit -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private val launchSomeActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, usersList)
        if (result.resultCode == RESULT_OK) {

            listLV.adapter = adapter
            val data = result.data
            val name = data!!.getStringExtra("name")
            val email = data.getStringExtra("email")
            usersList.add(name + "\n" + email)
            adapter.notifyDataSetChanged()
        }
        listLV.onItemClickListener =
        MyDialog.createDialog(this, adapter)

    }

    private fun init() {
        setContentView(R.layout.activity_main)
        programTileTB = findViewById(R.id.programTileTB)
        setSupportActionBar(programTileTB)
        title = "База данных пользователей"
        programTileTB.subtitle = "Версия 1.0"

        addUserBTN = findViewById(R.id.addUserBTN)
        addUserBTN.setOnClickListener {
            val intent = Intent(this, ActivityInputUsers::class.java)
            launchSomeActivity.launch(intent)
        }
        listLV = findViewById(R.id.listLV)

    }

}