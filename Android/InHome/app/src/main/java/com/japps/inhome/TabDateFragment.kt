package com.japps.inhome
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import kotlinx.android.synthetic.main.fragment_tab_date.*

/**
 * A simple [Fragment] subclass.
 */
class TabDateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_date, container, false)
        }
}
