package com.amit.bms.firstscreen_presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.amit.bms.firstscreen_presentation.R
import com.amit.bms.firstscreen_presentation.databinding.ItemShowDateBinding

import com.amit.bms.firstscreen_presentation.model.CalendarDateModel


class ShowDateAdapter(
    private val listener: (calendarDateModel: CalendarDateModel, position: Int) -> Unit
) : RecyclerView.Adapter<ShowDateAdapter.ShowDateItemViewHolder>() {

    private val calenderList = mutableListOf<CalendarDateModel>()

    class ShowDateItemViewHolder(
        val binding: ItemShowDateBinding
    ) : RecyclerView.ViewHolder(binding.cardCalendar.rootView) {
        fun initCalenderVH(
            calendarDateModel: CalendarDateModel,
            listener: (calendarDateModel: CalendarDateModel, position: Int) -> Unit
        ) {
            binding.apply {
                if (calendarDateModel.isSelected) {
                    tvCalendarDay.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.white
                        )
                    )
                    tvCalendarDate.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.white
                        )
                    )
                    cardCalendar.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.colorPrimary
                        )
                    )
                } else {
                    tvCalendarDay.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.black
                        )
                    )
                    tvCalendarDate.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.black
                        )
                    )
                    cardCalendar.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.white
                        )
                    )
                }

                tvCalendarDay.text = calendarDateModel.calendarDay
                tvCalendarDate.text = calendarDateModel.calendarDate
                cardCalendar.setOnClickListener {
                    listener.invoke(calendarDateModel, adapterPosition)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowDateItemViewHolder {
        val binding =
            ItemShowDateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ShowDateItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowDateItemViewHolder, position: Int) {
        holder.initCalenderVH(calenderList[position], listener)
    }

    override fun getItemCount() = calenderList.size

    fun setData(calendarList: ArrayList<CalendarDateModel>) {
        calenderList.clear()
        calenderList.addAll(calendarList)
        notifyDataSetChanged()
    }
}