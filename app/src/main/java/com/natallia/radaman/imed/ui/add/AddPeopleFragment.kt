package com.natallia.radaman.imed.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.natallia.radaman.imed.R
import com.natallia.radaman.imed.data.model.People
import kotlinx.android.synthetic.main.fragment_add_people.*

/**
 * The Fragment to add people
 */
class AddPeopleFragment : Fragment() {

    private lateinit var viewModel: AddPeopleViewModel

    /**
     * ViewModelProviders.of(this) creates a ViewModelProvider, which retains ViewModels while a
     * scope of given fragment is alive.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        viewModel = ViewModelProviders.of(this).get(AddPeopleViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_people, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_add_people, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add -> {
                savePeopleInformation()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    /**
     * Saves people info from user input and returns to PeopleListActivity
     */
    private fun savePeopleInformation() {
        val people = People(
            text_input_name.editText?.text.toString(),
            text_input_met_at.editText?.text.toString(),
            text_input_contact.editText?.text.toString(),
            text_input_email.editText?.text.toString(),
            text_input_facebook.editText?.text.toString(),
            text_input_linked_in.editText?.text.toString()
        )
        viewModel.addPeople(people)

        view?.let {
            Navigation.findNavController(it).navigateUp()
        }
    }
}