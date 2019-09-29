package com.sandeep.todolist

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_todo.*

class CreateTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_todo)

        saveButton.setOnClickListener {
            var title = ""
            title = if (important.isChecked) {
                "⚠️"+ titleEdit.text.toString()
            } else {
                titleEdit.text.toString()
            }

            val prefs = getSharedPreferences("com.sandeep.todolist.sharedprefs", Context.MODE_PRIVATE)
            val todos = prefs.getStringSet("todostrings", setOf())?.toMutableSet()
            todos?.add(title)
            prefs.edit().putStringSet("todostrings", todos).apply()

            finish()
        }
    }
}
