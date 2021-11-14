package com.watermelon.moviesapp.ui.profile

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movieCredits.MovieCredits
import com.watermelon.moviesapp.model.response.person.Person
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import com.watermelon.moviesapp.ui.profile.about.AboutFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel(),MovieInteractionListener {
    var person = MutableLiveData<State<Person?>>()
    var movieCredits = MutableLiveData<State<MovieCredits?>>()


    override fun onItemLoad(id: Int) {

        viewModelScope.launch {
            MovieRepository.getProfile(id).collect {
                person.postValue(it)
            }
            MovieRepository.getMovieCredits(id).collect {
                movieCredits.postValue(it)
            }
        }

    }

    override fun onCastClicked(personId: Int) {}
}