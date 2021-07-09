package me.user.androidApp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import me.user.shared.Conference


class ConferenceListAdapter(context: Context, users: List<Conference>) :
    ArrayAdapter<Conference>(context, R.layout.list_row, users.toMutableList()) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val conference = getItem(position)
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        }
        val title: TextView = convertView!!.findViewById(R.id.txtTitle)
        title.text = conference!!.name
        return convertView
    }
}