package com.natallia.radaman.imed.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natallia.radaman.imed.R
import com.natallia.radaman.imed.data.model.People
import kotlinx.android.synthetic.main.person_list_item.view.*

class PeoplesListAdapter(
    private val items: List<People>,
    private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Creates view for each item in the list of people
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_list_item, parent, false)
        return ViewHolder(view)
    }

    /**
     * Binds view with information about appropriate person
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(items[position], clickListener)
    }

    /**
     * Returns the size of person list
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * Creates view for item, sets person information and click events
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(people: People, listener: OnItemClickListener) = with(itemView) {
            view_person_name.text = people.name
            view_where_met_text.text = people.metAt
            contact_button.text = people.contact
            contact_button.setOnClickListener {
                // Dial contact number
                val dialIntent = android.content.Intent(android.content.Intent.ACTION_DIAL)
                dialIntent.data = android.net.Uri.parse("tel:${people.contact}")
                itemView.context.startActivity(dialIntent)
            }

            // RecyclerView on item click
            setOnClickListener {
                listener.onItemClick(people, it)
            }
        }
    }

    /**
     * Notifies click on an appropriate person (item) with attached view
     */
    interface OnItemClickListener {
        fun onItemClick(people: People, itemView: View)
    }
}
