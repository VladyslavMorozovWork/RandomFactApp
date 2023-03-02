package com.example.randomfactapp.common

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.randomfactapp.utils.onClick

abstract class BaseBindingViewHolder<in D, VB : ViewBinding>(
    protected val binding: VB,
    onItemClick: ((position: Int) -> Unit)? = null
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.onClick {
            if (bindingAdapterPosition != RecyclerView.NO_POSITION) {
                onItemClick?.invoke(bindingAdapterPosition)
            }
        }
    }

    abstract fun bindData(item: D)

    fun withBinding(block: (VB.() -> Unit)) {
        binding.apply {
            block.invoke(this)
        }
    }
}