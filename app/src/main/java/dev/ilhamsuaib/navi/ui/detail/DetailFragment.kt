package dev.ilhamsuaib.navi.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dev.ilhamsuaib.navi.R
import kotlinx.android.synthetic.main.fragment_detail.view.*

/**
 * Created by @ilhamsuaib on 2019-08-18.
 * github.com/ilhamsuaib
 */

class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //from implicit deepLink
        val mIntent = activity?.intent
        val uri = mIntent?.data
        uri?.let {
            view.tvDetail.text = it.toString()
        }

        //from safe args or explicit deepLink
        args.name?.let {
            view.tvDetail.text = it
        }
    }
}