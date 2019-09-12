package dev.ilhamsuaib.navi.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by @ilhamsuaib on 2019-09-12.
 * github.com/ilhamsuaib
 */

@Parcelize
data class Person(
    val firsName: String,
    val lastName: String
) : Parcelable