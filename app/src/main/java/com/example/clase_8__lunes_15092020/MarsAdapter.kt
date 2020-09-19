package com.example.clase_8__lunes_15092020

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clase_8__lunes_15092020.model.Terrain
import kotlinx.android.synthetic.main.item_list_view.view.*

class MarsAdapter(var mpassMars: Mars) : RecyclerView.Adapter<MarsAdapter.TaskViewHolder>() { //Paso 4

    private var dataList = emptyList<Terrain>() //Paso1

    fun updateListMars(mDataList: List<Terrain>){ //Paso2

        dataList = mDataList
        notifyDataSetChanged()
    }

   inner class TaskViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{ //Paso 3
       val imgTerrain = itemView.imageView
       val itemView = itemView.setOnClickListener(this)

       override fun onClick(p0: View?) { //paso 5
         mpassMars.passMars(dataList[adapterPosition])
       }
   }
// Esto aparece despues del paso 4
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {     //paso 4.1
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent ,false)
        return TaskViewHolder(itemView)

        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) { //paso 4.2

        val mTerrain: Terrain = dataList[position]

       Glide.with(holder.itemView.context).load(mTerrain.imgSrc).into(holder.imgTerrain)

    }

    override fun getItemCount() = dataList.size    //Paso 4.3

    interface Mars {
        fun passMars(mTerrain: Terrain)

    }
}