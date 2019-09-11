package dev.ilhamsuaib.navi.common

import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Created by @ilhamsuaib on 2019-09-11.
 * github.com/ilhamsuaib
 */

fun Fragment.toast(s: String) {
    Toast.makeText(requireContext(), s, Toast.LENGTH_LONG).show()
}