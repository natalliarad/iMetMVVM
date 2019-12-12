package com.natallia.radaman.imed.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.natallia.radaman.imed.R
import com.natallia.radaman.imed.data.model.People
import kotlinx.android.synthetic.main.fragment_peoples_list.*

/**
 * The Fragment to show people list
 */
class PeoplesListFragment : Fragment(),
    PeoplesListAdapter.OnItemClickListener,
    SearchView.OnQueryTextListener,
    SearchView.OnCloseListener {

    private lateinit var searchView: SearchView
    private lateinit var viewModel: PeoplesListViewModel

    /**
     * ViewModelProviders.of(this) creates a ViewModelProvider, which retains ViewModels while a
     * scope of given fragment is alive.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        viewModel = ViewModelProviders.of(this).get(PeoplesListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_peoples_list, container, false)
    }

    /**
     *  Initializes Search View, set appropriate listeners.
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_peoples_list, menu)

        searchView = menu.findItem(R.id.menu_search)?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        searchView.setOnCloseListener(this)
    }

    /**
     * Fab button is used to navigate to add people. Populates people RecyclerView with people info
     * within populatePeopleList(peopleList: List<People>)
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addFab.setOnClickListener {
            view.findNavController().navigate(R.id.action_peoplesListFragment_to_addPeopleFragment2)
        }

        viewModel.getPeopleList().observe(this, Observer<List<People>> { peoples ->
            peoples?.let {
                populatePeopleList(peoples)
            }
        })
    }

    /**
     * Populates peopleRecyclerView with all people info
     */
    private fun populatePeopleList(peopleList: List<People>) {
        peopleRecyclerView.adapter = PeoplesListAdapter(peopleList, this)
    }

    /**
     * Navigates to people details on item click
     */
    override fun onItemClick(people: People, itemView: View) {
        val peopleBundle = Bundle().apply {
            putInt(getString(R.string.people_id), people.id)
        }
        view?.findNavController()
            ?.navigate(R.id.action_peoplesListFragment_to_peopleDetailsFragment2, peopleBundle)
    }

    /**
     * Callback for searchView text change
     */
    override fun onQueryTextChange(newText: String?) = true

    /**
     * Callback for searchView query submit
     */
    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let { viewModel.searchPeople(query) }

        return true
    }

    /**
     * Callback for searchView close
     */
    override fun onClose(): Boolean {
        viewModel.getAllPeople()
        searchView.onActionViewCollapsed()

        return true
    }
}