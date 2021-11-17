package com.watermelon.moviesapp.ui.detailsTv.moreDetails

import com.watermelon.moviesapp.model.response.tv.details.ProductionCompany
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.HomeInteractionListener
import watermelon.moviesapp.R


class MoreDetailsAdapter (list: List<ProductionCompany>, listener: HomeInteractionListener) :
    BaseAdapter<ProductionCompany>(list, listener) {
    override var layoutID = R.layout.item_production_companies_tv
}