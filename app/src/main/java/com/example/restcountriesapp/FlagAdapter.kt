package com.example.restcountriesapp


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FlagAdapter(
    private val context: Context,
    private val countryList: List<Country>
) : RecyclerView.Adapter<FlagAdapter.FlagViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FlagViewHolder {
        return FlagViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.country_flag,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: FlagViewHolder, position: Int) {
        val country = countryList[position].name
        val flag = countryList[position].flags.png

        holder.country.text = country
        Picasso.get().load(flag).into(holder.flag);
    }

    override fun getItemCount() = countryList.size

    class FlagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val country = itemView.findViewById<TextView>((R.id.country))
        val flag = itemView.findViewById<ImageView>((R.id.flag))
    }

}
