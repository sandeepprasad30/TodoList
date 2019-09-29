package com.sandeep.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_complete_todo.*

class CompleteTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_todo)

        val todo = intent.extras?.getString("title")
        todoTitle.text = todo

        completeButton.setOnClickListener {
            var prefs = getSharedPreferences("com.sandeep.todolist.sharedprefs", Context.MODE_PRIVATE)
            var todos = prefs.getStringSet("todostrings", setOf())?.toMutableSet()

            todos?.remove(todo)
            prefs.edit().putStringSet("todostrings", todos).apply()
            finish()
        }
    }
}
