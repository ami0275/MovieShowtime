package com.amit.bms.firstscreen_presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.amit.bms.common_utils.ListItem
import com.amit.bms.common_utils.utils.getRandomNumbersInRange
import com.amit.bms.firstscreen_presentation.R
import com.amit.bms.firstscreen_presentation.databinding.ItemShowTimeBinding
import com.amit.bms.firstscreen_presentation.models.ShowtimeDTO


class ShowTimesAdapter(
    private val playingStyleList: MutableList<ShowtimeDTO>,
    private val listener: (data: ShowtimeDTO, position: Int) -> Unit
) : RecyclerView.Adapter<ShowTimesAdapter.ShowTimesItemViewHolder>() {

    class ShowTimesItemViewHolder(
        val binding: ItemShowTimeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun initShowTimes(item: ShowtimeDTO, listener: (data: ShowtimeDTO, position: Int) -> Unit) {
            binding.apply {

                // setting value using data binding
                data = item
                executePendingBindings()

                tvShowTime.setOnClickListener {
                    listener.invoke(item, adapterPosition)
                }
                if(getRandomNumbersInRange(1,10)>5){
                    val color = ContextCompat.getColor(tvShowTime.context, R.color.disabled)
                    val tColor = ContextCompat.getColor(tvShowTime.context, R.color.black)
                    tvShowTime.apply {
                        setTextColor(tColor)
                        setBackgroundColor(color)
                        isClickable=false
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowTimesItemViewHolder {
        val binding =
            ItemShowTimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ShowTimesItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowTimesItemViewHolder, position: Int) {
        holder.initShowTimes(playingStyleList[position], listener)
    }

    override fun getItemCount() = playingStyleList.size
}