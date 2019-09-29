package com.sandeep.todolist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_item.view.*

class TodoAdapter(val todos: List<String>?): RecyclerView.Adapter<TodoAdapter.TodoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        return TodoHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false))
    }

    override fun getItemCount(): Int {
        return todos?.count()!!
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        var todo = todos?.get(position)
        holder.bindTodos(todo)
    }

    class TodoHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
        var view: View = v
        var text: String = ""

        init {
            v.setOnClickListener(this)
        }

        fun bindTodos(todo: String?) {
            this.text = todo!!
            view.todoItem.text = todo
        }

        override fun onClick(p0: View?) {
            val intent = Intent(view.context, CompleteTodoActivity::class.java)
            intent.putExtra("title", text)
            startActivity(view.context, intent, null)
        }
    }
}
