package com.natallia.radaman.imed.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.natallia.radaman.imed.IMedApp
import com.natallia.radaman.imed.data.model.People

class PeopleDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val peopleRepository = getApplication<IMedApp>().getPeopleRepository()
    private val peopleId = MutableLiveData<Int>()

    // Maps people id to people details
    fun getPeopleDetails(id: Int): LiveData<People> {
        peopleId.value = id
        val peopleDetails =
            Transformations.switchMap<Int, People>(peopleId) { id ->
                peopleRepository.findPeople(id)
            }

        return peopleDetails
    }
}