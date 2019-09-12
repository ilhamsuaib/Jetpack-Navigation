package dev.ilhamsuaib.navi.ui.home

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import dev.ilhamsuaib.navi.R
import dev.ilhamsuaib.navi.adapter.HomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by @ilhamsuaib on 2019-09-11.
 * github.com/ilhamsuaib
 */

class HomeFragment : Fragment() {

    private val homeAdapter = GroupAdapter<ViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        getItems()
    }

    private fun setupView() = view.run {
        rvHome.run {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }

        fabNewItem.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_firstStepFragment)
        }
    }

    private fun getItems() {
        homeAdapter.clear()
        repeat(30) {
            homeAdapter.add(HomeAdapter {
                findNavController().navigate(R.id.action_home_to_detailFragment)
            })
        }
    }
}