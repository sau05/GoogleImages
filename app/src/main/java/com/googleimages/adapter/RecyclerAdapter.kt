package com.googleimages.adapter

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.googleimages.R
import com.googleimages.adapter.databindingadapter.DataBoundAdapter
import com.googleimages.adapter.databindingadapter.DataBoundViewHolder
import com.googleimages.databinding.ListItemBinding
import com.googleimages.model.Item

class RecyclerAdapter(
    searchResultActivity: Context,
    items: List<Item>?, listener: ItemClickListener
) : DataBoundAdapter<ListItemBinding>(R.layout.list_item) {

    private val mContext = searchResultActivity
    private val items = items
    private val listener = listener
    override fun bindItem(holder: DataBoundViewHolder<ListItemBinding>, position: Int, payloads: List<Any>) {
        holder.binding.tvTitle.text = items?.get(position)?.title
        Glide.with(mContext).load(items?.get(position)?.pagemap?.cseThumbnail?.get(0)?.src)
            .apply(
                RequestOptions.placeholderOf(R.mipmap.ic_launcher).override(100, 100)
            )
            .into(holder.binding.imageView)
        holder.binding.imageView.setOnClickListener {
            listener.imageItemClick(items?.get(position))
        }
    }

    override fun getItemCount(): Int {
        return items?.size!!
    }

    interface ItemClickListener {
        fun imageItemClick(item: Item?)
    }
}