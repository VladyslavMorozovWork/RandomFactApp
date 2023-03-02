package com.example.randomfactapp.presentation.mainscreen

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.randomfactapp.common.BaseAdapter
import com.example.randomfactapp.domain.models.UiFactModel

class FactListAdapter constructor(
    private var interactor: FactListHolder.Interactor
) : BaseAdapter<UiFactModel, FactListHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactListHolder {
        return FactListHolder.from(parent, interactor)
    }
}

class DiffCallback : DiffUtil.ItemCallback<UiFactModel>() {

    override fun areItemsTheSame(oldItem: UiFactModel, newItem: UiFactModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UiFactModel, newItem: UiFactModel): Boolean {
        return oldItem == newItem
    }
}