package com.googleimages.adapter.databindingadapter

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding


abstract class DataBoundAdapter<T : ViewDataBinding>
/**
 * Creates a DataBoundAdapter with the given item layout
 *
 * @param layoutId The layout to be used for items. It must use data binding.
 */
    (
    @param:LayoutRes @field:LayoutRes
    private val mLayoutId: Int
) : BaseDataBoundAdapter<T>() {

    override fun getItemLayoutId(position: Int): Int {
        return mLayoutId
    }
}