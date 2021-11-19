package com.watermelon.moviesapp.ui.profile

import androidx.lifecycle.MutableLiveData
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.person.Person
import com.watermelon.moviesapp.ui.base.BaseViewModel
import com.watermelon.moviesapp.ui.home.HomeInteractionListener


class ProfileViewModel : BaseViewModel(), HomeInteractionListener {
    private val _personID = MutableLiveData(0)
    var person = MutableLiveData<State<Person?>>()

    override fun onItemLoad(id: Int) {
        _personID.postValue(id)
        collectValue(MovieRepository.getProfile(id), person)
    }

    override fun onItemClicked(id: Int) {  }

    override fun refresh() {
        _personID.value?.let { onItemLoad(it) }

    }
}