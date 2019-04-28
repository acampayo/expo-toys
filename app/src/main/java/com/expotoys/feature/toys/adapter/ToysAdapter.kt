package com.expotoys.feature.toys.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.expotoys.common.core.domain.model.Toy

class ToysAdapter(
    private val toys: List<Toy>
): RecyclerView.Adapter<ToysAdapter.ViewHolder>() {

    override fun getItemCount() = toys.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToysAdapter.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ToysAdapter.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(toy: Toy) = with(itemView){

        }
    }
}
