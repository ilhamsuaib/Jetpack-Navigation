package dev.ilhamsuaib.navi.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.plusAssign
import androidx.navigation.ui.setupWithNavController
import dev.ilhamsuaib.navi.R
import dev.ilhamsuaib.navi.common.KeepStateNavigator
import kotlinx.android.synthetic.main.fragment_home_container.view.*

/**
 * Created by @ilhamsuaib on 2019-09-11.
 * github.com/ilhamsuaib
 */

class HomeContainerFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeNavController: NavController = requireActivity().findNavController(R.id.homeContainerNavHost)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.homeContainerNavHost)!!
        val navigator = KeepStateNavigator(requireContext(), navHostFragment.childFragmentManager, R.id.homeContainerNavHost)
        homeNavController.navigatorProvider.plusAssign(navigator)
        homeNavController.setGraph(R.navigation.nav_home)

        view.bottomNav.setupWithNavController(homeNavController)
    }
}