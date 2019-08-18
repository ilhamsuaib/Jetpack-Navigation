package dev.ilhamsuaib.navi.main

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dev.ilhamsuaib.navi.R
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * Created by @ilhamsuaib on 2019-08-18.
 * github.com/ilhamsuaib
 */

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() = view?.run {
        val navController = (context as Activity).findNavController(R.id.mainNavHost)
        btnGoToFirst.setOnClickListener {
            navController.navigate(R.id.actionGoToFirstFragment, Bundle().apply {
                putString("name", "Ilham at First Fragment")
            })
        }
        btnGoToSecond.setOnClickListener {
            navController.navigate(R.id.actionGoToSecondFragment, Bundle().apply {
                putString("name", "Ilham at Second Fragment")
            })
        }
    }
}