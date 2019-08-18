package dev.ilhamsuaib.navi.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import dev.ilhamsuaib.navi.R
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * Created by @ilhamsuaib on 2019-08-18.
 * github.com/ilhamsuaib
 */

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController: NavController? = activity?.findNavController(R.id.homeNavHost)
        navController?.let { view.btmNavMain.setupWithNavController(it) }
    }
}