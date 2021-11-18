package com.watermelon.moviesapp.ui.detailsTv.moredetails

import com.watermelon.moviesapp.model.response.tv.details.ProductionCompany
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.detailsTv.TvDetailsInteractionListener
import watermelon.moviesapp.R


class MoreDetailsAdapter (list: List<ProductionCompany>, listener: TvDetailsInteractionListener) :
    BaseAdapter<ProductionCompany>(list, listener) {
    override var layoutID = R.layout.item_production_companies_tv
}