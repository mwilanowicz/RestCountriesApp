package com.example.restcountriesapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://restcountries.com/"

class HomeFragment : Fragment() {

    private var mContext: Context? = null

    lateinit var recyclerView: RecyclerView
    lateinit var capitalAdapter: CapitalAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.capitalRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(mContext)

        getMyData();

        return view
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PlaceholderApi::class.java)

        val retrofitData = retrofitBuilder.getCountries()

        retrofitData.enqueue(object : Callback<List<Country>?> {
            override fun onResponse(
                call: Call<List<Country>?>,
                response: Response<List<Country>?>
            ) {
                val responseBody = response.body()!!

                capitalAdapter = CapitalAdapter(requireContext(), responseBody)
                capitalAdapter.notifyDataSetChanged()
                recyclerView.adapter = capitalAdapter

            }

            override fun onFailure(call: Call<List<Country>?>, t: Throwable) {

            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}