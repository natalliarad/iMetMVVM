package com.natallia.radaman.imed.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.natallia.radaman.imed.R
import com.natallia.radaman.imed.data.model.People
import kotlinx.android.synthetic.main.fragment_people_details.*

/**
 * The Fragment to show person details
 */
class PeopleDetailsFragment : Fragment() {

    private lateinit var viewModel: PeopleDetailsViewModel

    /**
     * ViewModelProviders.of(this) creates a ViewModelProvider, which retains ViewModels while a
     * scope of given fragment is alive.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(PeopleDetailsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_people_details, container, false)
    }

    /**
     * Within onViewCreated(...) get people details with provided id.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val peopleId = arguments?.getInt(getString(R.string.people_id))
        peopleId?.let {
            viewModel.getPeopleDetails(peopleId).observe(this, Observer { peopleDetails ->
                populatePeopleDetailView(peopleDetails)
            })
        }
    }

    /**
     * Binds people information into views
     */
    private fun populatePeopleDetailView(people: People?) {
        view_person_name.text = people?.name
        view_where_met_text.text = people?.metAt
        contact_button.text = people?.contact
        text_view_email.text = people?.email
        text_view_facebook.text = people?.facebook
        text_view_linked_in.text = people?.linkedIn
    }
}
