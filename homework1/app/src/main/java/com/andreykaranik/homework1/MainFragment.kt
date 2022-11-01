package com.andreykaranik.homework1

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment() {

    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView

    private lateinit var list : MutableList<SquareItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list = ArrayList<SquareItem>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", adapter.itemCount)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var spanCount = 3
        val orientation = resources.configuration.orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 4
        }
        val layoutManager = GridLayoutManager(context, spanCount)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        adapter = MyAdapter(list)
        recyclerView.adapter = adapter

        val addButton = view.findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            val squareItem = SquareItem(adapter.itemCount)
            list.add(squareItem)
            adapter.notifyDataSetChanged()
        }

        if (savedInstanceState != null) {
            val count = savedInstanceState.getInt("count")
            for (i in 0 until count) {
                list.add(SquareItem(i))
            }
            adapter.notifyDataSetChanged()
        }

    }
}