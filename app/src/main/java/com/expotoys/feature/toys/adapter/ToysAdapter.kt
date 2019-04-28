package com.expotoys.feature.toys.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.expotoys.R
import com.expotoys.common.core.domain.model.Toy
import kotlinx.android.synthetic.main.adapter_toy.view.*

class ToysAdapter(
    private val toys: List<Toy>
): RecyclerView.Adapter<ToysAdapter.ViewHolder>() {

    override fun getItemCount() = toys.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToysAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_toy, parent, false)
    )

    override fun onBindViewHolder(holder: ToysAdapter.ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(toys[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(toy: Toy) = with(itemView){
            name.text = toy.name
            toy.photos.firstOrNull().let {
                Glide.with(this.context.applicationContext)
                    .load(it)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(toy_image)
            }
        }
    }
}
