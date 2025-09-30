package com.example.retofittodo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retofittodo.databinding.ItemTodoBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodoViewHolder {
        return TodoViewHolder(
            ItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: TodoViewHolder,
        position: Int
    ) {
        holder.binding.apply {
            val todo : ToDoDTO = todos[position]
            itemTodoText.text = todo.title
            itemTodoCheckBox.isChecked = todo.completed
        }
    }

    override fun getItemCount(): Int = todos.size


    private val diffCallback = object : DiffUtil.ItemCallback<ToDoDTO>() {
        override fun areItemsTheSame(
            oldItem: ToDoDTO,
            newItem: ToDoDTO
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ToDoDTO,
            newItem: ToDoDTO
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var todos: List<ToDoDTO>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


}