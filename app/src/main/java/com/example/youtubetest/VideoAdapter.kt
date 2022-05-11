package com.example.youtubetest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubetest.databinding.GridViewItemBinding

class VideoAdapter(private val onClick: (View) -> Unit) :
    RecyclerView.Adapter<VideoAdapter.ViewHolder>()
{
    private var list: ArrayList<String> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = list[position]
        holder.binding.wvVideo.loadUrl(video)
        holder.binding.wvVideo.setOnClickListener{
            //start to play
            onClick(it)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(newItems: List<String>) {
        for(p in newItems){
            list.add(p)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(
        val binding: GridViewItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GridViewItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}

