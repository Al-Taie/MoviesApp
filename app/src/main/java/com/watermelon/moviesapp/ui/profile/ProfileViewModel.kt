package com.watermelon.moviesapp.ui.profile

import androidx.lifecycle.MutableLiveData
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.person.Person
import com.watermelon.moviesapp.ui.base.BaseViewModel
import com.watermelon.moviesapp.ui.home.HomeInteractionListener


class ProfileViewModel : BaseViewModel(), HomeInteractionListener {
    var person = MutableLiveData<State<Person?>>()

    override fun onItemLoad(id: Int) {
        collectValue(MovieRepository.getProfile(id), person)
    }

    override fun onItemClicked(id: Int) {  }


}