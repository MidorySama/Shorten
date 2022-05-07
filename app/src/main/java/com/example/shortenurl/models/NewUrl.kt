package com.example.shortenurl.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class NewUrl(
    var alias: String = "",
    var links: String = ""
) : Parcelable
