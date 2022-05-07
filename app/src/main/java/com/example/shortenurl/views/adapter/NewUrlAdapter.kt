package com.example.shortenurl.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.shortenurl.R
import com.example.shortenurl.models.NewUrl

class NewUrlAdapter(
    private val dataSource: MutableList<NewUrl>,
    var onListHitItemClickListener: ((newUrl: NewUrl) -> Unit),
    val context: Context
) : RecyclerView.Adapter<NewUrlAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var url: TextView = view.findViewById(R.id.nameUrl) as TextView
        var root: ConstraintLayout =
            view.findViewById(R.id.item_list_url) as ConstraintLayout
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.addNewUrl, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
/*
        viewHolder.name.text = dataSource[position].name
        viewHolder.authorB.text = dataSource[position].authorB

        Glide.with(context) // Asi se cargan las imagenes de la nube
            // .load(context.getDrawable(dataSource[position].productPhoto))
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .circleCrop()

        viewHolder.root.setOnClickListener {
            onListHitItemClickListener.invoke(dataSource[position])
        }*/
    }

    override fun getItemCount() = dataSource.size
}

)