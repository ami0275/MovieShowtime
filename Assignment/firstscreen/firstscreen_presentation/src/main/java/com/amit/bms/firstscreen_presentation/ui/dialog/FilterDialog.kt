package com.amit.bms.firstscreen_presentation.ui.dialog

import android.view.View
import com.amit.bms.common_utils.ItemClickListener
import com.amit.bms.firstscreen_presentation.base.BaseBottomSheetDialogFragment
import com.amit.bms.firstscreen_presentation.databinding.ItemShowDateBinding
import javax.inject.Inject

class FilterDialog @Inject constructor():
    BaseBottomSheetDialogFragment<ItemShowDateBinding>(ItemShowDateBinding::inflate),ItemClickListener<Any> {
    override fun initializeViews() {
        //TODO("Not yet implemented")
    }

    override fun initializeObservers() {
       // TODO("Not yet implemented")
    }

    override fun onClick(item: Any, position: Int, view: View) {
       // TODO("Not yet implemented")
    }
}