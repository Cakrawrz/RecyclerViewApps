package com.bangkit.recyclerviewapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListHeroAdapter(private val heroList:ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.HeroViewHolder>() {

    var onItemClick : ((Hero) -> Unit)? = null

    class HeroViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription : TextView = itemView.findViewById(R.id.tv_item_description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata, parent, false)
        return HeroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        holder.imgPhoto.setImageResource(hero.photo)
        holder.tvName.text = hero.name
        holder.tvDescription.text = hero.description

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(hero)
        }
    }
}

