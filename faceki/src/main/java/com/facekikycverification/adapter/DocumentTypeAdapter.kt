package com.facekikycverification.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.facekikycverification.R
import com.facekikycverification.databinding.ItemDocumentTypeBinding
import com.facekikycverification.model.DocumentType
import com.facekikycverification.model.LocalCache

class DocumentTypeAdapter : RecyclerView.Adapter<DocumentTypeAdapter.DocumentTypeViewHolder>() {

    var list: MutableList<DocumentType> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentTypeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_document_type, parent, false)
        return DocumentTypeViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DocumentTypeViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    fun submitList(list: MutableList<DocumentType>) {
        this.list.apply {
            clear()
            addAll(list)
        }
    }

    inner class DocumentTypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding: ItemDocumentTypeBinding? = null

        init {
            binding = DataBindingUtil.bind(view)
        }

        fun bind(item: DocumentType, position: Int) {
            binding?.ivYes?.visibility = if (item.isSelected) View.VISIBLE else View.INVISIBLE
            binding?.tvDocName?.text = item.documentName
            binding?.ivDocImg?.setImageResource(item.icon)
            binding?.cvDocName?.setOnClickListener {
                list = list.map { it.copy(isSelected = false) }.toMutableList()
                list[position] = list[position].copy(isSelected = true)
                LocalCache.documentType = item.docType
                notifyDataSetChanged()
            }
        }
    }
}
