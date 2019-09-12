package dev.ilhamsuaib.navi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.ilhamsuaib.navi.R

/**
 * Created by @ilhamsuaib on 2019-09-11.
 * github.com/ilhamsuaib
 */

class NotificationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }
}