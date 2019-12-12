package com.natallia.radaman.imed.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.natallia.radaman.imed.IMedApp
import com.natallia.radaman.imed.data.model.People

class PeoplesListViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * Returns a repository of people
     */
    private val peopleRepository = getApplication<IMedApp>().getPeopleRepository()
    /**
     * MediatorLiveData is a LiveData subclass which may observe other LiveData objects and react
     * on OnChanged events from them.
     */
    private val peopleList = MediatorLiveData<List<People>>()

    init {
        getAllPeople()
    }

    fun getAllPeople() {
        peopleList.addSource(peopleRepository.getAllPeople()) { peoples ->
            peopleList.postValue(peoples)
        }
    }

    fun getPeopleList(): LiveData<List<People>> {
        return peopleList
    }

    fun searchPeople(name: String) {
        peopleList.addSource(peopleRepository.findPeople(name)) { peoples ->
            peopleList.postValue(peoples)
        }
    }
}