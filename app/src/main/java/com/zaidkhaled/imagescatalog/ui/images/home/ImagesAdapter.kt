package com.zaidkhaled.imagescatalog.ui.images.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zaidkhaled.imagescatalog.R
import com.zaidkhaled.imagescatalog.data.models.responses.ImageResponse
import com.zaidkhaled.imagescatalog.databinding.RowImageBinding
import com.zaidkhaled.imagescatalog.ui.base.adapter.BaseAdapter
import javax.inject.Inject

class ImagesAdapter @Inject constructor() :
    BaseAdapter<ImageResponse?, ImagesAdapter.ViewHolder>() {

    class ViewHolder(val view: RowImageBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = DataBindingUtil.inflate<RowImageBinding>(
            inflater,
            R.layout.row_image, parent, false
        )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.image = items[position]

        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClicked(it, it, get(position), position)
        }
    }

}