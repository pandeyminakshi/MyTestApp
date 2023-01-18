package com.example.mytestapp.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestapp.databinding.ItemListViewBinding
import com.example.mytestapp.model.CityListItems

class SubListAdapter(private var citylistItems: MutableList<CityListItems>) :
    RecyclerView.Adapter<SubListAdapter.HomeViewHolder>(),
    Filterable {
    private lateinit var context: Context
    private var filteredImages: MutableList<CityListItems> =
        mutableListOf<CityListItems>().apply {
            addAll(citylistItems)
        }

    inner class HomeViewHolder(private val binding: ItemListViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: CityListItems) {
            binding.tvItemName.text = data.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemListViewBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(filteredImages[position])
    }

    override fun getItemCount(): Int = filteredImages.size

    override fun getFilter(): Filter = FilterData()

    inner class FilterData : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {

            filteredImages = if (constraint == null || constraint.isEmpty()) {
                citylistItems
            } else {
                val newList = mutableListOf<CityListItems>()
                citylistItems.filter {
                    it.name.lowercase().contains(constraint.toString().lowercase())
                }.forEach {
                    newList.add(it)
                }
                newList
            }

            return FilterResults().apply { values = filteredImages }
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            filteredImages =
                if (results?.values == null) mutableListOf() else results.values as MutableList<CityListItems>
            notifyDataSetChanged()
        }
    }

    fun updateList(newImages: MutableList<CityListItems>) {
        citylistItems.clear()
        filteredImages.clear()
        citylistItems.addAll(newImages)
        filteredImages.addAll(citylistItems)
        notifyDataSetChanged()
    }
}