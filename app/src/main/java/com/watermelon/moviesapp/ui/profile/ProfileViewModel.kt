package com.watermelon.moviesapp.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.person.Person
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel(),MovieInteractionListener {
    var person = MutableLiveData<State<Person?>>()

    override fun onItemClicked(movieId: Int) {
        viewModelScope.launch {
            MovieRepository.getProfile(movieId).collect {
                person.postValue(it)
            }
        }

    }
}