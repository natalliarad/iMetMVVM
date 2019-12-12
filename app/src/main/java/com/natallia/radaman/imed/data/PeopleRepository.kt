package com.natallia.radaman.imed.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.natallia.radaman.imed.data.db.PeopleDao
import com.natallia.radaman.imed.data.db.PeopleDatabase
import com.natallia.radaman.imed.data.model.People
import com.natallia.radaman.imed.data.net.PeopleInfoProvider

class PeopleRepository(application: Application) {

    private val peopleDao: PeopleDao

    init {
        val peopleDatabase = PeopleDatabase.getInstance(application)
        peopleDao = peopleDatabase.peopleDao()
    }

    /**
     * Returns the list of all people in reverse order (latest note is on the top)
     */
    fun getAllPeople(): LiveData<List<People>> {
        return peopleDao.getAll()
    }

    /**
     * Adds a new people information in the people list
     */
    fun insertPeople(people: People) {
        peopleDao.insert(people)
    }

    /**
     * Finds people with specific id
     */
    fun findPeople(id: Int): LiveData<People> {
        return peopleDao.find(id)
    }

    /**
     * Find people with specific name
     */
    fun findPeople(name: String): LiveData<List<People>> {
        return peopleDao.findBy(name)
    }

    /**
     * Search people with similar name
     */
    fun searchPeople(name: String): List<People> {
        var peoples = mutableListOf<People>()
        for (people in PeopleInfoProvider.peopleList) {
            if (people.name.toLowerCase().contains(name.toLowerCase())) {
                peoples.add(people)
            }
        }

        return peoples
    }
}