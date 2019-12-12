package com.natallia.radaman.imed

import android.app.Application
import com.natallia.radaman.imed.data.PeopleRepository

class IMedApp : Application() {

    /**
     * Provides centralised People Repository throughout the app
     */
    fun getPeopleRepository() = PeopleRepository(this)
}