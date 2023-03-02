package com.example.randomfactapp.presentation.mainscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.randomfactapp.common.BaseBindingViewHolder
import com.example.randomfactapp.databinding.ItemFactBinding
import com.example.randomfactapp.domain.models.UiFactModel
import com.example.randomfactapp.utils.onClick

class FactListHolder(
    binding: ItemFactBinding,
    private var interactor: Interactor
) : BaseBindingViewHolder<UiFactModel, ItemFactBinding>(binding) {

    companion object {
        fun from(parent: ViewGroup, interactor: Interactor): FactListHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemFactBinding.inflate(layoutInflater, parent, false)
            return FactListHolder(binding, interactor)
        }
    }

    override fun bindData(item: UiFactModel) {
        withBinding {
            factTextView.text = item.factText
            root.onClick {
                interactor.onFactClicked(item)
            }
        }
    }

    interface Interactor {
        fun onFactClicked(item: UiFactModel)
    }
}