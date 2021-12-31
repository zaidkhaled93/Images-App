package com.zaidkhaled.imagescatalog.ui.base.adapter

import android.view.View

interface OnItemClickListener<T> {
    fun onItemClicked(view: View? = null, parentView: View? = null, item: T? = null, position: Int)
}