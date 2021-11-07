package com.watermelon.moviesapp.ui.profile

import android.util.Log
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

    override fun onItemLoad(id: Int) {
        viewModelScope.launch {
            MovieRepository.getProfile(id).collect {
                person.postValue(it)
                Log.i("eee", it.toData().toString())
            }
        }

    }

    override fun onCastClicked(personId: Int) {
        TODO("Not yet implemented")
    }
}