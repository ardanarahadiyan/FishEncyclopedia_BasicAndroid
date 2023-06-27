package com.dicoding.fishcollection

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView

class ListFishAdapter (private val listFish:ArrayList<Fish>): RecyclerView.Adapter<ListFishAdapter.ListViewHolder>() {


    /*private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Fish)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }*/

    class ListViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val imgPicture : ImageView = itemView.findViewById(R.id.img_item_picture)
        val tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription : TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_fish, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listFish.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(name, description, picture) = listFish[position]
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.imgPicture.setImageResource(picture)


        holder.itemView.setOnClickListener{
            val intenDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intenDetail.putExtra("key_fish", listFish[holder.adapterPosition])
            holder.itemView.context.startActivity(intenDetail)
        }

    }
}