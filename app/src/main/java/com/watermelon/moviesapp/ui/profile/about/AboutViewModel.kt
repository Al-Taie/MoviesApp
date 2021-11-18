package com.watermelon.moviesapp.ui.profile.about

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.person.Person
import com.watermelon.moviesapp.ui.home.HomeInteractionListener
import com.watermelon.moviesapp.ui.profile.ProfileInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AboutViewModel: ViewModel(), ProfileInteractionListener {
    var person = MutableLiveData<State<Person?>>()

    override fun onItemLoad(id: Int) {
        viewModelScope.launch {
            MovieRepository.getProfile(id).collect {
                person.postValue(it)
            }
        }
    }

    override fun onItemClicked(id: Int) {
    }
}