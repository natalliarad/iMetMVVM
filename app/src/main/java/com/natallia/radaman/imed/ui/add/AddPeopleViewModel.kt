package com.natallia.radaman.imed.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.natallia.radaman.imed.IMedApp
import com.natallia.radaman.imed.data.model.People

class AddPeopleViewModel(application: Application) : AndroidViewModel(application) {
    /**
     * Returns a repository of people
     */
    private val peopleRepository = getApplication<IMedApp>().getPeopleRepository()

    fun addPeople(people: People) {
        peopleRepository.insertPeople(people)
    }
}