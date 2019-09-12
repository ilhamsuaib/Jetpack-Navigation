package dev.ilhamsuaib.navi.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.ilhamsuaib.navi.R
import dev.ilhamsuaib.navi.common.toast

/**
 * Created by @ilhamsuaib on 2019-08-18.
 * github.com/ilhamsuaib
 */

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val mIntent = activity?.intent
        val uri = mIntent?.data
        toast("Uri : ${uri.toString()}")
    }
}