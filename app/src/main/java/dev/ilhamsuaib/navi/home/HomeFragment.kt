package dev.ilhamsuaib.navi.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import dev.ilhamsuaib.navi.R
import dev.ilhamsuaib.navi.adapter.HomeAdapter
import dev.ilhamsuaib.navi.common.toast
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
        val mainNavController = requireActivity().findNavController(R.id.mainNavHost)
        btnGoToFirst.setOnClickListener {
            mainNavController.navigate(R.id.action_to_fist_step)
        }

        btnGoToOther.setOnClickListener {
            mainNavController.navigate(R.id.action_to_other_dest)
        }

        rvHome.run {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }
    }

    private fun getItems() {
        homeAdapter.clear()
        repeat(30) {
            homeAdapter.add(HomeAdapter(this::toast))
        }
    }
}