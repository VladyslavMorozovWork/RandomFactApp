package com.example.randomfactapp.common

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T, VH : BaseBindingViewHolder<T, *>>(itemDifCallback: DiffUtil.ItemCallback<T>) : ListAdapter<T, VH>(itemDifCallback) {

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindData(getItem(position))
    }
}