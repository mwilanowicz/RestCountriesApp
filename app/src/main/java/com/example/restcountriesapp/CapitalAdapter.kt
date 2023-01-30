package com.example.restcountriesapp


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CapitalAdapter(
    private val context: Context,
    private val countryList: List<Country>
) : RecyclerView.Adapter<CapitalAdapter.CapitalViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CapitalViewHolder {
        return CapitalViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.country_capital,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: CapitalViewHolder, position: Int) {
        val country = countryList[position].name
        val capital = countryList[position].capital

        holder.country.text = country
        holder.capital.text = capital
    }

    override fun getItemCount() = countryList.size

    class CapitalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val country = itemView.findViewById<TextView>((R.id.country))
        val capital = itemView.findViewById<TextView>((R.id.capital))
    }

}