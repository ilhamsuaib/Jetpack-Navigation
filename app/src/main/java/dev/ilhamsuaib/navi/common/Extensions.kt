package dev.ilhamsuaib.navi.common

import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

/**
 * Created by @ilhamsuaib on 2019-09-11.
 * github.com/ilhamsuaib
 */

inline fun <reified T> T.logD(s: String) {
    val tag = T::class.java.simpleName
    Log.d(tag, s)
}

fun Fragment.toast(s: String) {
    Toast.makeText(requireContext(), s, Toast.LENGTH_LONG).show()
}

fun ImageView.loadImage(id: Int) {
    Glide.with(this).load(id).into(this)
}