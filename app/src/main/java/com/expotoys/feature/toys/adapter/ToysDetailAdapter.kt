package com.expotoys.feature.toys.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.expotoys.R
import kotlinx.android.synthetic.main.adapter_toy_detail.view.*

class ToysDetailAdapter(
    private val photos: List<String>
): RecyclerView.Adapter<ToysDetailAdapter.ViewHolder>() {

    override fun getItemCount() = photos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToysDetailAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_toy_detail, parent, false)
    )

    override fun onBindViewHolder(holder: ToysDetailAdapter.ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(photos[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            photo: String
        ) = with(itemView){
            photo.firstOrNull().let {
                Glide.with(this.context.applicationContext)
                    .load(it)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(toy_image)
            }
        }
    }
}
