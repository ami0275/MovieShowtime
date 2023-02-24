package com.amit.bms.firstscreen_presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amit.bms.common_utils.utils.SpacingItemDecorator
import com.amit.bms.firstscreen_presentation.databinding.SelectTimeTheaterBinding
import com.amit.bms.firstscreen_presentation.models.ShowtimeDTO
import com.amit.bms.firstscreen_presentation.models.VenueDTO


class ShowListMainAdapter(
    castList: List<VenueDTO>,
    private val listener: (data: ShowtimeDTO, position: Int) -> Unit
) : RecyclerView.Adapter<ShowListMainAdapter.MainItemViewHolder>() {

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_VALUE = 1
    }

    private var venues: MutableList<VenueDTO> = mutableListOf()

    init {
        this.venues = castList.toMutableList()
    }

    class MainItemViewHolder(
        private val binding: SelectTimeTheaterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun initShowListItem(
            venue: VenueDTO?,
            listener: (data: ShowtimeDTO, position: Int) -> Unit
        ) {
            venue?.let { venueData ->
                binding.apply {
                    tvTheaterName.text = venueData.name
                    showTimeRv.apply {
                        adapter = ShowTimesAdapter(
                            venueData.showtimes as MutableList<ShowtimeDTO>,
                            listener
                        )
                        val x =
                            (resources.displayMetrics.density * 4).toInt() //converting dp to pixels
                        showTimeRv.addItemDecoration(SpacingItemDecorator(x))
                        showTimeRv.layoutManager = GridLayoutManager(context, 3)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        val binding =
            SelectTimeTheaterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainItemViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.initShowListItem(venues?.get(position), listener)
    }

    override fun getItemCount() = venues?.size ?: 0

    fun updateList(newList: List<VenueDTO>) {
        venues?.let { castList ->
            castList.clear()
            castList.addAll(newList)
            notifyDataSetChanged()
        }
    }
}