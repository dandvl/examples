package mx.devlabs.examples

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter(private val data: Array<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.single_item_list, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt_title.text = data[position]
    }

    class ViewHolder(val parent_view: View) : RecyclerView.ViewHolder(parent_view) {
        val txt_title: TextView = parent_view.findViewById<View>(R.id.text_item) as TextView
    }

}